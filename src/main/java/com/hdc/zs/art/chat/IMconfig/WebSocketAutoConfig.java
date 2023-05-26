package com.hdc.zs.art.chat.IMconfig;



import com.hdc.zs.art.chat.WebSocketInterceptor;
import com.hdc.zs.art.chat.socket.MessageSender;
import com.hdc.zs.art.chat.webScoketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


/**
 * Springboot整合聊天的配置类
 *
 */
@Configuration
@EnableWebSocket
public class WebSocketAutoConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// websocket通道
		registry.addHandler(new webScoketHandler(), "/chat").addInterceptors(new WebSocketInterceptor())
				.setAllowedOrigins("*");

	}

	@Bean
	public MessageSender myHandler()
	{
		return new MessageSender();
	}

}
