package com.demo.springboot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.springboot.entity.User;

/**
 * @author 作者 luyuexin:
 * @version 创建时间：2020年4月13日 下午8:46:58 类说明
 */
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User result = new User();
		result.setId(rs.getLong("id"));
		result.setAge(rs.getInt("age"));
		result.setEmail(rs.getString("email"));
		result.setName(rs.getString("name"));
		return result;
	}

}
