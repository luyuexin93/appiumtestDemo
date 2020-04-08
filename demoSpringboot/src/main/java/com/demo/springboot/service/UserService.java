package com.demo.springboot.service;

/** 
* @author 作者 Your-Name: 
* @version 创建时间：2020年4月1日 下午3:30:53 
* 类说明 
*/

import java.util.List;

import com.demo.springboot.entity.User;

public interface UserService {
	/**
	 * 
	 * @param name
	 * @param age
	 * @param email
	 * @return
	 */
	int createUser(String name, Integer age, String email);

	/**
	 * 
	 * @param name
	 * @return
	 */
	List<User> getByName(String name);

	/**
	 * 根据id获取用户详情
	 * 
	 * @param id
	 * @return
	 */
	User getById(Long id);

	/**
	 * 
	 * @param name
	 * @return
	 */
	int deleteByName(String name);

	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 */
	List<User> getAllUsers();

	/**
	 * 
	 * @return
	 */
	int deleteAllUsers();

}
