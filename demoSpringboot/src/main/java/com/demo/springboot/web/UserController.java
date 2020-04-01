/**
 * 
 */
package com.demo.springboot.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.entity.User;
import com.demo.springboot.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 作者 luyuexin:
 * @version 创建时间：2020年3月31日 下午9:17:33 类说明
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserService userService;
	// 创建线程安全的Map 模拟user信息的存储
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

	/**
	 * @return
	 */
	@GetMapping("/")
	@ApiOperation(value = "获取用户列表")
	public List<User> getUserList() {
		List<User> r = new ArrayList<User>(users.values());
		return r;
	}

	@PostMapping
	@ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
	public String postUser(@Valid @RequestBody User user) {
		users.put(user.getId(), user);
		userService.createUser(user.getName(), user.getAge(), user.getEmail());
		return "success";
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "获取用户详细信息", notes = "根据id获取用户详细信息")
	public User getUser(@PathVariable Long id) {
		return users.get(id);
	}

	@PutMapping("/{id}")
	public String putUser(@PathVariable Long id, @RequestBody User user) {
		User u = users.get(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		u.setEmail(user.getEmail());
		users.put(id, user);
		return "success";
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		users.remove(id);
		return "success";
	}

}
