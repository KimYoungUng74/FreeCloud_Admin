package com.spring.freecloud.dto;


public class ProjectViewDTO {
	 	
	private int PROJECT_IDX;	// 프로젝트 번호
	private String USER_ID;		// 유저 아이디
	private String FREELANCER_IMAGE_PATH; // 유저 이미지
	private String PROJECT_SUBJECT;	// 프로젝트 제목
	private String USER_NAME;	// 유저 이름
	private String PROJECT_START_DATE; // 프로젝트 시작일
	private String PROJECT_MAIN_KATEGORY; // 프로젝트 카테고리
	public int getPROJECT_IDX() {
		return PROJECT_IDX;
	}
	public void setPROJECT_IDX(int pROJECT_IDX) {
		PROJECT_IDX = pROJECT_IDX;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getFREELANCER_IMAGE_PATH() {
		return FREELANCER_IMAGE_PATH;
	}
	public void setFREELANCER_IMAGE_PATH(String fREELANCER_IMAGE_PATH) {
		FREELANCER_IMAGE_PATH = fREELANCER_IMAGE_PATH;
	}
	public String getPROJECT_SUBJECT() {
		return PROJECT_SUBJECT;
	}
	public void setPROJECT_SUBJECT(String pROJECT_SUBJECT) {
		PROJECT_SUBJECT = pROJECT_SUBJECT;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getPROJECT_START_DATE() {
		return PROJECT_START_DATE;
	}
	public void setPROJECT_START_DATE(String pROJECT_START_DATE) {
		PROJECT_START_DATE = pROJECT_START_DATE;
	}
	public String getPROJECT_MAIN_KATEGORY() {
		return PROJECT_MAIN_KATEGORY;
	}
	public void setPROJECT_MAIN_KATEGORY(String pROJECT_MAIN_KATEGORY) {
		PROJECT_MAIN_KATEGORY = pROJECT_MAIN_KATEGORY;
	}
	@Override
	public String toString() {
		return "ProjectViewDTO [PROJECT_IDX=" + PROJECT_IDX + ", USER_ID=" + USER_ID + ", FREELANCER_IMAGE_PATH="
				+ FREELANCER_IMAGE_PATH + ", PROJECT_SUBJECT=" + PROJECT_SUBJECT + ", USER_NAME=" + USER_NAME
				+ ", PROJECT_START_DATE=" + PROJECT_START_DATE + ", PROJECT_MAIN_KATEGORY=" + PROJECT_MAIN_KATEGORY
				+ "]";
	}

	
	
	
	    
}
