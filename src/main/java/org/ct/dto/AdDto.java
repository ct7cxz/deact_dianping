package org.ct.dto;

import org.ct.bean.Ad;
import org.springframework.web.multipart.MultipartFile;

/**
 * 广告转换类
 */
public class AdDto extends Ad {
    private String img;

    private MultipartFile imgFile;


    @Override
    public String toString() {
        return super.toString()+"AdDto{" +
                "img='" + img + '\'' +
                ", multipartFile=" + imgFile +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
}
