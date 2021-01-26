package com.chinasoft.SpringDemo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

 
@Controller
public class ErrController  {
	@RequestMapping("/error")
/*	public String handleArithmeticExeption*/
	public void handleArithmeticExeption
	(Exception exception,HttpServletResponse response){
	/*	return "error";*/
		response.setContentType("application/json;charset=utf-8");
	 	JSONObject json=new JSONObject();
		json.put("statCode", "error");
		json.put("message", "数据请求与处理异常！！");
		json.put("data", false);
		PrintWriter out=null;
		try {
			out=response.getWriter();
			out.print(json.toJSONString());
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		} 
	}

}
