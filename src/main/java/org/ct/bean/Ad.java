package org.ct.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 广告封装类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ad extends BaseBean implements Serializable {
    /*
    {"title":"旅游热线",
    "img":"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191713186-495002222.png",
    "link":"http://www.imooc.com/wap/index"}
     */
    private Long id;
    private String title;
    private String imgFileName;
    private String link;
    private Long weight;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgFileName='" + imgFileName + '\'' +
                ", link='" + link + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
