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

//[DB���� ����] 3. �������̽� �޾Ƽ� Ŭ���� ����
@Repository
public class ProjectDAO {
	// �����̳ʰ� ��ü�� �ڵ����� ���� Autowired
	@Autowired
	public SqlSessionTemplate mybatis;

	// ������Ʈ ���
	public void projectWrite(ProjectDTO dto) {

		mybatis.insert("BoardMapper.projectWrite", dto);

	}

	public String getImage(String USER_ID) {
		return mybatis.selectOne("BoardMapper.getImage", USER_ID);
	}

	// ������Ʈ ����
	public void projectJoin(ProjectJoinDTO dto) {

		mybatis.insert("BoardMapper.projectJoin", dto);
	}

	// ������Ʈ ��� ��ȸ
	public List<ProjectDTO> listAll() {
		// TODO Auto-generated method stub
		// return mybatis.selectOne("UserMapper.viewUser", dto);

		return mybatis.selectList("BoardMapper.projectListAll");
	}

	// ������Ʈ ��ȸ
	public ProjectDTO projectRead(int PROJECT_IDX) {
		return mybatis.selectOne("BoardMapper.projectView", PROJECT_IDX);
	}

	// �Խñ� �� ����

	public int countBoard() {
		return mybatis.selectOne("BoardMapper.countBoard");
	}

	// ����¡ ó�� �Խñ� ��ȸ

	public List<ProjectDTO> selectProject(PagingDTO dto) {
		return mybatis.selectList("BoardMapper.selectBoard", dto);
	}

	//ȸ�� �� ����
	public List<ProjectDTO> freelancerCount(){
		return mybatis.selectList("BoardMapper.getFreeCount");
	}
	
	// �ٹ� ���¸� ����
	public List<ProjectDTO> getW(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getW", map);
	}

	// �������¸� ����
	public List<ProjectDTO> getMKD(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getMKD", map);
	}

	// ������ ���¸� ����
	public List<ProjectDTO> getMKDS(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getMKDS", map);
	}

	// ������ ����
	public List<ProjectDTO> getAddr(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getAddr", map);
	}

	// �ٹ� ���߸� ����
	public List<ProjectDTO> getWMKD(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWMKD", map);
	}

	// �ٹ� ������ ���¸� ����
	public List<ProjectDTO> getWMKDS(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWMKDS", map);
	}

	// �ٹ� ������ ����
	public List<ProjectDTO> getWADDR(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWADDR", map);
	}

	// ���� �����θ� ����
	public List<ProjectDTO> getDMKD(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getDMKD", map);
	}

	// ���� �����θ� ����
	public List<ProjectDTO> getMADDR(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getMADDR", map);
	}

	// ������ ������ ����
	public List<ProjectDTO> getMKADDR(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getMKADDR", map);
	}

	// �ٹ� ���� �����θ� ����
	public List<ProjectDTO> getWDMKD(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWDMKD", map);
	}

	// �ٹ� ���� ������ ����
	public List<ProjectDTO> getWMKDADDR(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWMKDADDR", map);
	}

	// �ٹ� ������ ������ ����
	public List<ProjectDTO> getWDMKDADDR(Map<String, Object> map) {
		return mybatis.selectList("BoardMapper.getWDMKDADDR", map);
	}

	//�̹��� ������Ʈ �Ѿ�
	public int projectTotal(String yearMonth) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BoardMapper.getProjectTotal", yearMonth);
	}

	//�̹��� ������ ������Ʈ �Ѿ�
	public List<ProjectDTO> projectingTotal(String yearMonth) {
		// TODO Auto-generated method stub
		return mybatis.selectList("BoardMapper.getProjectingTotal", yearMonth);
	}

	public int bbsCount() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BoardMapper.bbsAllCount");
	}
	
	public int bbsCount(String yearMonth) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BoardMapper.bbsCount", yearMonth);
	}

	public int proCount(String yearMonth) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BoardMapper.proCount", yearMonth);
	}

	public int finishCount(String yearMonth) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BoardMapper.finishCount", yearMonth);
	}

	//�Ϲ� �Խñ� ��������
	public List<BoardDTO> normalList() {
		// TODO Auto-generated method stub
		return mybatis.selectList("BoardMapper.normalList");
	}

	//������ �Խñ� ��������
	public List<ProjectDTO> proList() {
		// TODO Auto-generated method stub
		return mybatis.selectList("BoardMapper.proList");
	}

	public List<ProjectDTO> finishList() {
		// TODO Auto-generated method stub
		return mybatis.selectList("BoardMapper.finishList");
	}

	/*
	 * // ���� ���� public List<ProjectDTO> getAll(Map<String, Object> map) { //return
	 * mybatis.selectList("BoardMapper.getAll", map); }
	 */

}
