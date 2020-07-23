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

import com.demo.springboot.common.RestResponse;
import com.demo.springboot.entity.User;
import com.demo.springboot.entity.Zzjg;
import com.demo.springboot.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 作者 luyuexin:
 * @version 创建时间：2020年3月31日 下午9:17:33 类说明 用户管理类
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
	@GetMapping("/all")
	@ApiOperation(value = "获取用户列表")
	public RestResponse getUserList() {
		RestResponse response = new RestResponse();
//		List<User> r = new ArrayList<User>(users.values());
		List<User> list = new ArrayList<>();
		list = userService.getAllUsers();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		response.setContent(map);
		return response;
	}

	@PostMapping("/add")
	@ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
	public RestResponse postUser(@Valid @RequestBody User user) {
		RestResponse response = new RestResponse();
		users.put(user.getId(), user);
		userService.createUser(user.getName(), user.getAge(), user.getEmail());
		return response;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "获取用户详细信息", notes = "根据id获取用户详细信息")
	public RestResponse getUser(@PathVariable Long id) {
		RestResponse response = new RestResponse();
		User user = userService.getById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("detail", user);
		response.setContent(map);
		return response;
	}

	@ApiOperation(value = "用户分页查询", notes = "根据条件分页查询用户")
	@PostMapping("/query/page")
	public RestResponse queryBypage(@RequestBody Map<String, Object> params) {
		RestResponse response = new RestResponse();
		if (params == null || params.size() < 1) {
			response.getRequestResult().setSuccess(false);
			response.getRequestResult().setErrorMsg("参数有误");
			return response;
		}
		int currentPage = (int) params.get("currentPage");
		int size = (int) params.get("size");
		String name = (String) params.get("name");
		String email = (String) params.get("email");
		Integer startAge = (Integer) params.get("startAge");
		Integer endAge = (Integer) params.get("endAge");
		Map<String, Object> map = userService.getUserByPage(currentPage, size, name, startAge, endAge, email);
		response.setContent(map);
		return response;
	}

	@PostMapping("/update")
	@ApiOperation(value = "修改用户", notes = "根据User对象创建用户")
	public RestResponse updateUser(@Valid @RequestBody User user) {
		RestResponse response = new RestResponse();
		users.put(user.getId(), user);
		if (user.getId() == null) {
			response.getRequestResult().setSuccess(false);
			response.getRequestResult().setErrorMsg("用户id不存在");
			return response;
		}
		int n = userService.updateUser(user);
		if (n > 0) {
			response.getRequestResult().setSuccess(true);
		} else {
			response.getRequestResult().setSuccess(false);
			response.getRequestResult().setErrorMsg("更新失败");
		}
		return response;

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

	@PostMapping("/queryZzjg")
	@ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
	public RestResponse queryZzjg(@Valid @RequestBody Map<String, Object> params) {
		RestResponse response = new RestResponse();
		String jgid=(String)params.get("jgid");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zzjg", userService.getZzjgById(jgid));
		response.setContent(map);
		return response;
	}
}
