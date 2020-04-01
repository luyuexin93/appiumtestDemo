package com.demo.springboot.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lu
 *
 */

public class User {
	@ApiModelProperty("用户编号")
	private Long id;
	@NotNull
	@Size(min = 2, max = 5)
	@ApiModelProperty("用户姓名")
	private String name;
	@NotNull
	@Max(100)
	@Min(10)
	@ApiModelProperty("用户年龄")
	private Integer age;
	@Email
	@ApiModelProperty("用户邮箱")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
