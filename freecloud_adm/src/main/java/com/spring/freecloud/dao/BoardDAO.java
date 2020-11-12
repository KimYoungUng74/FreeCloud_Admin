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
import com.spring.freecloud.dto.BoardDTO;
import com.spring.freecloud.dto.ProjectDTO;
import com.spring.freecloud.dto.UserDTO;
import com.spring.freecloud.util.PagingDTO;
import com.spring.freecloud.util.SHA256;

//[DB연결 사용법] 3. 인터페이스 받아서 클래스 생성
@Repository
public class BoardDAO {
	// 컨테이너가 객체를 자동으로 생성 Autowired
	@Autowired
	public SqlSessionTemplate mybatis;

	// 프로젝트 등록
	public void projectWrite(BoardDTO dto) {

		mybatis.insert("BoardMapper.boardWrite", dto);

	}

	// 게시글 수정
	public void projectUpdate(BoardDTO dto) {

		mybatis.update("BoardMapper.boardUpdate", dto);

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
	public BoardDTO projectRead(int BBS_IDX) {
		return mybatis.selectOne("BoardMapper.boardView", BBS_IDX);
	}

	// 게시글 총 갯수

	public int countBoard() {
		return mybatis.selectOne("BoardMapper.countBoardList");
	}

	// 페이징 처리 게시글 조회

	public List<BoardDTO> selectProject(PagingDTO dto) {
		return mybatis.selectList("BoardMapper.selectBoardList", dto);
	}

	// 프로젝트 수정
	public void projectUpdate(ProjectDTO dto) {

	}

	// 프로젝트 삭제
	public void projectRemove(ProjectDTO dto) {

	}

}
