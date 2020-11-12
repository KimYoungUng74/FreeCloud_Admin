package com.spring.freecloud.dto;

import java.sql.Date;

public class ProjectJoinDTO {
	 	
	private int PROJECT_IDX;
	private String PROJECT_SUBJECT;
	private String CLIENT_ID;
	private String FREELANCER_ID;
	private int PROJECT_STATUS;
	
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
		return "ProjectDTO [PROJECT_IDX=" + PROJECT_IDX + ", PROJECT_SUBJECT=" + PROJECT_SUBJECT + ", CLIENT_ID="
				+ CLIENT_ID + ", FREELANCER_ID=" + FREELANCER_ID + ", PROJECT_STATUS=" + PROJECT_STATUS + "]";
	}

	    
}
