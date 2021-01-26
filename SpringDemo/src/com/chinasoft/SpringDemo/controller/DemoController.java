package com.chinasoft.SpringDemo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.chinasoft.SpringDemo.pojo.User;

@Controller
/*一级前端虚拟目录 也叫控制层层名
 * 注意 一级虚拟目录 和二级虚拟目录 都是要进url链接
 * 所以尽量小写*/
@RequestMapping("/demo")
public class DemoController  {

	/*控制器器名 二级虚拟目录*/
	@RequestMapping("/test")
	@ResponseBody /*局部的 异步交互控制器声明*/
	public void test(HttpServletRequest request,HttpServletResponse response){
		//System.out.println("我是后端控制器  执行了！！！！");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("abc", "我是谁？");
		map.put("bbb", "成龙");
		
		/*json数据异步交互过程*/
		JSONObject json=new JSONObject();
		json.put("map", map);
	PrintWriter  out=null;
		try {
			//response.setCharacterEncoding("utf-8");
		 	response.setContentType("application/json;charset=utf-8");
			out=response.getWriter();
			out.print(json.toJSONString());
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		}
		//return   JSONObject.toJSON(map);
	}
	
	/*get请求 与post请求 都进后端控制器 执行处理过程*/
	@RequestMapping("/test1")
	public ModelAndView test1(HttpServletRequest request,
			@RequestParam Map<String,Object> map){
		/*注解形式  接收参数*/
		System.out.println(map);
		System.out.println(map);
		System.out.println("我是全局跳转页面！！");
		 /*替换了request 与response的原始跳转过程*/
		/*return 动作处理器对象 跳转*/
 	request.setAttribute("userMain", "IOC返回前端值数据信息");
/*ModelAndView mo=new ModelAndView("test");
String userMain="IOC返回前端值数据信息222";
mo.addObject(userMain);*/
 	return new ModelAndView("index");
		/*return new ModelAndView("forward:/demo/test2");*/
		/*redirect:/  forward:/
		 * 注意区分前缀名 当前默认为 forward:/ request内部跳转为主
		 * */
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2(HttpServletRequest request,
			@RequestParam Map<String,Object> map){
		/*注解形式  接收参数*/
		 
		System.out.println("我是全局跳转页面  接收控制器！！");
		System.out.println(map);
		System.out.println(map);
		 /*替换了request 与response的原始跳转过程*/
		/*return 动作处理器对象 跳转*/
		return new ModelAndView("redirect:/test.jsp");
		/*redirect:/  forward:/
		 * 注意区分前缀名 当前默认为 forward:/ request内部跳转为主
		 * */
	}
	
	/*@RequestMapping(value={"/test3","/markTwoon"})*/
	/*对于比较特殊的异步接口  加一下post异步请求 访问限制过程*/
	@RequestMapping(params={"userName=谢坤坤","userAge=58"},
			value="/test112/{message}",method=RequestMethod.POST)
	@ResponseBody
	public void test3(HttpServletRequest request,HttpServletResponse response,
			@RequestParam Map<String,Object> map,
			  User user,@PathVariable("message") String message ){
		
		System.out.println(JSONObject.toJSON(user));
		System.out.println(JSONObject.toJSON(user));
		JSONObject json=new JSONObject();
		json.put("main", "我是后端异步交互数据");
		json.put("message", message);
		json.put("user", user);
		PrintWriter out=null;
		try {
			response.setContentType("application/json;charset=utf-8");
			  out=response.getWriter();
			out.print(json.toJSONString());
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		}
	}
	
	
}
