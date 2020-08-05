package com.demo.springboot.common;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;

/**
 * @Author luyuexin
 * @date 创建时间：2020年8月5日 下午3:28:05
 * @version 1.0 
 * @return 
 */
@DimModule
@Component
public class DatawayModule implements SpringModule{
	
	@Autowired 
	private DataSource primaryDataSource =null;
	@Autowired
	private DataSource psc110DataSource = null;
	@Override
	public void loadModule(ApiBinder apiBinder) throws Throwable {
		// TODO Auto-generated method stub
		apiBinder.installModule(new JdbcModule(Level.Full, this.primaryDataSource));
		apiBinder.installModule(new JdbcModule(Level.Full, "primary",this.primaryDataSource));
		apiBinder.installModule(new JdbcModule(Level.Full, "psc110",this.psc110DataSource));
	}

}
