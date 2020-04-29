package com.demo.springboot.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.springboot.entity.User;

@RestController

public class LoginController {
	@GetMapping(value = { "/" })
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		User user = (User) request.getSession().getAttribute("user");
		if (ObjectUtils.isEmpty(user)) {
			mv.setViewName("redirect:/login");
		} else {
			if (StringUtils.isNotBlank(user.getName())) {
				mv.setViewName("page/index");
				mv.addObject(user);
			} else {
				mv.setViewName("redirect:/login");
			}
		}

		return mv;
	}

	@PostMapping("/login")
	public ModelAndView login(User user, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject(user);
		mv.setViewName("redirect:/");
		request.getSession().setAttribute("user", user);
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("page/login");
	}
}
