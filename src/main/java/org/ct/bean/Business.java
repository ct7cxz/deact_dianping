package org.ct.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
public class Business extends BaseBean implements Serializable {
	private Integer id;
	private String imgFileName;
	private String title;
	private String subTitle;
	private Double price;
	private String distance;
    private String desc;
    private String city;
    private String category;
	private Integer number;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Business{" +
				"id=" + id +
				", imgFileName='" + imgFileName + '\'' +
				", title='" + title + '\'' +
				", subtitle='" + subTitle + '\'' +
				", price=" + price +
				", distance=" + distance +
				", desc='" + desc + '\'' +
				", city='" + city + '\'' +
				", category='" + category + '\'' +
				", cityType=" + cityType +
				", categoryType=" + categoryType +
				'}';
	}



	private Dic cityType;
	private Dic categoryType;

	public Dic getCityType() {
		return cityType;
	}

	public void setCityType(Dic cityType) {
		this.cityType = cityType;
	}

	public Dic getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Dic categoryType) {
		this.categoryType = categoryType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

    public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}