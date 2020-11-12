package com.spring.freecloud.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.freecloud.dto.BoardDTO;
import com.spring.freecloud.dto.ProjectJoinDTO;
import com.spring.freecloud.dto.ProjectDTO;
import com.spring.freecloud.dto.UserDTO;
import com.spring.freecloud.service.BoardService;
import com.spring.freecloud.service.EtcService;
import com.spring.freecloud.service.ProjectService;
import com.spring.freecloud.service.UserService;
import com.spring.freecloud.util.PagingDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService boardSer;
	@Autowired
	EtcService etcSer;
	

	// 게시글 등록 화면
	@RequestMapping(value = "boardReg.do")
	public String boardReg(Locale locale, Model model) {
		return "boardReg";
	}

	// 게시글 등록 처리
	@RequestMapping(value = "boardRegOk.do", method = RequestMethod.POST)
	public ModelAndView projectWrite(Locale local, BoardDTO dto, HttpServletRequest request, HttpSession session)
			throws Exception {

		System.out.println("게시글 등록 테스트 / 세션 아이디 값 :  " + session.getAttribute("userId"));

		String USER_ID = (String) session.getAttribute("userId");
		dto.setUSER_ID(USER_ID);

		System.out.println("아이디 : " + dto.getUSER_ID());
		System.out.println("분류 " + dto.getBBS_MAIN_KATEGORY());

		boardSer.projectWrite(dto);

		System.out.println("등록완료");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardList");
		mav = setTop(mav);
		return mav;
	}

	// 게시글 리스트 조회 ( 페이징 )
	@RequestMapping(value = "boardList.do")
	public ModelAndView boardList(PagingDTO dto, Model model,

			@RequestParam(value = "nowPage", required = false) String nowPage,

			@RequestParam(value = "cntPerPage", required = false) String cntPerPage

	) {

		System.out.println("게시판 목록 보여주기 시작");

		int total = boardSer.countBoard();

		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";

		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}

		dto = new PagingDTO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

		List<BoardDTO> list = boardSer.selectProject(dto);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "번째 값 : " + list.get(i));
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardList");
		mav.addObject("paging", dto);
		mav.addObject("viewAll", list);
		mav = setTop(mav);
		return mav;
	}

	// 게시글 상세 조회
	@RequestMapping(value = "boardView.do")
	public ModelAndView view(@RequestParam int BBS_IDX, HttpSession session) {

		System.out.println("게시글 상세보기 시작 // 넘어온 게시글 번호 " + BBS_IDX);
		//boardSer.increaseView(BBS_IDX, session);

		ModelAndView mav = new ModelAndView();

		mav.setViewName("boardView");

		mav.addObject("dto", boardSer.projectRead(BBS_IDX));
		mav = setTop(mav);
		return mav;
	}
	
	//게시글 수정
	@RequestMapping(value = "boardUpdateOk.do")
	public String update(Locale local, BoardDTO dto, HttpServletRequest request, HttpSession session) {

		int BBS_IDX = Integer.parseInt(request.getParameter("BBS_IDX"));
		System.out.println("게시글 업데이트 시작 // 넘어온 게시글 번호 " + BBS_IDX + "유저 아이디 " + session.getAttribute("userId"));

		String USER_ID = (String) session.getAttribute("userId");
		dto.setUSER_ID(USER_ID);
		dto.setBBS_IDX(BBS_IDX);
		
		System.out.println("번호 : " + dto.getBBS_IDX());
		System.out.println("아이디 : " + dto.getUSER_ID());
		System.out.println("분류 " + dto.getBBS_MAIN_KATEGORY());

		
		  boardSer.projectUpdate(dto);
		  
		  System.out.println("수정 완료");

		return "redirect:boardView.do?BBS_IDX="+BBS_IDX;
	}
	
	 // 상단 배너
 	ModelAndView setTop(ModelAndView mav) {
 		int regProject = 0;
 		int regFree = 0;
 		int edPrice = 0;
 		int allUser = 0;

 		regProject = etcSer.ProjectCount();
 		regFree = etcSer.RegFreeCount();
 		edPrice = etcSer.EdPrice();
 		allUser = etcSer.AllUser();
 		System.out.println("완료한 금액 : " + regFree);

 		mav.addObject("regProject", regProject);
 		mav.addObject("regFree", regFree);
 		mav.addObject("edPrice", edPrice);
 		mav.addObject("allUser", allUser);
 		return mav;
 	}

	/*
	 * // 프로젝트 게시글 리스트 조회 화면
	 * 
	 * @RequestMapping(value = "projectSearch.do") public ModelAndView list() {
	 * 
	 * List<ProjectDTO> list = projectSer.listAll();
	 * 
	 * for(int i=0; i<list.size(); i++) { System.out.println(i+ "번째 값 " +
	 * list.get(i)); }
	 * 
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.setViewName("projectSearch");
	 * mav.addObject("list", list);
	 * 
	 * return mav;
	 * 
	 * }
	 */

	/*
	 * // 프로젝트 게시글 조회
	 * 
	 * @RequestMapping(value = "boardView.do") public ModelAndView
	 * view(@RequestParam int PROJECT_IDX, HttpSession session) {
	 * 
	 * projectSer.increaseView(PROJECT_IDX, session);
	 * 
	 * ModelAndView mav = new ModelAndView();
	 * 
	 * mav.setViewName("projectView");
	 * 
	 * mav.addObject("dto", projectSer.projectRead(PROJECT_IDX)); return mav; }
	 */

}
