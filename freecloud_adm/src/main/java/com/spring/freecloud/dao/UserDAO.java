package com.spring.freecloud.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.freecloud.dto.PortfolioDTO;

import com.spring.freecloud.dto.ProjectDTO;
import com.spring.freecloud.dto.ProjectViewDTO;
import com.spring.freecloud.dto.UserDTO;
import com.spring.freecloud.util.PagingDTO;
import com.spring.freecloud.util.SHA256;

//[DB연결 사용법] 3. 인터페이스 받아서 클래스 생성
@Repository
public class UserDAO {
	// 컨테이너가 객체를 자동으로 생성 Autowired
	@Autowired
	public SqlSessionTemplate mybatis;

	// 회원가입
	public void signupUser(UserDTO dto) {

		// TODO Auto-generated method stub // 비밀 번호 암호화
		dto.setUSER_PW(SHA256.getSHA256(dto.getUSER_PW()));
		mybatis.insert("UserMapper.signup", dto);

	}

	// 중복아이디 체크
	public boolean checkId(UserDTO dto) {
		String id = mybatis.selectOne("UserMapper.idCheck", dto);
		return (null == id) ? false : true;
	}

	// 중복이메일 체크
	public boolean checkEmail(UserDTO dto) {
		String email = mybatis.selectOne("UserMapper.emailCheck", dto);
		return (null == email) ? false : true;
	}

	// 로그인 처리
	public boolean loginCheck(UserDTO dto) {
		dto.setUSER_PW(SHA256.getSHA256(dto.getUSER_PW()));
		String name = mybatis.selectOne("UserMapper.loginCheck", dto);
		return (null == name) ? false : true;
	}

	// 회원 정보 조회
	public UserDTO viewUser(UserDTO dto) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("UserMapper.viewUser", dto);
	}

	// 아이디 찾기
	public String seekId(UserDTO dto) {
		String id = mybatis.selectOne("UserMapper.seekId", dto);
		return (null == id) ? "" : id;
	}

	// 비밀번호 찾기
	public String seekPw(UserDTO dto) {
		String id = mybatis.selectOne("UserMapper.seekPw", dto);
		if (null == id) {
			return "notFound"; // 정보가 일치 하지 않을 때
		} else {
			String pw = randomPw1() + randomPw2() + randomPw1() + randomPw2();
			dto.setUSER_PW(pw);
			dto.setUSER_PW(SHA256.getSHA256(dto.getUSER_PW()));
			if (0 == mybatis.update("UserMapper.seekPw2", dto)) {
				return "dbError"; // DB오류
			} else {
				return pw; // 성공
			}
		}
	}

	// 랜덤 문자 생성
	public String randomPw1() {
		String rand = "";
		double dValue = Math.random();
		char cValue = (char) ((dValue * 26) + 65); // 대문자
		rand += cValue;
		dValue = Math.random();
		cValue = (char) ((dValue * 26) + 97); // 소문자
		rand += cValue;
		return rand;
	}

	// 랜덤 숫자 생성
	public int randomPw2() {
		double dValue = Math.random();

		int iValue = (int) (dValue * 10) + 1; // 1~10

		return iValue;
	}

	// 프로젝트 목록 조회
	public List<UserDTO> listAll() {
		// TODO Auto-generated method stub
		// return mybatis.selectOne("UserMapper.viewUser", dto);

		return mybatis.selectList("UserMapper.freelancerListAll");
	}

	// 게시글 총 갯수

	public int countBoard() {
		return mybatis.selectOne("UserMapper.countBoard");
	}

	// 페이징 처리 게시글 조회

	public List<ProjectDTO> selectProject(PagingDTO dto) {
		return mybatis.selectList("UserMapper.selectBoard", dto);
	}
	// 프로필 변경
	public void changeProfile(UserDTO dto) {
		mybatis.update("UserMapper.profileChange", dto);
	}
	// 포트폴리오 추가
	public void addPortfolio(PortfolioDTO dto) {
		mybatis.insert("UserMapper.portfolioAdd", dto);
	}
	// 포트폴리오 삭제
	public void deletePortfolio(PortfolioDTO dto) {
		mybatis.delete("UserMapper.deletePortfolio", dto);
	}
	// 회원정보 수정
	public void userModify(UserDTO dto) {

		mybatis.insert("UserMapper.userInfoChange", dto);
	}
	// 비밀번호 체크
	public String checkPw(UserDTO dto) {
		dto.setUSER_PW(SHA256.getSHA256(dto.getUSER_PW()));
		String name = mybatis.selectOne("UserMapper.checkPw", dto);
		return name;
	}

	// 내 정보 확인
	public UserDTO myInfo(UserDTO dto) {
		return mybatis.selectOne("UserMapper.viewUser", dto);
	}

	// 내 프로필 사진 
	public String myProfile(String USER_ID) {
		// TODO Auto-generated method stub
		return  mybatis.selectOne("UserMapper.myProfile", USER_ID);
	}

	/* 나의 프로젝트 */
	// 진행중인 프로젝트 - 의뢰
	public List<ProjectDTO> ingMyProject(String USER_ID) {
		// TODO Auto-generated method stub
		return mybatis.selectList("UserMapper.ingMyProject", USER_ID);
	}

	// 완료한 프로젝트 - 의뢰
	public List<ProjectDTO> edMyProject(String USER_ID) {
		// TODO Auto-generated method stub
		return mybatis.selectList("UserMapper.edMyProject", USER_ID);
	}
	
	/* 프로젝트 지원 형황 */
	// 진행중인 나의 프로젝트 - 지원
	public List<ProjectDTO> rIngMyProject(String USER_ID) {
		// TODO Auto-generated method stub
		return mybatis.selectList("UserMapper.rIngMyProject", USER_ID);
	}
	// 지원 요청된 프로젝트 
	public List<ProjectDTO> requestedProject(String USER_ID) {
		// TODO Auto-generated method stub
		return mybatis.selectList("UserMapper.requestedProject", USER_ID);
	}
	// 지원한 프로젝트
	public List<ProjectDTO> requestProject(String USER_ID) {
		// TODO Auto-generated method stub
		return mybatis.selectList("UserMapper.requestProject", USER_ID);
	}
	// 완료한 프로젝트 - 지원
	public List<ProjectDTO> rEdMyProject(String USER_ID) {
		// TODO Auto-generated method stub
		return mybatis.selectList("UserMapper.rEdMyProject", USER_ID);
	}

	// home 프로젝트 리스트
	public List<ProjectViewDTO> viewProjectList(String PROJECT_MAIN_KATEGORY) {
		// TODO Auto-generated method stub
		return mybatis.selectList("UserMapper.viewProjectList", PROJECT_MAIN_KATEGORY);
	}

	public List<UserDTO> UserList() {
		return mybatis.selectList("UserMapper.UserList");
	}

	public List<UserDTO> UserListALL(String FREELANCER_MAIN_KATEGORY) {
		// TODO Auto-generated method stub
		return mybatis.selectList("UserMapper.UserListALL", FREELANCER_MAIN_KATEGORY);
	}
}
