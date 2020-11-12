package com.spring.freecloud.dto;

import java.util.Date;

public class UserDTO {
	 	private String USER_ID;		// 유저 아이디
	    private String USER_PW;		// 유저 비밀번호
	    private String USER_NAME;	// 유저 이름
	    private String USER_EMAIL;	// 유저 이메일
	    private String USER_PHONE1;	// 유저 번호1
	    private String USER_PHONE2;	// 유저 번호2
	    private String USER_PHONE3;	// 유저 번호3
	    private String USER_ADDRESS;	// 유저 주소
	    private String FREELANCER_ABOUT_ME;	// 유저 자기소개
	    private String FREELANCER_MAIN_KATEGORY;	// 유저 대분류 전문분야
	    private String FREELANCER_MIDDEL_KATEGORY;	// 유저 중분류 전문분야
	    private String FREELANCER_SKILL;	// 유저 보유기술
	    private int FREELANCER_CAREER;	// 유저 경력
	    private String FREELANCER_CERTIFICATE;	// 유저 자격증
	    private String FREELANCER_IMAGE_PATH;	// 유저 이미지 경로
	    private int FREELANCER_PUBLIC;	// 유저 정보 공개 여부
	    private int USER_GRANT;	// 유저 권한
	    private String USER_EDU; // 유저 학력
	    
		public String getUSER_ID() {
			return USER_ID;
		}
		public void setUSER_ID(String uSER_ID) {
			USER_ID = uSER_ID;
		}
		public String getUSER_PW() {
			return USER_PW;
		}
		public void setUSER_PW(String uSER_PW) {
			USER_PW = uSER_PW;
		}
		public String getUSER_NAME() {
			return USER_NAME;
		}
		public void setUSER_NAME(String uSER_NAME) {
			USER_NAME = uSER_NAME;
		}
		public String getUSER_EMAIL() {
			return USER_EMAIL;
		}
		public void setUSER_EMAIL(String uSER_EMAIL) {
			USER_EMAIL = uSER_EMAIL;
		}
		public String getUSER_PHONE1() {
			return USER_PHONE1;
		}
		public void setUSER_PHONE1(String uSER_PHONE1) {
			USER_PHONE1 = uSER_PHONE1;
		}
		public String getUSER_PHONE2() {
			return USER_PHONE2;
		}
		public void setUSER_PHONE2(String uSER_PHONE2) {
			USER_PHONE2 = uSER_PHONE2;
		}
		public String getUSER_PHONE3() {
			return USER_PHONE3;
		}
		public void setUSER_PHONE3(String uSER_PHONE3) {
			USER_PHONE3 = uSER_PHONE3;
		}
		public String getUSER_ADDRESS() {
			return USER_ADDRESS;
		}
		public void setUSER_ADDRESS(String uSER_ADDRESS) {
			USER_ADDRESS = uSER_ADDRESS;
		}
		public String getFREELANCER_ABOUT_ME() {
			return FREELANCER_ABOUT_ME;
		}
		public void setFREELANCER_ABOUT_ME(String fREELANCER_ABOUT_ME) {
			FREELANCER_ABOUT_ME = fREELANCER_ABOUT_ME;
		}
		public String getFREELANCER_MAIN_KATEGORY() {
			return FREELANCER_MAIN_KATEGORY;
		}
		public void setFREELANCER_MAIN_KATEGORY(String fREELANCER_MAIN_KATEGORY) {
			FREELANCER_MAIN_KATEGORY = fREELANCER_MAIN_KATEGORY;
		}
		public String getFREELANCER_MIDDEL_KATEGORY() {
			return FREELANCER_MIDDEL_KATEGORY;
		}
		public void setFREELANCER_MIDDEL_KATEGORY(String fREELANCER_MIDDEL_KATEGORY) {
			FREELANCER_MIDDEL_KATEGORY = fREELANCER_MIDDEL_KATEGORY;
		}
		public String getFREELANCER_SKILL() {
			return FREELANCER_SKILL;
		}
		public void setFREELANCER_SKILL(String fREELANCER_SKILL) {
			FREELANCER_SKILL = fREELANCER_SKILL;
		}
		public int getFREELANCER_CAREER() {
			return FREELANCER_CAREER;
		}
		public void setFREELANCER_CAREER(int fREELANCER_CAREER) {
			FREELANCER_CAREER = fREELANCER_CAREER;
		}
		public String getFREELANCER_CERTIFICATE() {
			return FREELANCER_CERTIFICATE;
		}
		public void setFREELANCER_CERTIFICATE(String fREELANCER_CERTIFICATE) {
			FREELANCER_CERTIFICATE = fREELANCER_CERTIFICATE;
		}
		public String getFREELANCER_IMAGE_PATH() {
			return FREELANCER_IMAGE_PATH;
		}
		public void setFREELANCER_IMAGE_PATH(String fREELANCER_IMAGE_PATH) {
			FREELANCER_IMAGE_PATH = fREELANCER_IMAGE_PATH;
		}
		public int getFREELANCER_PUBLIC() {
			return FREELANCER_PUBLIC;
		}
		public void setFREELANCER_PUBLIC(int fREELANCER_PUBLIC) {
			FREELANCER_PUBLIC = fREELANCER_PUBLIC;
		}
		public int getUSER_GRANT() {
			return USER_GRANT;
		}
		public void setUSER_GRANT(int uSER_GRANT) {
			USER_GRANT = uSER_GRANT;
		}
		public String getUSER_EDU() {
			return USER_EDU;
		}
		public void setUSER_EDU(String uSER_EDU) {
			USER_EDU = uSER_EDU;
		}
		
		@Override
		public String toString() {
			return "UserDTO [USER_ID=" + USER_ID + ", USER_PW=" + USER_PW + ", USER_NAME=" + USER_NAME + ", USER_EMAIL="
					+ USER_EMAIL + ", USER_PHONE1=" + USER_PHONE1 + ", USER_PHONE2=" + USER_PHONE2 + ", USER_PHONE3="
					+ USER_PHONE3 + ", USER_ADDRESS=" + USER_ADDRESS + ", FREELANCER_ABOUT_ME=" + FREELANCER_ABOUT_ME
					+ ", FREELANCER_MAIN_KATEGORY=" + FREELANCER_MAIN_KATEGORY + ", FREELANCER_MIDDEL_KATEGORY="
					+ FREELANCER_MIDDEL_KATEGORY + ", FREELANCER_SKILL=" + FREELANCER_SKILL + ", FREELANCER_CAREER="
					+ FREELANCER_CAREER + ", FREELANCER_CERTIFICATE=" + FREELANCER_CERTIFICATE
					+ ", FREELANCER_IMAGE_PATH=" + FREELANCER_IMAGE_PATH + ", FREELANCER_PUBLIC=" + FREELANCER_PUBLIC
					+ ", USER_GRANT=" + USER_GRANT + ", USER_EDU=" + USER_EDU + "]";
		}
		
	
	    
}
