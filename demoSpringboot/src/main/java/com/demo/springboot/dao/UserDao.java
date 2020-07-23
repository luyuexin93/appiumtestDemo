package com.demo.springboot.dao;

/** 
* @author luyuexin: 
* @version 创建时间：2020年4月1日 下午4:06:34 
* 类说明 
*/

import java.util.List;

import org.mapstruct.Mapper;

import com.demo.springboot.entity.User;
import com.demo.springboot.entity.Zzjg;

@Mapper
public interface UserDao {

	User getUserById(Long id);

	public List<User> getUserByName(String name);

	public List<User> getUserList();

	public List<User> pageUser(int currentPage, int size, String name, Integer startAge, Integer endAge, String email);

	public Long countUser(int currentPage, int size, String name, Integer startAge, Integer endAge, String email);

	public int addUser(User user);

	public int updateUser(User user);

	public int deleteUser(Long id);
	
	public Zzjg queryZzjg(String jgid);
}
