package com.chinasoft.SpringDemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
	 
	}

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		/*拦截器 执行拦截过程  是最重要的函数方法
		 * 注意过滤器与拦截器的区别  过滤器 前端静态资源+后端访问请求同时过滤
		 * 拦截器作为IOC  只拦截 向后端的Get post等访问交互请求*/
		System.out.println("拦截器 处理请求的拦截");
		HttpSession session=request.getSession();
		
		/* 带项目名的  访问路径
		 * String url=request.getRequestURI();*/
		String path=request.getServletPath();
		/*String contextPath=request.getContextPath();
		 * 后端获取项目名*/
		
		 System.out.println(path+">>>>>>>>>>>>>");
		 
		 /*注意 过滤器与拦截器  只对于url访问JSP页面  拦截器不执行
		  * 其余 访问后端接口IOC控制器路径，访问html文件，访问图片，js等静态资源 
		  * 过滤器与拦截器同时作用  同时出手执行 并且过滤器先执行过滤 拦截器后执行拦截
		  * 
		  * 访问url的时候  过滤器是浏览器 到达url(控制器，静态资源等)之前 执行过程
		  *                            拦截器是 浏览器 到达url(控制器，静态资源等)之后 进行拦截 遣返
		  *                            所以拦截器 要直接重定向 404页面！
		  *                      这也就是 为什么  执行的先后顺序不一致  */
		return true;
	}
	

}
