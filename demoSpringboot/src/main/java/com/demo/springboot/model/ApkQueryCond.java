package com.demo.springboot.model;
 /**
 * @Author luyuexin
 * @date 创建时间：2020年7月24日 下午3:18:41
 * @version 1.0 
 * @return 
 */
public class ApkQueryCond {
	private String startTime;//发布起始时间
	private String endTimd;  //发布结束时间
	private String feature;  //特性名称
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTimd
	 */
	public String getEndTimd() {
		return endTimd;
	}
	/**
	 * @param endTimd the endTimd to set
	 */
	public void setEndTimd(String endTimd) {
		this.endTimd = endTimd;
	}
	/**
	 * @return the feature
	 */
	public String getFeature() {
		return feature;
	}
	/**
	 * @param feature the feature to set
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}
	
}
