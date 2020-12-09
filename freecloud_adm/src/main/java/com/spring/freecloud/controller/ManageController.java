package com.spring.freecloud.controller;


import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.freecloud.dto.InquireDTO;
import com.spring.freecloud.dto.ProjectDTO;
import com.spring.freecloud.dto.UserDTO;
import com.spring.freecloud.service.EtcService;
import com.spring.freecloud.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ManageController {

	private static final Logger logger = LoggerFactory.getLogger(ManageController.class);

	@Autowired
	UserService userSer;
	@Autowired
	EtcService etcSer;

	// xml에 설정된 리소스 참조
	// 회원 정보
	@RequestMapping(value = "userManage.do")
	public ModelAndView userManage(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin_views/users/user_search");
		mav = setTop(mav);
		return mav;
	}
	
	// 문의내역
	@RequestMapping(value = "inquireManage.do")
	public ModelAndView inquireManage(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin_views/users/user_question");
		mav = setTop(mav);
		return mav;
	}
	
	// 문의내역
		@RequestMapping(value = "inquireManageRep.do")
		public ModelAndView inquireManageRep(Locale locale, Model model, String TITLE, String CATEGORY) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("TITLE", TITLE); // 제재내역
			mav.addObject("CATEGORY", CATEGORY); // 제재내역
			mav.setViewName("admin_views/users/user_question_reply");
			mav = setTop(mav);
			return mav;
		}
	
	// 제재내역
	@RequestMapping(value = "restraintManage.do")
	public ModelAndView restraintManage(Locale locale, Model model) {
		List<UserDTO> list = null; // 제재내역
		
		list = userSer.restraintList();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin_views/users/user_sanctions");
		mav.addObject("list", list); // 제재내역
		mav = setTop(mav);
		return mav;
	}
	
	// 제재내역
		@RequestMapping(value = "restraint.do")
		public ModelAndView restraint(Locale locale, Model model, UserDTO dto) {
			List<UserDTO> list = null; // 제재내역
			
			list = userSer.restraintList();
			
			System.out.println(dto.getWHY_RESTRAINT());
			
			if (1 == userSer.restraint(dto)) {
				System.out.println("제재 되었음");
			} else {
				System.out.println("제재 실패");
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("admin_views/users/user_sanctions");
			mav.addObject("list", list); // 제재내역
			mav = setTop(mav);
			return mav;
		}
	
	@RequestMapping(value = "usersearch.do")
	public ModelAndView usersearch(Locale locale, Model model, String search) {

		List<UserDTO> userList = null;
		userList = userSer.UserList(search);
		
 		//System.out.println(userList); 
		
		ModelAndView mav = new ModelAndView();
		mav = setTop(mav);
		mav.setViewName("admin_views/search/user_search_result");
		
		mav.addObject("list", userList);
		return mav;
	}
	
	@RequestMapping(value = "user_info.do")
	public ModelAndView user_info(Locale locale, Model model, String userID) {
		
		List<ProjectDTO> ingList = null; // 진행중인 프로젝트
		List<ProjectDTO> edList = null; // 완료한 프로젝트
		String myprofile = userSer.myProfile(userID); // 프로필 사진 가져오기
		ingList = userSer.ingMyProject(userID); // 진행중인 프로젝트 - 의뢰
		edList = userSer.edMyProject(userID);  // 완료한 프로젝트 - 의뢰
		
		System.out.println("user_info에 접근함");
		UserDTO dto = new UserDTO();
		dto = userSer.myInfo(userID);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ingList", ingList);
		mav.addObject("edList", edList);
		mav.addObject("myprofile", myprofile);
		mav.addObject("dto", dto);
		mav = setTop(mav);
		mav.setViewName("admin_views/users/user_info");
		return mav;
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

}
