package com.demo.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 
 * @author luyuexin
 *
 */
@Api(tags = "app版本管理")
@RestController
@RequestMapping(value = "/apk")
public class ApkController {

}
