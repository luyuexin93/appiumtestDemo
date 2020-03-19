package com.pa.test.util.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4jTest {
	
	public static void main(String [] args) {
		Logger logger = Logger.getLogger(Log4jTest.class);
		BasicConfigurator.configure();
		logger.setLevel(Level.WARN);
		logger.debug("这是debug");
		logger.info("这是info");
		logger.warn("这是warn");
		logger.error("这是error");
		logger.fatal("这是fatal");
	}
}
