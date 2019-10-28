package org.ct.service.impl;

import org.ct.util.FileUtil;
import org.ct.dao.IAdDao;
import org.ct.dto.AdDto;
import org.ct.bean.Ad;
import org.ct.service.IAdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdServiceImpl implements IAdService {

    private static final Logger LOG = LoggerFactory.getLogger(AdServiceImpl.class);

    @Autowired
    private IAdDao adDao;

    @Value("${adImage.savePath}")
    private String saveAdImgPath;

    @Value("${adImage.url}")
    private String accessImg;

    @Override
    /**
     * 删除文件
     */
    public boolean saveAd(AdDto adDto) {
        String imgFileName = System.currentTimeMillis() + "_" + adDto.getImgFile().getOriginalFilename();
        Ad ad = new Ad();
        //将图片名称存放到数据库
        BeanUtils.copyProperties(adDto,ad);
        ad.setImgFileName(imgFileName);
        boolean isSaveAd = FileUtil.saveImg(adDto.getImgFile(), saveAdImgPath, imgFileName);
        if (isSaveAd) {
            LOG.info("图片删除成功，删除数据库信息");
            adDao.saveAd(ad);
            return true;
        }
        return false;
    }

    /**
     * 广告信息分页
     * @param adDto
     * @return
     */
    public List<AdDto> findCurrentByPage(AdDto adDto) {
        List<Ad> adList = adDao.findCurrentByPage(adDto);
        List<AdDto> adDtoList = new ArrayList<>();
        for (Ad ad : adList) {
            AdDto nodeAdDto = new AdDto();
            BeanUtils.copyProperties(ad,nodeAdDto);
            adDtoList.add(nodeAdDto);
        }
        return adDtoList;
    }



    /*删除用户的信息*/
    @Override
    public boolean adDelete(Integer id) {
        Ad ad = adDao.showAdUpdate(id);
        Long i = adDao.adDelete(id);
        boolean delete = false;
        if (i == 1) {
            delete = FileUtil.deleteImg(saveAdImgPath, ad.getImgFileName());
        }
        return (i == 1 && delete) ? true : false;
    }

    /*依据id查找用户信息*/
    @Override
    public Ad showAdUpdate(Integer id) {
        return adDao.showAdUpdate(id);
    }

    /*修改当前的用户信息*/
    @Override
    public Boolean adUpdate(AdDto adDto) {
        //查找原来的信息
        Ad oldAd = adDao.showAdUpdate(adDto.getId().intValue());
        //修改新增的信息
        String imgFileName = System.currentTimeMillis() + "_" + adDto.getImgFile().getOriginalFilename();
        Ad ad = new Ad();
        BeanUtils.copyProperties(adDto,ad);
        ad.setImgFileName(imgFileName);

        boolean isSaveAd = false;
        if (adDto.getImgFile() == null || adDto.getImgFile().getSize() == 0) {
            ad.setImgFileName(oldAd.getImgFileName());
        } else {
            isSaveAd = FileUtil.saveImg(adDto.getImgFile(), saveAdImgPath, imgFileName);
            ad.setImgFileName(imgFileName);
        }
        Long i = adDao.updateAd(ad);
        //若修改成功，则删除原来的图片
        if (isSaveAd && i == 1) {
            FileUtil.deleteImg(saveAdImgPath, oldAd.getImgFileName());
            LOG.info("新上传的图片上传成功，删除历史图片");
            return true;
        }
        return true;

    }

    public List<AdDto> findAppCurrent(AdDto adDto) {
        List<AdDto> adDtos = new ArrayList<>();
        List<Ad> adList = adDao.findCurrentByPage(adDto);
        //手动封装不存在的数据源
        for (Ad ad : adList) {
            AdDto nodeAdDto = new AdDto();
            BeanUtils.copyProperties(ad, nodeAdDto);
            nodeAdDto.setImg(this.accessImg + ad.getImgFileName());
            adDtos.add(nodeAdDto);
        }
        return adDtos;
    }
}
