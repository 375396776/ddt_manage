package com.ddt.manage.po;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @Title: FMBankReCharge
 * @Description: 充提业务实体类
 * @Company: 
 * @author 李斌
 * @date 2017年11月29日 下午5:16:36 
 * @version 1.0
 */
public class FMBankReCharge implements Serializable
{
	
    private static final long serialVersionUID = 1L;
    private String version;// 	版本号	String(4) 	版本号，1.0、2.0 	否
    private String service;//	接口名称	String(32) 	reapal.trust.depositApplyAPI	否
    private String partner; //合作伙伴	String(32) 	合作伙伴在融宝的ID	否
    private String sign; //签名	String(256) 	参见签名元素说明	否
    private String signType; //签名方式	String(8) 	MD5：0，RSA：1 	否

    private String orderNo; //商户订单号	String(64)	确保在合作伙伴系统中唯一HJKM2011051189234	否
    private String contracts;//	用户协议号	String(16)	存管系统生成三方签约协议号     存管系统内唯一   否
    private String paymentType;//	充值类型	String(4)	1：网银支付（默认值，此字段为空时，默认此种方式）；2：B2B银行直连；3：B2C借记卡银行直连；	是
    private String payCustomerNo;// 	付款客户号（民生B2B、浦发B2B）付款账号（交通B2B）	String(32)	支付方式为银行直连时：民生、浦发、交通三家银行B2B支付需要提交该字段。	是

    private String bankCard;//	银行卡卡号	String(32)	充值银行卡卡号	否
    private String bankName;//	银行卡所属银行名称
    private String bankCode;//银行代码
    private String bankProvince;//银行所在省
    private String bankCity;//银行所在市
    private String bankBranch;//银行分支行

	private String userName;//	姓名	String(32)	持卡人姓名	否
    private String certType;//	证件类型	String	证件类型，暂时只支持身份证（01）	否
    private String channel;//充值渠道	String(10) 	如果是跳转收银台值为：bank，银行直连请参考：银行代码	否
    private String userIdentity;//	用户身份证号	String(32)	必须是用户真实的身份证信息	否
    private String userMobile; //用户手机号	String(16)	必须是用户自己的手机号信息	否
    private String currency; //交易币种	String(8)	默认人民币（仅支持人民币cny）	是
    private Double amount; //交易金额	Number(11,2)	以元为单位、范围为【0.00，99999999.99】	否
    private Double charge; //手续费	Number(11,2)	以元为单位、范围为【0.00，99999999.99】	否
    private String busway; //设备通道	String(8)	00：PC端；01：手机端；02：Pad端；03：其它	是
    private String terminalInfo;//	终端信息	String(256)	手机IMEI地址、MAC地址、P2PUUID	否
    private String memberIp; //用户IP	String(64)	用户的IP地址	否
    private String returnUrl; //回调URL 	String(256) 	页面跳转商户站点通知业务处理结果的Url地址	否
    private String notifyUrl; //通知URL 	String(256) 	系统后台一键通知商户业务处理结果的Url地址	否
    private String remark; //备注	String(512)	业务备注信息	是
    private String applyTime;//	申请时间	String(32)	商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss	否
    private String resultCode;//	结果代码 	String(4) 		否
    private String processTime;//	处理时间	String(32)	融宝业务处理时间、格式为YYYY-MM-DD HH:mm:ss	否
    private String subType; //分账类型	String(8)	1：代还款。2：分账。3：其它	
    private List<SubDetails> subDetails; //分账明细	String(1024)	分账明细格式	否
    private String serialNo; //分账流水号	String(64)	还款流水号【确保在商户系统中唯一只】由数字和字母组成	否
    private String payeeContracts; //收款方协议号	String(16)	与平台签约的收款方协议号	否
    private String checkCode;// 短信验证码 String(8)  短信验证码  否
    private String queryTime;// 
    private String resError;
    
    
    public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankProvince() {
		return bankProvince;
	}

	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getBankName() {
    	return bankName;
    }
    
    public void setBankName(String bankName) {
    	this.bankName = bankName;
    }

    public String getResError()
    {
        return this.resError;
    }

    public void setResError(String resError)
    {
        this.resError = resError;
    }

    /*    public ResError getResError()
        {
            return this.resError;
        }

        public void setResError(ResError resError)
        {
            this.resError = resError;
        }
    */
    public String getCheckCode()
    {
        return this.checkCode;
    }

    public void setCheckCode(String checkCode)
    {
        this.checkCode = checkCode;
    }

