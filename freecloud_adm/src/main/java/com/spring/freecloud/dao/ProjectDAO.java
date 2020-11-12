package com.spring.freecloud.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.freecloud.dto.ProjectJoinDTO;
import com.spring.freecloud.dto.ProjectDTO;
import com.spring.freecloud.dto.UserDTO;
import com.spring.freecloud.util.PagingDTO;
import com.spring.freecloud.util.SHA256;

//[DB연결 사용법] 3. 인터페이스 받아서 클래스 생성
@Repository
public class ProjectDAO {
	// 컨테이너가 객체를 자동으로 생성 Autowired
	@Autowired
	public SqlSessionTemplate mybatis;

	// 프로젝트 등록
	public void projectWrite(ProjectDTO dto) {

		mybatis.insert("BoardMapper.projectWrite", dto);

	}

	public String getImage(String USER_ID) {
		return mybatis.selectOne("BoardMapper.getImage", USER_ID);
	}

	// 프로젝트 참여
	public void projectJoin(ProjectJoinDTO dto) {

		mybatis.insert("BoardMapper.projectJoin", dto);
	}

	// 프로젝트 목록 조회
	public List<ProjectDTO> listAll() {
		// TODO Auto-generated method stub
		// return mybatis.selectOne("UserMapper.viewUser", dto);

		return mybatis.selectList("BoardMapper.projectListAll");
	}

	// 프로젝트 조회
	public ProjectDTO projectRead(int PROJECT_IDX) {
		return mybatis.selectOne("BoardMapper.projectView", PROJECT_IDX);
	}

	// 게시글 총 갯수

	public int countBoard() {
		return mybatis.selectOne("BoardMapper.countBoard");
	}

	// 페이징 처리 게시글 조회

	public List<ProjectDTO> selectProject(PagingDTO dto) {
		return mybatis.selectList("BoardMapper.selectBoard", dto);
	}

	// 근무 형태만 선택
	public List<ProjectDTO> getW(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getW", map);
	}

	// 개발형태만 선택
	public List<ProjectDTO> getMKD(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getMKD", map);
	}

	// 디자인 형태만 선택
	public List<ProjectDTO> getMKDS(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getMKDS", map);
	}

	// 지역만 선택
	public List<ProjectDTO> getAddr(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getAddr", map);
	}

	// 근무 개발만 선택
	public List<ProjectDTO> getWMKD(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWMKD", map);
	}

	// 근무 디자인 형태만 선택
	public List<ProjectDTO> getWMKDS(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWMKDS", map);
	}

	// 근무 지역만 선택
	public List<ProjectDTO> getWADDR(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWADDR", map);
	}

	// 개발 디자인만 선택
	public List<ProjectDTO> getDMKD(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getDMKD", map);
	}

	// 개발 디자인만 선택
	public List<ProjectDTO> getMADDR(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getMADDR", map);
	}

	// 디자인 지역만 선택
	public List<ProjectDTO> getMKADDR(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getMKADDR", map);
	}

	// 근무 개발 디자인만 선택
	public List<ProjectDTO> getWDMKD(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWDMKD", map);
	}

	// 근무 개발 지역만 선택
	public List<ProjectDTO> getWMKDADDR(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWMKDADDR", map);
	}

	// 근무 디자인 지역만 선택
	public List<ProjectDTO> getWDMKDADDR(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWDMKDADDR", map);
	}

	/*
	 * // 전부 선택 public List<ProjectDTO> getAll(Map<String, Object> map) { //return
	 * mybatis.selectList("BoardMapper.getAll", map); }
	 */

}
