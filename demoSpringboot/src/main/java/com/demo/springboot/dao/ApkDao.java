package com.demo.springboot.dao;

import java.util.List;

import org.mapstruct.Mapper;

import com.demo.springboot.entity.Apk;



/**
 * @author  luyuexin
 * @date 创建时间：2020年7月23日 下午2:18:03
 * @version 1.0 
 * @return 
 */
@Mapper
public interface ApkDao {
	Apk queryApkById(String id);

	public List<Apk> queryApkByName(String name);

	public List<Apk> queryApksByPubTime(String pubTime);
	
	public List<Apk> queryApkByFeature(String feature);
	
	public int addApk(Apk apk);

	public int updateApk(Apk apk);

	public int deleteApk(String id);
}
