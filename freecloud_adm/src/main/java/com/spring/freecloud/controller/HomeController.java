package com.spring.freecloud.controller;

import java.text.DateFormat;
import java.util.Date;
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

import com.spring.freecloud.dto.ProjectViewDTO;
import com.spring.freecloud.dto.UserDTO;
import com.spring.freecloud.service.EtcService;
import com.spring.freecloud.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	UserService userSer;
	@Autowired
	EtcService etcSer;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// 홈페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {

		ModelAndView mav = new ModelAndView();
		mav = setTop(mav);
		mav.setViewName("admin_views/main");
		return mav;
	}

	// 홈페이지
	@RequestMapping(value = "home.do")
	public ModelAndView homepage(Locale locale, Model model) {

		ModelAndView mav = new ModelAndView();

		mav = sethome(mav);
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
	
	ModelAndView sethome(ModelAndView mav) {
		mav = setTop(mav);
		// 진행중인 프로젝트
		List<ProjectViewDTO> list1 = null;
		List<ProjectViewDTO> list2 = null;
		List<ProjectViewDTO> list3 = null;
		List<ProjectViewDTO> list4 = null;
		List<ProjectViewDTO> list5 = null;
		// 추천 유저 리스트
		List<UserDTO> list6 = null;
		// 모든 유저 리스트
		List<UserDTO> list7 = null;
		List<UserDTO> list8 = null;
		List<UserDTO> list9 = null;
		List<UserDTO> list10 = null;
		List<UserDTO> list11 = null;

		// 진행중인 프로젝트 목록 가져오기
		list1 = userSer.viewProjectList("design");
		list2 = userSer.viewProjectList("devel");
		list3 = userSer.viewProjectList("contents");
		list4 = userSer.viewProjectList("consulting");
		list5 = userSer.viewProjectList("order");

		// 추천유저리스트
		list6 = userSer.UserList();
		// 유저리스트
		list7 = userSer.UserListALL("design");
		list8 = userSer.UserListALL("devel");
		list9 = userSer.UserListALL("contents");
		list10 = userSer.UserListALL("consulting");
		list11 = userSer.UserListALL("order");

		// 진행중인 프로젝트
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		mav.addObject("list3", list3);
		mav.addObject("list4", list4);
		mav.addObject("list5", list5);
		mav.addObject("list6", list6);
		mav.addObject("list7", list7);
		mav.addObject("list8", list8);
		mav.addObject("list9", list9);
		mav.addObject("list10", list10);
		mav.addObject("list11", list11);

		mav.setViewName("admin_views/main");
		return mav;
	}
}
