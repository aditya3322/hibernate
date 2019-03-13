package com.hibernate.test.hibernate.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "transactions")
public class Transactions {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "user_id")
	private int userId;
	@Column (name = "user_name")
	private String userName;
	@ElementCollection
	private Set<Log> logs = new HashSet<>();
	
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
	public Set<Log> getLogs() {
		return logs;
	}
	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}
	

}
