package com.demo.springboot.entity;

/**
 * @author luyuexin
 * apk信息
 */
public class Apk {
	private String id; //apkid
	private String pkgname; //apk包名
	private String apkname; //应用名称
	private String vname;//版本名称
	private Integer versionCode; //版本号
	private Integer minSDK; //最低版本号
	private Integer tagSDK; //目标版本号
	private String pubTime; //发布时间
	private String feature; //特性
	
	public String getPkgname() {
		return pkgname;
	}
	public void setPkgname(String pkgname) {
		this.pkgname = pkgname;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApkname() {
		return apkname;
	}
	public void setApkname(String apkname) {
		this.apkname = apkname;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getPubTime() {
		return pubTime;
	}
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public Integer getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}
	public Integer getMinSDK() {
		return minSDK;
	}
	public void setMinSDK(Integer minSDK) {
		this.minSDK = minSDK;
	}
	public Integer getTagSDK() {
		return tagSDK;
	}
	public void setTagSDK(Integer tagSDK) {
		this.tagSDK = tagSDK;
	}
	
	
}
