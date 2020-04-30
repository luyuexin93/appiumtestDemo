package com.demo.springboot.util;

import java.io.File;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;

import net.dongliu.apk.parser.ApkFile;

/**
 * @author luyuexin
 * 解析apk工具类
 */
public class ApkParserUtil {
	
	public ApkFile apkfile;
	
	
	public ApkParserUtil(String apkfilepath)  {
		try {
			this.apkfile = new ApkFile(new File(apkfilepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取apk manifestxml内容
	 * @return manifest.xml
	 */
	private String apkManiXML() {
		String xml = "";
		try {
			xml = apkfile.getManifestXml();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml;
	}

	public String dom4jparseXml() throws DocumentException {
		Document dom =DocumentHelper.parseText(apkManiXML());
		
		return null;
		
	
	}
	
	
	
	public static void main(String args[]) {
		ApkParserUtil apu=new ApkParserUtil("E:\\zjipst.com\\ydjcj\\branches\\2.0\\PoliceAssistant\\app\\build\\outputs\\apk\\oatest\\debug\\app-oatest-debug.apk");
		System.out.println(apu.apkManiXML());
	}
}
