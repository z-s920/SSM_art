package com.hdc.zs.art.chat.socket;




import com.hdc.zs.art.chat.message.ToClientTextMessage;
import com.hdc.zs.art.chat.message.ToServerMessageMine;
import com.hdc.zs.art.chat.message.ToServerTextMessage;
import com.hdc.zs.art.chat.resulet.ToClientMessageResult;
import com.hdc.zs.art.chat.resulet.ToClientMessageType;
import com.hdc.zs.art.chat.util.LayIMFactory;
import com.hdc.zs.art.chat.webScoketHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Date;



/**
 * 发送信息类 所有从客户端到服务端的消息转发到此类进行消息处理 ToServerTextMessage转换为ToClientTextMessage
 * 如果是单聊，直接从缓存取出对象的session进行消息发送，群聊则需要从缓存中取出该群里所有人的id进行遍历发送消息，
 * 遍历过后需要优化在线与否
 */
@Component
public class MessageSender {




	// 发送信息业务逻辑
	public void sendMessage(ToServerTextMessage message) {




		// 获取接收人
		String toUserId = String.valueOf(message.getData().getTo().getId());




		// 消息提前生成，否则进行循环内生成会浪费资源
		String toClientMessage = getToClientMessage(message);

		//	System.out.println("当前消息类型是:" + type);

		// 不能用==做比较，因为一个是static final 值，另外一个是在对象中 == 为false
			sendMessage(toUserId, toClientMessage);

		// 最后保存到数据库		客服消息   就不对数据库操作了
		// saveMessage(message);

	}



	// 给单个用户发
	@SuppressWarnings({ "static-access" })
	private void sendMessage(String userId, String message) {


		// SocketUser user = LayIMFactory.createManager().getUser(userId);
		// 准备webSocketHandler对象 准备发送消息
		webScoketHandler webScoketHandler = new webScoketHandler();

		// 获取用户ID
		String session_id = webScoketHandler.getUserIdMap().get(userId);

		// 判断 用户是否离店
		if (StringUtils.isEmpty(session_id)) {
			System.out.println("该用户不在线 ");
		} else {

			// 构造用户需要接收到的消息 client.getSession().getAsyncRemote().sendText(message);
			try {

				// 获取接收方 swebession 准备发送
				WebSocketSession webSocketSession = webScoketHandler.getSessionMap()
						.get(webScoketHandler.getUserIdMap().get(userId));

				// 判断获取是否成功
				if (webSocketSession != null){

					// 发送
					webSocketSession.sendMessage(new TextMessage(message));


				}else {


					System.out.println("及时发现，阻止发送");

				}

			} catch (IOException e) {

				// TODO Auto-generated catch block
				System.out.println("发送失败");


			}


		}


	}


	/**
	 * 对用于发送的消息格式化处理   使前端可以正确接受
	 * @param message 消息
	 * @return 0
	 */
	private String getToClientMessage(ToServerTextMessage message) {

		// 新建 接收客户端消息类型对象
		ToClientTextMessage toClientTextMessage = new ToClientTextMessage();

		// 新建发送方 信息设置
		ToServerMessageMine mine = message.getData().getMine();

		// 设置发送方用户名
		toClientTextMessage.setUsername(mine.getUsername());

		// 设置发送方头像
		toClientTextMessage.setAvatar(mine.getAvatar());

		// 设置发送文本
		toClientTextMessage.setContent(mine.getContent());

		// 设置发送类型
		toClientTextMessage.setType(message.getData().getTo().getType());

		// 设置发送方ID
		toClientTextMessage.setFromid(mine.getId());


		// 群组和好友直接聊天不同，群组的id 是 组id，否则是发送人的id
		if (toClientTextMessage.getType().equals(LayIMChatType.GROUP)) {
			toClientTextMessage.setId(message.getData().getTo().getId());
		} else {
			toClientTextMessage.setId(mine.getId());
		}
		toClientTextMessage.setTimestamp(new Date().getTime());

		// 返回统一消息接口
		ToClientMessageResult result = new ToClientMessageResult();

		// 封装发送消息对象
		result.setMsg(toClientTextMessage);

		// 封装发送类型
		result.setType(ToClientMessageType.TYPE_TEXT_MESSAGE);

		// 返回
		return LayIMFactory.createSerializer().toJSON(result);
	}


}
