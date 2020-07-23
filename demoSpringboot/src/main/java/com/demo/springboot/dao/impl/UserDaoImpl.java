package com.demo.springboot.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Repository;

import com.demo.springboot.dao.UserDao;
import com.demo.springboot.entity.User;
import com.demo.springboot.entity.Zzjg;

/**
 * @author 作者 Your-Name:
 * @version 创建时间：2020年4月1日 下午4:10:51 类说明
 */
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Autowired
	@Qualifier("psc110JdbcTemplate")
	private JdbcTemplate psc110jdbcTemplate;

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stu
		String sql = " select * from user where id= ?";
		List<User> list = jdbcTemplate.query(sql, new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
		if (list.size() > 0 && list != null) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<User> getUserByName(String name) {
		// TODO Auto-generated method stub
		String sql = " select * from user where 1=1";
		if (StringUtils.isNotEmpty(name)) {
			sql += " and name like '%" + name + "' ";
		}
		List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return list;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		String sql = " select * from user ";
		List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		if (list.size() > 0 && list != null) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user(name,age,email) values(?,?,?)";
		int num = jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail());
		return num;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "update user set name=:name, age=:age ,email=:email where id=:id";
		int n = jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
		return n;
	}

	@Override
	public int deleteUser(Long id) {
		// TODO Auto-generated method stub
		String sql = " delete from user where id=:id";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		int n = jdbcTemplate.update(sql, map);
		return n;
	}

	@Override
	public List<User> pageUser(int currentPage, int size, String name, Integer startAge, Integer endAge, String email) {
		// TODO Auto-generated method stub
//		Map<String, Object> map = new HashMap<String, Object>();
		int page = (currentPage * size) - size;
		String sql = "select * from user where 1=1 ";
		if (StringUtils.isNotBlank(name)) {
			sql += " and name like '%" + name + "%' ";
		}
		if (startAge != null) {
			sql += " and age > " + startAge;
		}
		if (endAge != null) {
			sql += " and age < " + endAge;

		}
		if (StringUtils.isNotBlank(email)) {
			sql += " and email like '%" + name + "%' ";
		}

		sql += " order by age desc " + " limit " + page + " , " + size;
		List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return list;
	}

	public Long countUser(int currentPage, int size, String name, Integer startAge, Integer endAge, String email) {
		// TODO Auto-generated method stub
//		Map<String, Object> map = new HashMap<String, Object>();
		int page = (currentPage * size) - size;
		String sql = "select count(*) from user where 1=1 ";
		if (StringUtils.isNotBlank(name)) {
			sql += " and name like '%" + name + "%' ";
		}
		if (startAge != null) {
			sql += " and age > " + startAge;
		}
		if (endAge != null) {
			sql += " and age < " + endAge;

		}
		if (StringUtils.isNotBlank(email)) {
			sql += " and email like '%" + name + "%' ";
		}

		sql += " order by age desc " + " limit " + page + " , " + size;
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
	
	public Zzjg queryZzjg(String jgid) {
		String sql = "select * from ZZJG_ZZJG where 1=1 ";
		if (StringUtils.isNotBlank(jgid)) {
			sql += "and jgid= '" + jgid+"'";
		}
		List<Zzjg> list=psc110jdbcTemplate.query(sql, new BeanPropertyRowMapper<Zzjg>(Zzjg.class));
		
		return list.get(0);
	}
	

}