    public String getVersion()
    {
        return this.version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getService()
    {
        return this.service;
    }

    public void setService(String service)
    {
        this.service = service;
    }

    public String getPartner()
    {
        return this.partner;
    }

    public void setPartner(String partner)
    {
        this.partner = partner;
    }

    public String getSign()
    {
        return this.sign;
    }

    public void setSign(String sign)
    {
        this.sign = sign;
    }

    public String getSignType()
    {
        return this.signType;
    }

    public void setSignType(String signType)
    {
        this.signType = signType;
    }

    public String getOrderNo()
    {
        return this.orderNo;
    }

    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getContracts()
    {
        return this.contracts;
    }

    public void setContracts(String contracts)
    {
        this.contracts = contracts;
    }

    public String getBankCard()
    {
        return this.bankCard;
    }

    public void setBankCard(String bankCard)
    {
        this.bankCard = bankCard;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getCertType()
    {
        return this.certType;
    }

    public void setCertType(String certType)
    {
        this.certType = certType;
    }

    public String getUserIdentity()
    {
        return this.userIdentity;
    }

    public void setUserIdentity(String userIdentity)
    {
        this.userIdentity = userIdentity;
    }

    public String getUserMobile()
    {
        return this.userMobile;
    }

    public void setUserMobile(String userMobile)
    {
        this.userMobile = userMobile;
    }

    public String getCurrency()
    {
        return this.currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public Double getAmount()
    {
        return this.amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public Double getCharge()
    {
        return this.charge;
    }

    public void setCharge(Double charge)
    {
        this.charge = charge;
    }

    public String getBusway()
    {
        return this.busway;
    }

    public void setBusway(String busway)
    {
        this.busway = busway;
    }

    public String getTerminalInfo()
    {
        return this.terminalInfo;
    }

    public void setTerminalInfo(String terminalInfo)
    {
        this.terminalInfo = terminalInfo;
    }

    public String getMemberIp()
    {
        return this.memberIp;
    }

    public void setMemberIp(String memberIp)
    {
        this.memberIp = memberIp;
    }

    public String getNotifyUrl()
    {
        return this.notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl)
    {
        this.notifyUrl = notifyUrl;
    }

    public String getRemark()
    {
        return this.remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getApplyTime()
    {
        return this.applyTime;
    }

    public void setApplyTime(String applyTime)
    {
        this.applyTime = applyTime;
    }

    public String getResultCode()
    {
        return this.resultCode;
    }

    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }

    public String getProcessTime()
    {
        return this.processTime;
    }

    public void setProcessTime(String processTime)
    {
        this.processTime = processTime;
    }

    public String getSubType()
    {
        return this.subType;
    }

    public void setSubType(String subType)
    {
        this.subType = subType;
    }

    @SuppressWarnings("rawtypes")
	public List getSubDetails()
    {
        return this.subDetails;
    }

    public void setSubDetails(List<SubDetails> subDetails)
    {
        this.subDetails = subDetails;
    }

    public String getSerialNo()
    {
        return this.serialNo;
    }

    public void setSerialNo(String serialNo)
    {
        this.serialNo = serialNo;
    }

    public String getPayeeContracts()
    {
        return this.payeeContracts;
    }

    public void setPayeeContracts(String payeeContracts)
    {
        this.payeeContracts = payeeContracts;
    }

    public String getPaymentType()
    {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType)
    {
        this.paymentType = paymentType;
    }

    public String getPayCustomerNo()
    {
        return this.payCustomerNo;
    }

    public void setPayCustomerNo(String payCustomerNo)
    {
        this.payCustomerNo = payCustomerNo;
    }

    public String getReturnUrl()
    {
        return this.returnUrl;
    }

    public void setReturnUrl(String returnUrl)
    {
        this.returnUrl = returnUrl;
    }

    public String getChannel()
    {
        return this.channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    public String getErrorCode()
    {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMsg()
    {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    private String errorCode;
    private String errorMsg;

    @Override
    public String toString()
    {
        return "ReCharge [version=" + this.version + ", service=" + this.service + ", partner=" + this.partner + ", sign=" + this.sign + ", signType=" + this.signType + ", orderNo=" + this.orderNo + ", contracts=" + this.contracts + ", paymentType=" + this.paymentType + ", payCustomerNo=" + this.payCustomerNo + ", bankCard=" + this.bankCard + ", userName=" + this.userName + ", certType=" + this.certType + ", channel=" + this.channel + ", userIdentity=" + this.userIdentity + ", userMobile=" + this.userMobile + ", currency=" + this.currency + ", amount=" + this.amount + ", charge=" + this.charge + ", busway=" + this.busway + ", terminalInfo=" + this.terminalInfo + ", memberIp=" + this.memberIp + ", returnUrl=" + this.returnUrl + ", notifyUrl=" + this.notifyUrl + ", remark=" + this.remark + ", applyTime=" + this.applyTime + ", resultCode=" + this.resultCode + ", processTime=" + this.processTime + ", subType=" + this.subType + ", subDetails=" + this.subDetails + ", serialNo=" + this.serialNo + ", payeeContracts=" + this.payeeContracts + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + "]";
    }

	public String getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}

}
