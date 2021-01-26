package com.chinasoft.SpringDemo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping(value="/file",method=RequestMethod.POST)
	public ModelAndView fileUpload(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam Map<String,Object> map,
			MultipartFile uploadfile){
		 /*首先获取  原上传文件的后缀名*/
		System.out.println(uploadfile.getOriginalFilename().substring(uploadfile.getOriginalFilename().lastIndexOf(".")));
		
		/*创建新文件名   一个原则 新文件名不能重复*/
		String newFileName=UUID.randomUUID().toString().replaceAll("-", "")+uploadfile.getOriginalFilename().substring(uploadfile.getOriginalFilename().lastIndexOf("."));
		 /*设置 新文件的上传路径*/
	/*	String newFilePath=request.getSession().getServletContext().getRealPath("/upload/")+newFileName;*/
		/*注意上传文件位置区别 建议上传至文件源码位置  不要上传tomcat部署位置*/
		String newFilePath="D:\\apache-tomcat-9.0.41\\upload\\"+newFileName;
		/*文件加载位置 上传tomcat中*/
		String newFilePath1=request.getSession().getServletContext()
				.getRealPath("/upload/")+newFileName;
		
		/*新文件 对象实例化*/
		File newFile=new File(newFilePath);
		 /*新文件加载 对象实例化*/
		File newFile1=new File(newFilePath1);
		/*利用Spring框架的复制文件方法  将原文件字符内容 复制给新的 实例化文件对象*/
		try {
			uploadfile.transferTo(newFile);
			uploadfile.transferTo(newFile1);
			System.out.println("上传文件成功！");
			request.setAttribute("msg", "上传文件成功！");
			request.setAttribute("newFilePath", "/SpringDemo/upload/"+newFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "上传文件失败！！");
		} 
		/*注意同步跳转  与异步交互 回调数据的区别
		 * 同步跳转  由request带参传值
		 * 异步交互  返回json格式数据*/
		return new ModelAndView("success");
	}
	
	@RequestMapping(value="/axiosFile",method=RequestMethod.POST)
	@ResponseBody
	public void axiosFile(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam Map<String,Object> map,
			MultipartFile uploadfile){
		 /*首先获取  原上传文件的后缀名*/
		System.out.println(uploadfile.getOriginalFilename().substring(uploadfile.getOriginalFilename().lastIndexOf(".")));
		
		/*创建新文件名   一个原则 新文件名不能重复*/
		String newFileName=UUID.randomUUID().toString().replaceAll("-", "")+uploadfile.getOriginalFilename().substring(uploadfile.getOriginalFilename().lastIndexOf("."));
		 /*设置 新文件的上传路径*/
	/*	String newFilePath=request.getSession().getServletContext().getRealPath("/upload/")+newFileName;*/
		/*注意上传文件位置区别 建议上传至文件源码位置  不要上传tomcat部署位置*/
		String newFilePath="D:\\apache-tomcat-9.0.41\\upload\\"+newFileName;
		/*文件加载位置 上传tomcat中*/
		String newFilePath1=request.getSession().getServletContext()
				.getRealPath("/upload/")+newFileName;
		
		/*新文件 对象实例化*/
		File newFile=new File(newFilePath);
		 /*新文件加载 对象实例化*/
		File newFile1=new File(newFilePath1);
		/*利用Spring框架的复制文件方法  将原文件字符内容 复制给新的 实例化文件对象*/
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=null;
		JSONObject json=new JSONObject();
		try {
			out=response.getWriter();
			uploadfile.transferTo(newFile);
			uploadfile.transferTo(newFile1);
			System.out.println("上传文件成功！");
		/*	request.setAttribute("msg", "上传文件成功！");
			request.setAttribute("newFilePath", "/SpringDemo/upload/"+newFileName);*/
			 json.put("msg", "上传文件成功！");
			 json.put("newFilePath", "/SpringDemo/upload/"+newFileName);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//request.setAttribute("msg", "上传文件失败！！");
			 json.put("msg","上传文件失败！！");
		}finally{
			if(out!=null){
				out.print(json.toJSONString());
				out.flush();
				out.close();
			}
			 
		} 
		/*注意同步跳转  与异步交互 回调数据的区别
		 * 同步跳转  由request带参传值
		 * 异步交互  返回json格式数据*/
		/*return new ModelAndView("success");*/
	}
	
	
}
