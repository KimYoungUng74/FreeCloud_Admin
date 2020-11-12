package com.spring.freecloud.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.freecloud.dao.ProjectDAO;
import com.spring.freecloud.dto.ProjectJoinDTO;
import com.spring.freecloud.util.PagingDTO;
import com.spring.freecloud.dto.ProjectDTO;

@Service("IProjectService")
public class ProjectService {

	// 인터페이스로 생성해야함
	@Autowired
	public ProjectDAO dao;

	// 게시글 등록
	public void projectWrite(ProjectDTO dto) {
		dao.projectWrite(dto); // 게시글 등록

	}

	public String getImage(String USER_ID) {
		return dao.getImage(USER_ID);
	}

	// 게시글 리스트 조회
	public List<ProjectDTO> listAll() {
		// TODO Auto-generated method stub

		return dao.listAll();
	}

	// 게시글 조회
	public ProjectDTO projectRead(int PROJECT_IDX) {
		return dao.projectRead(PROJECT_IDX);
	}

	// 프로젝트 참여 (프리랜서 -> 프로젝트)
	public void projectJoin(ProjectJoinDTO dto) {
		dao.projectJoin(dto);
	}

	// 게시글 총 갯수

	public int countBoard() {
		return dao.countBoard();
	}

	// 페이징 처리 게시글 조회

	public List<ProjectDTO> selectProject(PagingDTO dto) {
		return dao.selectProject(dto);
	}

	// 근무 형태만 선택
	public List<ProjectDTO> getW(Map<String, Object> map) {
		return dao.getW(map);
	}

	// 개발 형태만 선택
	public List<ProjectDTO> getMKD(Map<String, Object> map) {
		return dao.getMKD(map);
	}

	// 디자인 형태만 선택
	public List<ProjectDTO> getMKDS(Map<String, Object> map) {
		return dao.getMKDS(map);
	}

	// 지역만 선택
	public List<ProjectDTO> getAddr(Map<String, Object> map) {
		return dao.getAddr(map);
	}

	// 근무 개발 선택
	public List<ProjectDTO> getWMKD(Map<String, Object> map) {
		return dao.getWMKD(map);
	}

	// 근무 디자인 선택
	public List<ProjectDTO> getWMKDS(Map<String, Object> map) {
		return dao.getWMKDS(map);
	}

	// 근무 지역만 선택
	public List<ProjectDTO> getWADDR(Map<String, Object> map) {
		return dao.getWADDR(map);
	}

	// 개발 디자인만 선택
	public List<ProjectDTO> getDMKD(Map<String, Object> map) {
		return dao.getDMKD(map);
	}

	// 개발 지역만 선택
	public List<ProjectDTO> getMADDR(Map<String, Object> map) {
		return dao.getMADDR(map);
	}

	// 디자인 지역만 선택
	public List<ProjectDTO> getMKADDR(Map<String, Object> map) {
		return dao.getMKADDR(map);
	}

	// 근무 개발 디자인만 선택
	public List<ProjectDTO> getWDMKD(Map<String, Object> map) {
		return dao.getWDMKD(map);
	}

	// 근무 개발 지역만 선택
	public List<ProjectDTO> getWMKDADDR(Map<String, Object> map) {
		return dao.getWMKDADDR(map);
	}

	// 근무 디자인 지역만 선택
	public List<ProjectDTO> getWDMKDADDR(Map<String, Object> map) {
		return dao.getWDMKDADDR(map);
	}

	/*
	 * // 전부 선택 public List<ProjectDTO> getAll(Map<String, Object> map) { return
	 * dao.getAll(map); }
	 */

}
