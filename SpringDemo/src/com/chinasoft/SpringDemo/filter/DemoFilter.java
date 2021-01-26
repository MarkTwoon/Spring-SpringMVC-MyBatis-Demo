package com.chinasoft.SpringDemo.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "DemoFilter")
public class DemoFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse response=(HttpServletResponse)resp;
		  response.setCharacterEncoding("utf-8");
		  response.setContentType("application/json;charset=utf-8");
		HttpServletRequest request=(HttpServletRequest)req;
		String path=request.getServletPath();
		System.out.println("我是过滤器");
		System.out.println("过滤"+path+">>>>>>>>>>>>>");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
