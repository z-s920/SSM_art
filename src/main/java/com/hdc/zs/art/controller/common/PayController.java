package com.hdc.zs.art.controller.common;
/**
 * z支付统一控制器
 */


import com.hdc.zs.art.service.PayLogService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pay")
@Controller
public class PayController {
	private Logger log = LoggerFactory.getLogger(PayController.class);//打印日志
	@Autowired
	private PayLogService payLogService;

	/**
	 * 支付统一入口方法
	 * @param sn
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value = "/to_pay", method = RequestMethod.GET)
	public String toPay(@RequestParam(name="sn")String sn, Model model)
	{
		PayLog payLog =payLogService.findBySn(sn);
		if (payLog == null){
			model.addAttribute("msg","订单编号不存在！");
			return RuntimeConstant.RUNTIME_ERROR_VIEW;
		}
		//根据支付记录来判断支付方式
			String html= Alipay.generatePcPayHtml(payLog.getSn(),payLog.getTotal_amount(),payLog.getTitle(),payLog.getInfo());
			model.addAttribute("html",html);
			return "pay/alipay/alipay_pc";
	}
	*//**
	 * 支付宝异步通知接口
	 * @param request
	 * @return
	 *//*
	@RequestMapping("/alipay_notify")
	@ResponseBody//异步请求
	public String alipayNotify(HttpServletRequest request) {
		//检查异步通知是否合法
		log.info("进入支付宝异步通知接口！");
		if (!Alipay.isValid(request)){
			log.error("支付宝签名验证失败！");
			return "fail";
		}
		//签名验证成功
		String sn=request.getParameter("out_trade_no");//订单号
		String paySn=request.getParameter("trade_no");//支付宝交易号
		String totalAmount=request.getParameter("total_amount");//支付金额
		String status=request.getParameter("trade_status");//支付状态
		if (StringUtils.isEmpty(sn))
		{
			log.error("订单编号为空！");
			return "fail";
		}
		if (StringUtils.isEmpty(paySn))
		{
			log.error("支付宝交易号为空！");
			return "fail";
		}
		if (StringUtils.isEmpty(totalAmount))
		{
			log.error("支付金额为空！");
			return "fail";
		}
		if (StringUtils.isEmpty(status))
		{
			log.error("支付状态为空！");
			return "fail";
		}
		//参数都是合法的
		PayLog payLog=payLogService.findBySn(sn);
		if (payLog == null)
		{
			log.error("订单编号不存在！【" + sn + " 】");
			return "fail";
		}
		if (payLog.getTotal_amount().compareTo(new BigDecimal(totalAmount))!=0 )
		{
			log.error("支付金额不不同！【" + totalAmount + " 】"+ "【"+payLog.getTotal_amount()+"】");
			return "fail";
		}
		//表示一切合法
		payLog.setPay_sn(paySn);
		payLog.setStatus(PayLog.pay_status_paid);
		payLog.setPay_time(new Date(System.currentTimeMillis()));
//		payLogService.save(payLog);
		return "success";
	}*/

}
