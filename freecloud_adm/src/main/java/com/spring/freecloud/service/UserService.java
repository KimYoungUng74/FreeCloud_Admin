package com.spring.freecloud.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import com.spring.freecloud.dao.UserDAO;
import com.spring.freecloud.dto.PortfolioDTO;

import com.spring.freecloud.dto.ProjectDTO;
import com.spring.freecloud.dto.ProjectViewDTO;
import com.spring.freecloud.dto.UserDTO;
import com.spring.freecloud.util.PagingDTO;

@Service("IUserService")
public class UserService {

	// 인터페이스로 생성해야함
	@Autowired
	public UserDAO dao;

	// 회원 가입
	public int signupUser(UserDTO dto) {
		try {
			dao.signupUser(dto); // 회원가입
		} catch (Exception e) {
			return -1; // 회원가입 실패
		}
		return 1;
	}

	// 회원 로그인 체크
	public boolean loginCheck(UserDTO dto, HttpSession session) {
		boolean result = dao.loginCheck(dto);
		if (result) { // true일 경우 세션에 등록
			UserDTO dto2 = viewUser(dto); // 회원 정보 조회
			// 세션 변수 등록
			session.setAttribute("userId", dto2.getUSER_ID());
			session.setAttribute("userName", dto2.getUSER_NAME());
			session.setAttribute("userEmail", dto2.getUSER_EMAIL());
			session.setAttribute("userinfo", dto2.getFREELANCER_ABOUT_ME());
		}
		return result;
	}

	// 회원 정보 조회
	public UserDTO viewUser(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.viewUser(dto);
	}

	// 회원 로그아웃
	public void logout(HttpSession session) {
		// 세션 변수 개별 삭제
		// session.removeAttribute("userId");
		// 세션 정보를 초기화 시킴
		session.invalidate();
	}

	// 중복 아이디 체크
	public boolean checkId(String id) {
		UserDTO dto = new UserDTO();
		dto.setUSER_ID(id);
		return dao.checkId(dto);
	}

	// 중복 이메일 체크
	public boolean checkEmail(String email) {
		UserDTO dto = new UserDTO();
		dto.setUSER_EMAIL(email);
		return dao.checkEmail(dto);
	}

	// 아이디 찾기
	public String seekId(String name, String email) {
		UserDTO dto = new UserDTO();
		dto.setUSER_NAME(name);
		dto.setUSER_EMAIL(email);
		return dao.seekId(dto);
	}

	// 비밀번호 찾기
	public String seekPw(String id, String name, String email) {
		UserDTO dto = new UserDTO();
		dto.setUSER_ID(id);
		dto.setUSER_NAME(name);
		dto.setUSER_EMAIL(email);

		return dao.seekPw(dto);
	}


	// 프리랜서 리스트 조회
	public List<UserDTO> listAll() {
		// TODO Auto-generated method stub

		return dao.listAll();
	}

	// 게시글 총 갯수

	public int countBoard() {
		return dao.countBoard();
	}

	// 페이징 처리 게시글 조회

	public List<ProjectDTO> selectProject(PagingDTO dto) {
		return dao.selectProject(dto);
	}

	// 회원정보 수정
	public int userModify(UserDTO dto) {
		System.out.println(dto.toString());
		dao.userModify(dto); // 회원정보 수정

		return 1;
	}

	// 프로필 변경
	public void changeProfile(String savedName, String userid) {
		UserDTO dto = new UserDTO();
		dto.setUSER_ID(userid);
		dto.setFREELANCER_IMAGE_PATH(savedName);

		dao.changeProfile(dto);
	}

	// 포트폴리오 추가
	public void addPortfolio(String originalName, String savedName, String userid) {
		PortfolioDTO dto = new PortfolioDTO();
		dto.setUSER_ID(userid);
		dto.setORIGINNAME(originalName);
		dto.setPORTFOLIO_PATH(savedName);

		dao.addPortfolio(dto);
	}

	// 포트폴리오 삭제
	public void deletePortfolio(String userid) {
		PortfolioDTO dto = new PortfolioDTO();
		dto.setUSER_ID(userid);
		dao.deletePortfolio(dto);
	}

	// 비밀번호 확인
	public String checkPw(String id, String pw) {
		UserDTO dto = new UserDTO();
		dto.setUSER_ID(id);
		dto.setUSER_PW(pw);
		return dao.checkPw(dto);
	}

	//회원 정보 확인
	public UserDTO myInfo(String id) {
		// TODO Auto-generated method stub
		UserDTO dto = new UserDTO();
		dto.setUSER_ID(id);
		return dao.myInfo(dto);
	}

	// 프로필 사진
	public String myProfile(String id) {
		// TODO Auto-generated method stub
		return dao.myProfile(id);
	}

	/* 나의 프로젝트 */
	// 진행중인 나의 프로젝트 - 의뢰
	public List<ProjectDTO> ingMyProject(String USER_ID) {
		return dao.ingMyProject(USER_ID);
	}

	// 완료한 프로젝트 - 의뢰
	public List<ProjectDTO> edMyProject(String USER_ID) {
		// TODO Auto-generated method stub
		return dao.edMyProject(USER_ID);
	}

	/* 프로젝트 지원 형황 */
	// 진행중인 나의 프로젝트 - 지원
	public List<ProjectDTO> rIngMyProject(String USER_ID) {
		// TODO Auto-generated method stub
		return dao.rIngMyProject(USER_ID);
	}
	// 지원 요청된 프로젝트 
	public List<ProjectDTO> requestedProject(String USER_ID) {
		// TODO Auto-generated method stub
		return dao.requestedProject(USER_ID);
	}
	// 지원한 프로젝트
	public List<ProjectDTO> requestProject(String USER_ID) {
		// TODO Auto-generated method stub
		return dao.requestProject(USER_ID);
	}
	// 완료한 프로젝트 - 지원
	public List<ProjectDTO> rEdMyProject(String USER_ID) {
		// TODO Auto-generated method stub
		return dao.rEdMyProject(USER_ID);
	}

	// home 프로젝트 리스트
	public List<ProjectViewDTO> viewProjectList(String cata) {
		// TODO Auto-generated method stub
		return dao.viewProjectList(cata);
	}

	public List<UserDTO> UserList() {
		// TODO Auto-generated method stub
		return dao.UserList();
	}

	public List<UserDTO> UserListALL(String FREELANCER_MAIN_KATEGORY) {
		// TODO Auto-generated method stub
		return dao.UserListALL(FREELANCER_MAIN_KATEGORY);
	}
}
