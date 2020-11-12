package com.spring.freecloud.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.freecloud.dao.BoardDAO;
import com.spring.freecloud.dao.ProjectDAO;
import com.spring.freecloud.dto.BoardDTO;
import com.spring.freecloud.dto.ProjectDTO;
import com.spring.freecloud.dto.ProjectJoinDTO;
import com.spring.freecloud.util.PagingDTO;

@Service("IBoardService")
public class BoardService {

	// 인터페이스로 생성해야함
	@Autowired
	public BoardDAO dao;

	// 게시글 등록
	public void projectWrite(BoardDTO dto) {
		dao.projectWrite(dto); // 게시글 등록

	}

	// 게시글 수정
	public void projectUpdate(BoardDTO dto) {
		dao.projectUpdate(dto); 

	}

	// 게시글 리스트 조회
	public List<ProjectDTO> listAll() {
		// TODO Auto-generated method stub

		return dao.listAll();
	}

	// 게시글 조회
	public BoardDTO projectRead(int BBS_IDX) {
		return dao.projectRead(BBS_IDX);
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

	public List<BoardDTO> selectProject(PagingDTO dto) {
		return dao.selectProject(dto);
	}

	// 조회수
	public void increaseView(int PROJECT_IDX, HttpSession session) {

	}


}
