package com.demo.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author luyuexin
 * @date 创建时间：2020年7月23日 下午3:19:15
 * @version 1.0 
 * @return 
 */
public class GenerateIdUtil {
	
	
	/**
	 *  行政区划+时间戳+6位随机数
	 * @param xzqh
	 * @return
	 */
	public static String getBaseRandomId(String xzqh) {
		String datetime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		int sjs=(int)((Math.random()*9+1)*100000);								//6位随机数
		String id=xzqh+datetime+sjs;
		return id;
	}
}

