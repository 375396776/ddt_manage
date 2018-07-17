package com.ddt.manage.po;

public class SubDetails {
	private String serialNo	;//分账流水号	String(64)	还款流水号【确保在商户系统中唯一只】由数字和字母组成	否
	private String payeeContracts;//	收款方协议号	String(16)	与平台签约的收款方协议号	否
	private double amount;//	金额	Number(11,2)	以元为单位、范围为【0.00，99999999.99】【包括平台佣金，其它手续费等】	否
	private String remark;//	备注	String(64)	业务备注信息	是
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getPayeeContracts() {
		return payeeContracts;
	}
	public void setPayeeContracts(String payeeContracts) {
		this.payeeContracts = payeeContracts;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "SubDetails [serialNo=" + serialNo + ", payeeContracts="
				+ payeeContracts + ", amount=" + amount + ", remark=" + remark
				+ "]";
	}
	
}
