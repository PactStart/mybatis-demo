package com.pactrex.mybatis.demo.model;

import java.util.Date;

public class SqlLog {
	
	private int id;

	private String caluse;
	
	private Date created;
	
	private int updatedRows;
	
	private long cost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaluse() {
		return caluse;
	}

	public void setCaluse(String caluse) {
		this.caluse = caluse;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getUpdatedRows() {
		return updatedRows;
	}

	public void setUpdatedRows(int updatedRows) {
		this.updatedRows = updatedRows;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

}
