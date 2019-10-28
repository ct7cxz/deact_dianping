package org.ct.service.impl;

import org.ct.dao.IBusinessDao;
import org.ct.dto.BusinessDto;
import org.ct.bean.Business;
import org.ct.dto.BusinessListDto;
import org.ct.service.IBusinessService;
import org.ct.service.IDicService;
import org.ct.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 商户信息管理service实现类
 */
@Service
public class BusinessServiceImpl implements IBusinessService {

    private static final Logger LOG = LoggerFactory.getLogger(BusinessServiceImpl.class);

    @Autowired
    private IBusinessDao businessDao;

    @Autowired
    private IDicService dicService;

    @Value("${businessImage.savePath}")
    private String saveImagePath;

    @Value("${businessImage.url}")
    private String accessImg;

    /*分页查询*/
    @Override
    public List<BusinessDto> findCurrentByPage(BusinessDto businessDto) {
        List<Business> businessList = businessDao.findCurrentByPage(businessDto);
        List<BusinessDto> businessDtoList = new ArrayList<>();
        for (Business business : businessList) {
            BusinessDto nodeBusiness = new BusinessDto();
            BeanUtils.copyProperties(business, nodeBusiness);
            if (business != null) {
                nodeBusiness.setImg(accessImg + business.getImgFileName());
            }
            businessDtoList.add(nodeBusiness);
        }
        return businessDtoList;
    }

    @Override
    public boolean deleteBusiness(BusinessDto businessDto) {
        Business business = businessDao.findBusiness(businessDto.getId().longValue());
        Long i = businessDao.deleteBusiness(businessDto.getId());
        if (i == 1) {
            FileUtil.deleteImg(saveImagePath, business.getImgFileName());
        }
        return i == 1 ? true : false;
    }

    @Override
    public Business findBusiness(Long id) {
        return businessDao.findBusiness(id);
    }

    @Override
    //TODO  此处待新增字典数据库信息
    public boolean addBusiness(BusinessDto businessDto) {
        Business business = new Business();
        //设置上传图片的名称
        String imgFileName = System.currentTimeMillis() + "_" + businessDto.getFile().getOriginalFilename();
        businessDto.setImgFileName(imgFileName);
        FileUtil.saveImg(businessDto.getFile(), saveImagePath, imgFileName);
        BeanUtils.copyProperties(businessDto, business);
        LOG.info("商户图片上传成功");

        //将商户信息存放到数据库
        Long i = businessDao.addBusiness(business);
        return i == 1 ? true : false;
    }

    @Override
    public boolean updateBusiness(BusinessDto businessDto) {
        Business business = new Business();
        String oldImgName = businessDto.getImgFileName();
        //判断是否上传了新的图片
        MultipartFile file = businessDto.getFile();
        //若上传了，则进行图片修改
        String fileName = null;
        if (file.getSize() != 0 && !"".equals(file)) {
            fileName = System.currentTimeMillis() + "_" + businessDto.getFile().getOriginalFilename();
            businessDto.setImgFileName(fileName);
        }
        BeanUtils.copyProperties(businessDto, business);
        Long i = businessDao.updateBusiness(business);

        if (i == 1 && file.getSize() != 0 && !"".equals(file)) {
            FileUtil.saveImg(file, saveImagePath, fileName);
            FileUtil.deleteImg(saveImagePath, oldImgName);
            return true;
        }
        return false;
    }


    //给app中的信息进行分页操作
    @Override
    public BusinessListDto findAppCurrentByPage(BusinessDto businessDto) {
        if (businessDto.getKeyword() != null) {
            businessDto.setTitle(businessDto.getKeyword());
            businessDto.setSubTitle(businessDto.getKeyword());
            businessDto.setDesc(businessDto.getKeyword());
        }
        List<BusinessDto> currentByPage = this.findCurrentByPage(businessDto);
        System.out.println(businessDto.getPage().getPageCurrent() + "------------------------------");
        businessDto.getPage().setPageCurrent(businessDto.getPage().getPageCurrent() + 1);
        BusinessListDto businessListDto = new BusinessListDto();
        businessListDto.setData(currentByPage);
        if (businessDto.getPage().getPageCurrent() >= businessDto.getPage().getPageTotal()) {
            businessListDto.setHasMore(false);
        } else {
            businessListDto.setHasMore(true);
        }
        return businessListDto;
    }
}
