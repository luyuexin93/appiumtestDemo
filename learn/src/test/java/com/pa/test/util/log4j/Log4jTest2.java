package com.pa.test.util.log4j;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4jTest2 {
//	https://blog.csdn.net/qq_35787138/article/details/81009056?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Log4jTest2.class);
		BasicConfigurator.configure();
		HTMLLayout layout = new HTMLLayout();
		try {
			FileAppender appender = new FileAppender(layout,"output.html",false);
			logger.addAppender(appender);
			logger.setLevel(Level.WARN);
			logger.info("I am info");
			logger.warn("I am warn");
			logger.error("I am error");
			logger.fatal("i am fatal");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
