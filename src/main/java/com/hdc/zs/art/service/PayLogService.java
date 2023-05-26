package com.hdc.zs.art.service;
/**
 * 后台支付操作service
 */

import com.hdc.zs.art.empty.PayLog;
import org.springframework.stereotype.Service;



public interface PayLogService {
	public int addSn(PayLog payLog);
	public int deleteAlipayPaints(String name);
}
