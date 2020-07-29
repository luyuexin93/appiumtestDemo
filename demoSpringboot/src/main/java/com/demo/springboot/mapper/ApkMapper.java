package com.demo.springboot.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.springboot.entity.Apk;
import com.mysql.cj.result.Row;

/**
 * @Author luyuexin
 * @date 创建时间：2020年7月23日 下午4:00:28
 * @version 1.0 
 * @return 
 */
public class ApkMapper implements RowMapper<Apk> {

	@Override
	public Apk mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Apk apk = new Apk();
		apk.setId(rs.getString("ID"));
		apk.setPkgname(rs.getString("PKGNAME"));
		apk.setApkname(rs.getString("APKNAME"));
		apk.setVname(rs.getNString("VNAME"));
		apk.setVersionCode(rs.getInt("VERSIONCODE"));
		apk.setMinSDK(rs.getInt("MINSDK"));
		apk.setTagSDK(rs.getInt("TAGSDK"));
		apk.setPubTime(rs.getString("PUBTIME"));
		apk.setFeature(rs.getString("FEATURE"));
		return null;
	}
	

}
