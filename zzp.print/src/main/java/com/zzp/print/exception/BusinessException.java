package com.zzp.print.exception;

import com.hlc.log.exception.ErrorEnum;

public class BusinessException extends Exception {

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = -5378643577077141823L;
	
	protected String errCode;
	
	protected String errReason;
	
	public BusinessException(String message) {
		super(message);
		this.errReason = message;
	}
	
	public BusinessException(ErrorEnum errEnum) {
		super("[" + errEnum.getCode() + "]" + errEnum.getReason());

		this.errCode = errEnum.getCode();
		this.errReason = errEnum.getReason();
	}
	
	public BusinessException(String errCode, String errReason) {
		super("[" + errCode + "]" + errReason);

		this.errCode = errCode;
		this.errReason = errReason;
	}

	public BusinessException(String errCode, String errReason, Throwable e) {
		super("[" + errCode + "]" + errReason, e);

		this.errCode = errCode;
		this.errReason = errReason;
	}
	
	public BusinessException(ErrorEnum errEnum, Throwable e) {
		super("[" + errEnum.getCode() + "]" + errEnum.getReason(), e);

		this.errCode = errEnum.getCode();
		this.errReason = errEnum.getReason();
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrReason() {
		return errReason;
	}

	public void setErrReason(String errReason) {
		this.errReason = errReason;
	}
}
