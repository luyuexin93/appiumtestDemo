package com.demo.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.springboot.dao.ApkDao;
import com.demo.springboot.entity.Apk;

/**
 * @Author luyuexin
 * @date 创建时间：2020年7月23日 下午2:43:14
 * @version 1.0 
 * @return 
 */
@Repository
public class ApkDaoImpl implements ApkDao {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Override
	public Apk queryApkById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Apk> queryApkByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Apk> queryApksByPubTime(String pubTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Apk> queryApkByFeature(String feature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addApk(Apk apk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateApk(Apk apk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteApk(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
