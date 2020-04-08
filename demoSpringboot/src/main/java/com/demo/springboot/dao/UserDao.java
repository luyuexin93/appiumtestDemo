package com.demo.springboot.dao;

/** 
* @author 作者 Your-Name: 
* @version 创建时间：2020年4月1日 下午4:06:34 
* 类说明 
*/

import java.util.List;

import org.mapstruct.Mapper;

import com.demo.springboot.entity.User;

@Mapper
public interface UserDao {

	User getUserById(Long id);

	User getUserByName(String name);

	public List<User> getUserList();

	public int addUser(User user);

	public int updateUser(Integer id, User user);

	public int deleteUser(Integer id);
}
