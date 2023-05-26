package com.hdc.zs.art.empty;


import com.hdc.zs.art.bean.Payment;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付记录实体类
 * @author Administrator
 *
 */
public class PayLog {


	/**
	 * 
	 */
    private Date create_time; //创建时间
	private Date update_time; //更新时间
	private String info;//支付订单详情
	private String pay_sn;//支付平台交易号
	private Integer payment ;//支付方式
	private String sn;//支付记录编号
	private String refund_sn;//退款记录编号
	private Integer refund_amount;//退款金额
	private String refund_info;//退款原因
	private Integer total_amount;//支付金额
	private String title;//支付订单标题
	private Integer status;
	private Date pay_time;//支付时间
	private String refund_time;//退款时间

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPay_sn() {
		return pay_sn;
	}

	public void setPay_sn(String pay_sn) {
		this.pay_sn = pay_sn;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getRefund_sn() {
		return refund_sn;
	}

	public void setRefund_sn(String refund_sn) {
		this.refund_sn = refund_sn;
	}

	public Integer getRefund_amount() {
		return refund_amount;
	}

	public void setRefund_amount(Integer refund_amount) {
		this.refund_amount = refund_amount;
	}

	public String getRefund_info() {
		return refund_info;
	}

	public void setRefund_info(String refund_info) {
		this.refund_info = refund_info;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getPay_time() {
		return pay_time;
	}

	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}

	public String getRefund_time() {
		return refund_time;
	}

	public void setRefund_time(String refund_time) {
		this.refund_time = refund_time;
	}

	@Override
	public String toString() {
		return "PayLog{" +
				"create_time=" + create_time +
				", update_time=" + update_time +
				", info='" + info + '\'' +
				", pay_sn='" + pay_sn + '\'' +
				", payment=" + payment +
				", sn='" + sn + '\'' +
				", refund_sn='" + refund_sn + '\'' +
				", refund_amount=" + refund_amount +
				", refund_info='" + refund_info + '\'' +
				", total_amount=" + total_amount +
				", title='" + title + '\'' +
				", status=" + status +
				", pay_time=" + pay_time +
				", refund_time='" + refund_time + '\'' +
				'}';
	}
}
