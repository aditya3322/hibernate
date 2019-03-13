package com.hibernate.test.hibernate.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Log {
	
	@Column (name = "transaction_id")
	private int txid;
	@Column (name = "transaction_time")
	private Date txTime;
	@Column (name = "activity")
	private String activity;
	public Log() {
	}
	public Log(int txid, Date txTime, String activity) {
		this.txid = txid;
		this.txTime = txTime;
		this.activity = activity;
	}
	public int getTxid() {
		return txid;
	}
	public void setTxid(int txid) {
		this.txid = txid;
	}
	public Date getTxTime() {
		return txTime;
	}
	public void setTxTime(Date txTime) {
		this.txTime = txTime;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	

}
