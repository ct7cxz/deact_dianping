package org.ct.util;

import org.ct.dao.IAdDao;
import org.ct.service.IAdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * 文件的封装类
 */
@Component
public class FileUtil {

    private static final Logger INFO = LoggerFactory.getLogger(FileUtil.class);

    @Autowired
    private IAdService service;

    @Autowired
    private IAdDao dao;

    private static IAdService adService;

    private static IAdDao adDao;

    @PostConstruct
    public void initService() {
        FileUtil.adService = this.service;
    }

    @PostConstruct
    public void initDao() {
        FileUtil.adDao = this.dao;
    }


    //文件的删除
    public static boolean deleteImg(String saveAdImgPath, String imgFileName) {
        File file = new File(saveAdImgPath + imgFileName);
        if (file.exists()) {
            file.delete();
            INFO.info("图片删除成功");
            return true;
        }
        return false;
    }

    //添加新的图片信息
    public static boolean saveImg(MultipartFile imgFile, String saveAdImgPath, String imgFileName) {
        if (imgFile.equals("") || imgFile.getSize() > 0) {
            //获取上传图的完整名称_使用时间防止出现重名
            File file = new File(saveAdImgPath + imgFileName);
            try {
                //判断文件夹是否存在，若不存在则创建
                File fileFolder = new File(saveAdImgPath);
                if (fileFolder.exists()) {
                    fileFolder.mkdirs();
                }
                //上传图片
                imgFile.transferTo(file);
                return true;
            } catch (IOException e) {
                INFO.info("文件上传失败！");
                return false;
            }
        } else {
            INFO.info("上传的文件为空值");
            return false;
        }
    }
}
