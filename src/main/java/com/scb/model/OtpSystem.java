package com.scb.model;

public class OtpSystem {

	private String mobilenumber;
	private String otp;
	private long expiryTime;
	private boolean lock;
	

	public OtpSystem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}

}
