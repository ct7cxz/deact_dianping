package org.ct.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.ct.bean.Business;
import org.springframework.web.multipart.MultipartFile;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessDto extends Business {
    private String img;
    private MultipartFile file;
    private String keyword;
    private Integer star;
    private String mumber;

    @Override
    public String toString() {
        return "BusinessDto{" +
                "img='" + img + '\'' +
                ", file=" + file +
                ", keyword='" + keyword + '\'' +
                ", star=" + star +
                ", mumber='" + mumber + '\'' +
                '}';
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMumber() {
        return mumber;
    }

    public void setMumber(String mumber) {
        this.mumber = mumber;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
