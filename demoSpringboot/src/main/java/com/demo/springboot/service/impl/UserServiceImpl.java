package com.demo.springboot.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.dao.UserDao;
import com.demo.springboot.entity.User;
import com.demo.springboot.service.UserService;

/**
 * @author 作者luyuexin:
 * @version 创建时间：2020年4月1日 下午4:01:54 类说明
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public int createUser(String name, Integer age, String email) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setAge(age);
		user.setEmail(email);
		user.setName(name);
		userDao.addUser(user);
		return 0;
	}

	@Override
	public List<User> getByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}

	@Override
	public int deleteByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		list = userDao.getUserList();
		return list;
	}

	@Override
	public int deleteAllUsers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
	 * 根据id获取用户信息
	 */
	public User getById(Long id) {
		return userDao.getUserById(id);
	}

	@Override
	public Map<String, Object> getUserByPage(int currentPage, int size, String name, Integer startAge, Integer endAge,
			String email) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> userlist = userDao.pageUser(currentPage, size, name, startAge, endAge, email);
		Long userCount = userDao.countUser(currentPage, size, name, startAge, endAge, email);
		map.put("userList", userlist);
		map.put("userCount", userCount);
		return map;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

}
