package com.hdc.zs.art.chat;



import com.hdc.zs.art.chat.message.ToServerMessageMine;
import com.hdc.zs.art.chat.message.ToServerMessageTo;
import com.hdc.zs.art.chat.message.ToServerTextMessage;
import com.hdc.zs.art.chat.message.ToServerTextMessageSecond;
import com.hdc.zs.art.chat.socket.MessageSender;
import com.hdc.zs.art.chat.util.LayIMFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * websocket服务端           ---   消息处理中心
 * 
 * @author DELL
 *
 */
@Component
public class webScoketHandler extends TextWebSocketHandler {




	/**
	 * 把sessionId和webSession存储起来 经测试，webSocketSession没有提供无参构造，不能进行序列化，也就不能通过Redis存储
	 * 分布式系统中，要想别的办法实现webSocketSession共享
	 */

	private final boolean first = true;

	//  将 用户的 会话 session 存起来
	private static final Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();


	// 将用户的  id 存起来
	private static final Map<String, String> userIdMap = new ConcurrentHashMap<>();



	/**
	 * webSocket连接创建后调用
	 * 并且生成自动消息，用于招呼访客
	 * 将webSession存于集合
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {


		// 获取sessionID，拿出用户ID
		String userId = String.valueOf(session.getAttributes().get("userId"));

		// 将用户ID存放到 集合
		userIdMap.put(userId, session.getId());

		// 将用户session 存放到集合
		sessionMap.put(session.getId(), session);

		// 构造 消息回复函数
		ToServerTextMessage toServerTextMessage = new ToServerTextMessage();

		// 设置发送类型 为 普通：friend
		toServerTextMessage.setType("friend");

		// 构造发送和接受双方对象。存放信息
		ToServerTextMessageSecond toServerTextMessageSecond = new ToServerTextMessageSecond();

		// 构造发送方对象。存放 发送人信息
		ToServerMessageMine toServerMessageMine = new ToServerMessageMine();

		// 设置发送方ID
		toServerMessageMine.setId("101032");

		// 设置客服头像
		toServerMessageMine.setAvatar("../asserts/avatar/kefu.jpg");

		// 设置问候信息
		toServerMessageMine
				.setContent("你好，欢迎进入校内艺术画展");

		// 设置右侧显示
		toServerMessageMine.setMine(false);

		// 设置客服昵称
		toServerMessageMine.setUsername("线上客服");

		// 设置接收方对象信息
		ToServerMessageTo toServerMessageTo = new ToServerMessageTo();

		// 设置接收方 接受类型
		toServerMessageTo.setType("friend");

		// 设置接收方 接受ID
		toServerMessageTo.setId(userId);

		// 将发送方存对象
		toServerTextMessageSecond.setMine(toServerMessageMine);

		// 将接受方存对象
		toServerTextMessageSecond.setTo(toServerMessageTo);

		// 将发送消息存对象
		toServerTextMessage.setData(toServerTextMessageSecond);

		// 新建发送对象
		MessageSender sender = new MessageSender();

		// 设置发送时延 1秒 不能修改
		Thread.sleep(1000);

		if (!userId.equals("101032")){
			// 发送
			sender.sendMessage(toServerTextMessage);
		}


	}



	/**
	 * 接收到消息后调用
	 * session:JettyWebSocketSession[id=c0e3da74-7a0d-cb04-fdfa-aef4d5c1c7e1,
	 * uri=ws://localhost:9527/mychat] message:TextMessage payload=[100000],
	 * byteCount=6, last=true
	 */
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {


		// message为泛型接口，需要转换成string
		// instanceof运算符用于判断该运算符前面引用类型变量指向的对象是否是后面类，或者其子类、接口实现类创建的对象。
		String msg = message.getPayload();

		// 获取消息类型   客服为默认的friend
		String sendType = getContent("type", msg);

		if (sendType != null) {

			// 处理客服消息
			if ("chatMessage".equals(sendType)) {

				// 序列化处理
				ToServerTextMessage toServerTextMessage =
						LayIMFactory.createSerializer().toObject(msg,
						ToServerTextMessage.class);

				// 新建发送对象
				MessageSender sender = new MessageSender();

				// 发送
				sender.sendMessage(toServerTextMessage);
			} else {
				System.out.println("消息类型不正确");
			}
		}




	}


	/**
	 * 保留 用于数据记录 不会与消息有关
	 * @param session WebSocketSession
	 * @param message WebSocketMessage
	 * @throws Exception 抛出异常
	 */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception
	{
		super.handleMessage(session, message);
	}



	/**
	 * 连接出错后调用
	 * 检测到错误但不处理，并忽略
	 */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub

		// 获取出故障的用户ID
		String userId = String.valueOf(session.getAttributes().get("userId"));

		// 打印错误信息，不做处理
		System.out.println("用户ID："+userId+"; session:"+session.getId()+" 聊天发生故障，暂不处理");

	}



	/**
	 * 连接关闭后调用
				* 将用户的信息清空
				*/
		@Override
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			// TODO Auto-generated method stub

			// 获取调开连接的用户id
			String removeUserId = getUserId(userIdMap, getSessionId(sessionMap, session));

			// 移除相关信息
			userIdMap.remove(removeUserId);

			// 移除相关session
			sessionMap.remove(session.getId());


	}



	/**
	 * 暂时不用，只保留
	 * @return 0
	 */
	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return super.supportsPartialMessages();
	}



	/**
	 * 后端发送消息
	 * 暂时不适用， 保留即可
	 */
	public void sendMessage(String nString) {

	}



	/*
	 * 与客服无关，用户获取 服务器集合数据
	 * get一下即可。
	 */
	public static Map<String, WebSocketSession> getSessionMap() {
		return sessionMap;
	}



	public static Map<String, String> getUserIdMap() {
		return userIdMap;
	}

	/*
	 * 对消息格式化处理   保留 即可。   共调用
	 */
	private String getContent(String content,String json){
		String sendType = null;
		String regex = "(?<=(\"" + content + "\":\")).*?(?=(\"))";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(json);
		while (matcher.find()) {
			if (StringUtils.isNotEmpty(matcher.group().trim())) {
				sendType = matcher.group().trim();
				break;
			}
		}
		return sendType;
	}



	//根据map的value获取map的key
	private static String getUserId(Map<String,String> map,String value){
		String key="";
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if(value.equals(entry.getValue())){
				key=entry.getKey();
			}
		}
		return key;
	}



	//根据map的value获取map的key
	private static String getSessionId(Map<String, WebSocketSession> map, WebSocketSession value){
		String key="";
		for (Map.Entry<String, WebSocketSession> entry : map.entrySet()) {
			if(value.equals(entry.getValue())){
				key=entry.getKey();
			}
		}
		return key;
	}




}
