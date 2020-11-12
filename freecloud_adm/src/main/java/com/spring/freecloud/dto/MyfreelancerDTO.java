package com.spring.freecloud.dto;

import java.sql.Date;

public class MyfreelancerDTO {
	 	
	private int PROJECT_IDX;	// 프로젝트 번호
	private String PROJECT_SUBJECT; // 프로젝트 이름
	private String CLIENT_ID;	// 클라이언트 아이디
	private String FREELANCER_ID;	// 프리랜서 아이디
	private int PROJECT_STATUS; // 프로젝트 진척도 ( 0 - 진행중 / 1 - 완료 / 2 - 요청된 프로젝트 / 3 - 요청한 프로젝트 ) 
	public int getPROJECT_IDX() {
		return PROJECT_IDX;
	}
	public void setPROJECT_IDX(int pROJECT_IDX) {
		PROJECT_IDX = pROJECT_IDX;
	}
	public String getPROJECT_SUBJECT() {
		return PROJECT_SUBJECT;
	}
	public void setPROJECT_SUBJECT(String pROJECT_SUBJECT) {
		PROJECT_SUBJECT = pROJECT_SUBJECT;
	}
	public String getCLIENT_ID() {
		return CLIENT_ID;
	}
	public void setCLIENT_ID(String cLIENT_ID) {
		CLIENT_ID = cLIENT_ID;
	}
	public String getFREELANCER_ID() {
		return FREELANCER_ID;
	}
	public void setFREELANCER_ID(String fREELANCER_ID) {
		FREELANCER_ID = fREELANCER_ID;
	}
	public int getPROJECT_STATUS() {
		return PROJECT_STATUS;
	}
	public void setPROJECT_STATUS(int pROJECT_STATUS) {
		PROJECT_STATUS = pROJECT_STATUS;
	}
	@Override
	public String toString() {
		return "MyfreelancerDTO [PROJECT_IDX=" + PROJECT_IDX + ", PROJECT_SUBJECT=" + PROJECT_SUBJECT + ", CLIENT_ID="
				+ CLIENT_ID + ", FREELANCER_ID=" + FREELANCER_ID + ", PROJECT_STATUS=" + PROJECT_STATUS + "]";
	}
	
	
	
	    
}
