package com.spring.freecloud.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.freecloud.dto.MyfreelancerDTO;


//[DB연결 사용법] 3. 인터페이스 받아서 클래스 생성
@Repository
public class EtcDAO {
	// 컨테이너가 객체를 자동으로 생성 Autowired
	@Autowired
	public SqlSessionTemplate mybatis;

	public int ProjectCount() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("EtcMapper.ProjectCount");
	}

	public int RegFreeCount() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("EtcMapper.RegFreeCount");
	}

	public int EdPrice() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("EtcMapper.EdPrice");
	}

	public int AllUser() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("EtcMapper.AllUser");
	}

	public int RequestProject(String pROJECT_IDX, String PROJECT_SUBJECT, String freeid, String clientId) {
		// TODO Auto-generated method stub
		MyfreelancerDTO dto = new MyfreelancerDTO();
		dto.setCLIENT_ID(clientId);
		dto.setFREELANCER_ID(freeid);
		dto.setPROJECT_IDX(Integer.parseInt(pROJECT_IDX));
		dto.setPROJECT_SUBJECT(PROJECT_SUBJECT);
		return mybatis.insert("EtcMapper.RequestProject", dto);
	}

	
}
