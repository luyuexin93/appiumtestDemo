package com.demo.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.springboot.dao.UserDao;
import com.demo.springboot.entity.User;

/**
 * @author 作者 Your-Name:
 * @version 创建时间：2020年4月1日 下午4:10:51 类说明
 */
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

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
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user(name,age,email) values(?,?,?)";
		int num = jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail());
		return num;
	}

	@Override
	public int updateUser(Integer id, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
