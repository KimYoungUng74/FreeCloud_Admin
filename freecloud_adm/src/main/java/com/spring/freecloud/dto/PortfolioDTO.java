package com.spring.freecloud.dto;

import java.util.Date;

public class PortfolioDTO {
	 	private String USER_ID;		// 유저 아이디
	    private String PORTFOLIO_PATH;		// 저장된 이름
	    private String ORIGINNAME;	// 원래 이름
	    private Date FILE_DATATIME;	// 작성일
		public String getUSER_ID() {
			return USER_ID;
		}
		public void setUSER_ID(String uSER_ID) {
			USER_ID = uSER_ID;
		}
		public String getPORTFOLIO_PATH() {
			return PORTFOLIO_PATH;
		}
		public void setPORTFOLIO_PATH(String pORTFOLIO_PATH) {
			PORTFOLIO_PATH = pORTFOLIO_PATH;
		}
		public String getORIGINNAME() {
			return ORIGINNAME;
		}
		public void setORIGINNAME(String oRIGINNAME) {
			ORIGINNAME = oRIGINNAME;
		}
		public Date getFILE_DATATIME() {
			return FILE_DATATIME;
		}
		public void setFILE_DATATIME(Date fILE_DATATIME) {
			FILE_DATATIME = fILE_DATATIME;
		}
		@Override
		public String toString() {
			return "PortfolioDTO [USER_ID=" + USER_ID + ", PORTFOLIO_PATH=" + PORTFOLIO_PATH + ", ORIGINNAME="
					+ ORIGINNAME + ", FILE_DATATIME=" + FILE_DATATIME + "]";
		}
	    
		
	    
}
