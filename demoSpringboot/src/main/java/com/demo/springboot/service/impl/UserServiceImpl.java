package com.demo.springboot.service.impl;

import java.util.List;

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
	private UserDao userdao;

	@Override
	public int createUser(String name, Integer age, String email) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setAge(age);
		user.setEmail(email);
		user.setName(name);
		userdao.addUser(user);
		return 0;
	}

	@Override
	public List<User> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllUsers() {
		// TODO Auto-generated method stub
		return 0;
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
		return userdao.getUserById(id);
	}

}
