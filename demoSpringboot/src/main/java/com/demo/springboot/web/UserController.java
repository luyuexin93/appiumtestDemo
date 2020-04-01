/**
 * 
 */
package com.demo.springboot.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.entity.User;

/**
 * @author 作者 luyuexin:
 * @version 创建时间：2020年3月31日 下午9:17:33 类说明
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
	// 创建线程安全的Map 模拟user信息的存储
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

	/**
	 * @return
	 */
	@GetMapping("/")
	public List<User> getUserList() {
		List<User> r = new ArrayList<User>(users.values());
		return r;
	}

	@PostMapping
	public String postUser(@RequestBody User user) {
		users.put(user.getId(), user);
		return "success";
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return users.get(id);
	}

	@PutMapping("/{id}")
	public String putUser(@PathVariable Long id, @RequestBody User user) {
		User u = users.get(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(id, user);
		return "success";
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		users.remove(id);
		return "success";
	}

}