package by.pvt.zkh.entity;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int id;
	int uid;
	String workType;
	String details;
	
	public Order() {
	}

	public Order(int id, int uid, String workType, String details) {
		this.id = id;
		this.uid = uid;
		this.workType = workType;
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(int oid) {
		this.id = oid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return id + " " + workType + " " + details;
	}
	
	
}
