package com.hdc.zs.art.controller.admin;


import com.hdc.zs.art.bean.Payment;
import com.hdc.zs.art.service.PayLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 支付记录管理控制器
 * @author 张硕
 *
 */
@RequestMapping("/pay_log")
@Controller
public class PayLogController {
	@Autowired
	private PayLogService payLogService;
	private Logger log = LoggerFactory.getLogger(PayLogController.class);
	/**
	 * 支付记录列表
	 * @param model
	 * @return
	 */
//	@RequestMapping("/list")
////	@ResponseBody
//	public String  list(Model model, PayLog payLog, PageBean<PayLog> pageBean) {   // Model model,PayLog payLog,PageBean<PayLog> pageBean
//		System.out.println("00000");
//		model.addAttribute("pageBean",payLogService.findList(payLog, pageBean));
//		model.addAttribute("sn",payLog.getSn());
//		return "admin/paylog/list";
//
//	}

	/**
	 * 利用get请求响应页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String  add(Model model) {
		model.addAttribute("paymentList", Payment.values());
		return "admin/paylog/add";
	}

	/**
	 * 添加支付记录页面,利用post请求接受数据
	 * @param model
	 * @return
	 */
//	@RequestMapping(value = "/add",method = RequestMethod.POST)
//	@ResponseBody
//	public Result<String> add(PayLog payLog) {
//		if (payLog ==null) {
//			return Result.error(CodeMsg.DATA_ERROR);
//		}
//	CodeMsg validate = ValidateEntityUtil.validate(payLog);
//	if (validate.getCode()!=CodeMsg.SUCCESS.getCode()) {
//		return Result.error(validate);
//	}
//	//到这表示一切符合，可以保存数据库
//	//生成支付编号
//	payLog.setSn(StringUtil.generateSn("艺术画展", ""));
//	payLogService.save(payLog);
//		return Result.success(payLog.getSn());
//	}


	/**
	 * 查看订单详情
	 * @param sn
	 * @return
	 *//*
	@RequestMapping(value = "/view",method = RequestMethod.POST)
	@ResponseBody
	public Result<String> view(@RequestParam(name="sn",required = true) String sn) {
		PayLog payLog=payLogService.findBySn(sn);
		if (payLog ==null) {
			return Result.error(CodeMsg.DATA_ERROR);
		}
		//调用支付宝接口进行查看
		String viewDetail = Alipay.viewDetail(sn);
		log.info(viewDetail);
		JSONObject parseObject= JSONObject.parseObject(viewDetail);
		String status=parseObject.getJSONObject("alipay_trade_query_response").getString("trade_status");
		return Result.success(viewDetail);
	}*/

}
