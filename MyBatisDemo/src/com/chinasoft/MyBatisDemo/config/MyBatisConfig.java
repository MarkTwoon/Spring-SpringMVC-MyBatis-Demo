package com.chinasoft.MyBatisDemo.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
public static  SqlSession openMyBatis(){
	SqlSessionFactory   sqlSessionFactory;
	SqlSession session=null;
	/*注意打开mybatis链接时  读取的是mybatis的  配置管理xml文件*/
	String resource="mybatis.cfg.xml";
	InputStream  inputStream;
	
	try {
		inputStream=Resources.getResourceAsStream(resource);
		/*数据库链接与SQL指令执行过程  统一由sqlSessionFactory代理*/
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		session=sqlSessionFactory.openSession();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return  session;
}
	
public static void closeMyBatis(SqlSession session){
	if(session!=null){
		session.close();
	}
}
	
}
