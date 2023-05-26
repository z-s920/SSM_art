package com.hdc.zs.art.chat;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * 过滤器  过滤用户 连接请求
 *   主要用在 获取登录用户的id
 * @author DELL mxd
 *
 */
public class WebSocketInterceptor implements HandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {
		// instanceof运算符用于判断该运算符前面引用类型变量指向的对象是否是后面类，或者其子类、接口实现类创建的对象。
		if (request instanceof ServletServerHttpRequest) {

			// 格式类型转换
			ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;

			// 获取请求路径所携带的参数
			String userid = serverHttpRequest.getServletRequest().getParameter("userId");

			// 存数据
			attributes.put("userId", userid);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 此方法 不管实现， 保留系统默认空信息
	 * @param request ServerHttpRequest
	 * @param response ServerHttpResponse
	 * @param wsHandler WebSocketHandler
	 * @param exception Exception
	 */
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception exception) {
		// TODO Auto-generated method stub

	}

}
