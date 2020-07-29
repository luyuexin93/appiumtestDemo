package com.demo.springboot.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.ListUtils;

import com.demo.springboot.dao.ApkDao;
import com.demo.springboot.entity.Apk;
import com.demo.springboot.mapper.ApkMapper;
import com.demo.springboot.model.ApkQueryCond;



/**
 * @Author luyuexin
 * @date 创建时间：2020年7月23日 下午2:43:14
 * @version 1.0 
 * @return 
 */
@Repository
public class ApkDaoImpl implements ApkDao {

	@Autowired
	@Qualifier("primaryNamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Apk queryApkById(String id) {
		// TODO Auto-generated method stub
		String sql = " select * from apkinfo where id=：";
		List<Apk> list = namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource("id",id),new ApkMapper());
		if (list.size() > 0 && list != null) {
			return list.get(0);
		} else {
			return null;
		}
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
		String sql = " select * from apkinfo where id=：";
		List<Apk> list = namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource("feature",feature),new ApkMapper());
		if (list.size() > 0 && list != null) {
			return list;
		} else {
			return new ArrayList<Apk>();
		}
	}

	@Override
	public int addApk(Apk apk) {
		String sql = "insert into apkinfo(id,pkgname,apkname,vname,versioncode,minsdk,tagsdk,pubtime,feature) values(:id,:pkgname,:apkname,:vname,:versioncode,:minsdk,:tagsdk,sysdate(),:feature)";
		return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(apk));
	}

	@Override
	public int updateApk(Apk apk) {
		String sql = "update apkinfo set pkgname=:pkgname,apkname=:apkname,vname=:vname,versioncode:versioncode,minsdk=:minsdk,tagsdk=:tagsdk,pubtime=:pubtime,feature=:feature where id=:id";
		return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(apk));
	}

	@Override
	public int deleteApk(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from apkinfo where id=:id";
		return namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id",id));
	}

	@Override
	public List<Apk> queryApk(ApkQueryCond apk) {
		// TODO Auto-generated method stub
		String sql ="select t.* from apkinfo t where 1=1 ";
		if(StringUtils.isNotBlank(apk.getFeature())) {
			sql+=" and t.feature like :feathure";
		}
		if(StringUtils.isNoneBlank(apk.getStartTime())) {
			sql+=" and t.pubtime>=:startTime";
		}
		if(StringUtils.isNoneBlank(apk.getEndTimd())) {
			sql+=" and t.pubtime<=:endTime";
		}
		 List<Apk> list =namedParameterJdbcTemplate.query(sql, new BeanPropertySqlParameterSource(apk), new ApkMapper());
		 if(ListUtils.isEmpty(list)) {
			 return new ArrayList<Apk>();
		 }else {
			 return list; 
		 }
	}

}
