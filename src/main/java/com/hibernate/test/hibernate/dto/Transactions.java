package com.hibernate.test.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;


@Entity (name = "tansactions")
@Table (name = "transactions")
public class Transactions {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "user_id")
	private int userId;
	@Column (name = "user_name")
	private String userName;
	@ElementCollection (fetch = FetchType.LAZY)
	@JoinTable (name = "transaction_logs",
				joinColumns = @JoinColumn(name = "USER_ID")
			)
	private Collection<Log> logs = new HashSet<>(); // no index supported 
	//@CollectionId(columns = {@Column(name = "log_id")}, generator = "native", type = @Type(type = "long")) // only supported by hibernate not by jpa
	//private Collection<Log> logs = new ArrayList<>(); // it support index
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<Log> getLogs() {
		return logs;
	}
	public void setLogs(Collection<Log> logs) {
		this.logs = logs;
	}
	@Override
	public String toString() {
		return "Transactions [userId=" + userId + ", userName=" + userName + ", logs=" + logs + "]";
	}
}
