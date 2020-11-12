package com.spring.freecloud.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import com.spring.freecloud.dao.EtcDAO;
import com.spring.freecloud.dao.UserDAO;
import com.spring.freecloud.dto.PortfolioDTO;

import com.spring.freecloud.dto.ProjectDTO;
import com.spring.freecloud.dto.ProjectViewDTO;
import com.spring.freecloud.dto.UserDTO;
import com.spring.freecloud.util.PagingDTO;

@Service("IEtcService")
public class EtcService {

	// 인터페이스로 생성해야함
	@Autowired
	public EtcDAO dao;

	public int ProjectCount() {
		// TODO Auto-generated method stub
		return dao.ProjectCount();
	}

	public int RegFreeCount() {
		// TODO Auto-generated method stub
		return dao.RegFreeCount();
	}

	public int EdPrice() {
		// TODO Auto-generated method stub
		return dao.EdPrice();
	}

	public int AllUser() {
		// TODO Auto-generated method stub
		return dao.AllUser();
	}

	// 프로젝트 지원
	public int RequestProject(String pROJECT_IDX, String PROJECT_SUBJECT, String freeid, String clientId) {
		// TODO Auto-generated method stub
		return dao.RequestProject(pROJECT_IDX, PROJECT_SUBJECT, freeid, clientId);
	}

}
