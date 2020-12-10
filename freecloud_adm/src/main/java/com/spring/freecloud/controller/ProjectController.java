package com.spring.freecloud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	ProjectService projectSer;
	
	@Autowired
	EtcService etcSer;
	
	@Autowired
	UserService userSer;

	Calendar cal = Calendar.getInstance();
	String YEAR = Integer.toString(cal.get(Calendar.YEAR) - 2000); // 현재 년도 계산
	String MONTH = Integer.toString(cal.get(Calendar.MONTH) + 1); // 현재 월 계산


	// 중개수수료 관리
	@RequestMapping(value = "manageFees.do")
	public ModelAndView manageFees(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin_views/fee/manage_fees");
		mav = setTop(mav);

		String YearMonth = YEAR + "/" + MONTH;

		// 총액수 , 지불해야할 돈 , 순이익
		int project_total = projectSer.projectTotal(YearMonth);
		int profit = (int) (project_total * 0.05);
		int payment = project_total - profit;

		// 5개까지 가격 높은순으로 출력
		List<ProjectDTO> list = null;
		list = projectSer.projectingTotal(YearMonth);

		mav.addObject("year", YEAR);
		mav.addObject("month", MONTH);

		mav.addObject("total", project_total);
		mav.addObject("profit", profit);
		mav.addObject("payment", payment);

		mav.addObject("list", list);

		// 1~12월 순이익 각각 계산
		int m1 = projectSer.projectTotal(YEAR + "/01");
		System.out.println(YEAR + "/01");
		int m1f = (int) (m1 * 0.05);

		System.out.println(m1 + "임");
		mav.addObject("m1f", m1f);

		int m2 = projectSer.projectTotal(YEAR + "/02");
		int m2f = (int) (m2 * 0.05);

		int m3 = projectSer.projectTotal(YEAR + "/03");
		int m3f = (int) (m3 * 0.05);

		int m4 = projectSer.projectTotal(YEAR + "/04");
		int m4f = (int) (m4 * 0.05);

		int m5 = projectSer.projectTotal(YEAR + "/05");
		int m5f = (int) (m5 * 0.05);

		int m6 = projectSer.projectTotal(YEAR + "/06");
		int m6f = (int) (m6 * 0.05);

		int m7 = projectSer.projectTotal(YEAR + "/07");
		int m7f = (int) (m7 * 0.05);

		int m8 = projectSer.projectTotal(YEAR + "/08");
		int m8f = (int) (m8 * 0.05);

		int m9 = projectSer.projectTotal(YEAR + "/09");
		int m9f = (int) (m9 * 0.05);

		int m10 = projectSer.projectTotal(YEAR + "/10");
		int m10f = (int) (m10 * 0.05);

		int m11 = projectSer.projectTotal(YEAR + "/11");
		int m11f = (int) (m11 * 0.05);

		int m12 = projectSer.projectTotal(YEAR + "/12");
		int m12f = (int) (m12 * 0.05);

		mav.addObject("m2f", m2f);
		mav.addObject("m3f", m3f);
		mav.addObject("m4f", m4f);
		mav.addObject("m5f", m5f);
		mav.addObject("m6f", m6f);
		mav.addObject("m7f", m7f);
		mav.addObject("m8f", m8f);
		mav.addObject("m9f", m9f);
		mav.addObject("m10f", m10f);
		mav.addObject("m11f", m11f);
		mav.addObject("m12f", m12f);

		return mav;
	}

	// 회원 수 통계 화면
	@RequestMapping(value = "userStatistics.do")
	public ModelAndView userStatic(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		String YearMonth = YEAR + "/" + MONTH;
		// 일반회원
		int nomarCount = userSer.normalCount(YearMonth);
		mav.addObject("nc", nomarCount);

		int m1 = userSer.normalCount(YEAR + "/01");
		int m2 = userSer.normalCount(YEAR + "/02");
		int m3 = userSer.normalCount(YEAR + "/03");
		int m4 = userSer.normalCount(YEAR + "/04");
		int m5 = userSer.normalCount(YEAR + "/05");
		int m6 = userSer.normalCount(YEAR + "/06");
		int m7 = userSer.normalCount(YEAR + "/07");
		int m8 = userSer.normalCount(YEAR + "/08");
		int m9 = userSer.normalCount(YEAR + "/09");
		int m10 = userSer.normalCount(YEAR + "/10");
		int m11 = userSer.normalCount(YEAR + "/11");
		int m12 = userSer.normalCount(YEAR + "/12");

		mav.addObject("m1", m1);
		mav.addObject("m2", m2);
		mav.addObject("m3", m3);
		mav.addObject("m4", m4);
		mav.addObject("m5", m5);
		mav.addObject("m6", m6);
		mav.addObject("m7", m7);
		mav.addObject("m8", m8);
		mav.addObject("m9", m9);
		mav.addObject("m10", m10);
		mav.addObject("m11", m11);
		mav.addObject("m12", m12);

		// 프리랜서
		int freeCount = userSer.freeCount(YearMonth);
		mav.addObject("fc", freeCount);

		int n1 = userSer.freeCount(YEAR + "/01");
		int n2 = userSer.freeCount(YEAR + "/02");
		int n3 = userSer.freeCount(YEAR + "/03");
		int n4 = userSer.freeCount(YEAR + "/04");
		int n5 = userSer.freeCount(YEAR + "/05");
		int n6 = userSer.freeCount(YEAR + "/06");
		int n7 = userSer.freeCount(YEAR + "/07");
		int n8 = userSer.freeCount(YEAR + "/08");
		int n9 = userSer.freeCount(YEAR + "/09");
		int n10 = userSer.freeCount(YEAR + "/10");
		int n11 = userSer.freeCount(YEAR + "/11");
		int n12 = userSer.freeCount(YEAR + "/12");

		mav.addObject("n1", n1);
		mav.addObject("n2", n2);
		mav.addObject("n3", n3);
		mav.addObject("n4", n4);
		mav.addObject("n5", n5);
		mav.addObject("n6", n6);
		mav.addObject("n7", n7);
		mav.addObject("n8", n8);
		mav.addObject("n9", n9);
		mav.addObject("n10", n10);
		mav.addObject("n11", n11);
		mav.addObject("n12", n12);

		// 탈퇴회원
		int outCount = userSer.outCount(YearMonth);
		mav.addObject("oc", outCount);

		int o1 = userSer.outCount(YEAR + "/01") * -1;
		int o2 = userSer.outCount(YEAR + "/02") * -1;
		int o3 = userSer.outCount(YEAR + "/03") * -1;
		int o4 = userSer.outCount(YEAR + "/04") * -1;
		int o5 = userSer.outCount(YEAR + "/05") * -1;
		int o6 = userSer.outCount(YEAR + "/06") * -1;
		int o7 = userSer.outCount(YEAR + "/07") * -1;
		int o8 = userSer.outCount(YEAR + "/08") * -1;
		int o9 = userSer.outCount(YEAR + "/09") * -1;
		int o10 = userSer.outCount(YEAR + "/10") * -1;
		int o11 = userSer.outCount(YEAR + "/11") * -1;
		int o12 = userSer.outCount(YEAR + "/12") * -1;

		mav.addObject("o1", o1);
		mav.addObject("o2", o2);
		mav.addObject("o3", o3);
		mav.addObject("o4", o4);
		mav.addObject("o5", o5);
		mav.addObject("o6", o6);
		mav.addObject("o7", o7);
		mav.addObject("o8", o8);
		mav.addObject("o9", o9);
		mav.addObject("o10", o10);
		mav.addObject("o11", o11);
		mav.addObject("o12", o12);

		mav.addObject("year", YEAR);
		mav.addObject("month", MONTH);

		mav.setViewName("admin_views/statistics/statistics_users");

		mav = setTop(mav);
		return mav;
	}

	// 프로젝트 통계 화면
	@RequestMapping(value = "projectStatistics.do")
	public ModelAndView projectStatic(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		String YearMonth = YEAR + "/" + MONTH;

		// 올라온 게시물 갯수
		int bbsCount = projectSer.bbsCount(YearMonth);
		mav.addObject("bbsCount", bbsCount);

		// 진행중인 게시물 갯수
		int proCount = projectSer.proCount(YearMonth);
		mav.addObject("proCount", proCount);

		// 완료한 게시물 갯수
		int finishCount = projectSer.finishCount(YearMonth);
		mav.addObject("finishCount", finishCount);

		mav.addObject("year", YEAR);
		mav.addObject("month", MONTH);

		mav.setViewName("admin_views/statistics/statistics_project");
		mav = setTop(mav);
		return mav;
	}

	// 수익 통계 화면
	@RequestMapping(value = "revenueStatistics.do")
	public ModelAndView statistics_revenue(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		String YearMonth = YEAR + "/" + MONTH;

		// 이번달 구독료 및 월별 구독료
		int sub_total = (userSer.subscriptTotal(YearMonth) * 9900);
		mav.addObject("sub_total", sub_total);

		int m1 = userSer.subscriptTotal(YEAR + "/01") * 9900;

		int m2 = userSer.subscriptTotal(YEAR + "/02") * 9900;

		int m3 = userSer.subscriptTotal(YEAR + "/03") * 9900;

		int m4 = userSer.subscriptTotal(YEAR + "/04") * 9900;

		int m5 = userSer.subscriptTotal(YEAR + "/05") * 9900;

		int m6 = userSer.subscriptTotal(YEAR + "/06") * 9900;

		int m7 = userSer.subscriptTotal(YEAR + "/07") * 9900;

		int m8 = userSer.subscriptTotal(YEAR + "/08") * 9900;

		int m9 = userSer.subscriptTotal(YEAR + "/09") * 9900;

		int m10 = userSer.subscriptTotal(YEAR + "/10") * 9900;

		int m11 = userSer.subscriptTotal(YEAR + "/11") * 9900;

		int m12 = userSer.subscriptTotal(YEAR + "/12") * 9900;

		mav.addObject("m1", m1);
		mav.addObject("m2", m2);
		mav.addObject("m3", m3);
		mav.addObject("m4", m4);
		mav.addObject("m5", m5);
		mav.addObject("m6", m6);
		mav.addObject("m7", m7);
		mav.addObject("m8", m8);
		mav.addObject("m9", m9);
		mav.addObject("m10", m10);
		mav.addObject("m11", m11);
		mav.addObject("m12", m12);

		// 총액수 , 순이익 및 월별 중개수수료
		int project_total = projectSer.projectTotal(YearMonth);
		int profit = (int) (project_total * 0.05);
		mav.addObject("profit", profit);

		int n1 = projectSer.projectTotal(YEAR + "/01");
		System.out.println(YEAR + "/01");
		int m1f = (int) (n1 * 0.05);

		System.out.println(m1 + "임");
		mav.addObject("m1f", m1f);

		int n2 = projectSer.projectTotal(YEAR + "/02");
		int m2f = (int) (n2 * 0.05);

		int n3 = projectSer.projectTotal(YEAR + "/03");
		int m3f = (int) (n3 * 0.05);

		int n4 = projectSer.projectTotal(YEAR + "/04");
		int m4f = (int) (n4 * 0.05);

		int n5 = projectSer.projectTotal(YEAR + "/05");
		int m5f = (int) (n5 * 0.05);

		int n6 = projectSer.projectTotal(YEAR + "/06");
		int m6f = (int) (n6 * 0.05);

		int n7 = projectSer.projectTotal(YEAR + "/07");
		int m7f = (int) (n7 * 0.05);

		int n8 = projectSer.projectTotal(YEAR + "/08");
		int m8f = (int) (n8 * 0.05);

		int n9 = projectSer.projectTotal(YEAR + "/09");
		int m9f = (int) (n9 * 0.05);

		int n10 = projectSer.projectTotal(YEAR + "/10");
		int m10f = (int) (n10 * 0.05);

		int n11 = projectSer.projectTotal(YEAR + "/11");
		int m11f = (int) (n11 * 0.05);

		int n12 = projectSer.projectTotal(YEAR + "/12");
		int m12f = (int) (n12 * 0.05);

		mav.addObject("m2f", m2f);
		mav.addObject("m3f", m3f);
		mav.addObject("m4f", m4f);
		mav.addObject("m5f", m5f);
		mav.addObject("m6f", m6f);
		mav.addObject("m7f", m7f);
		mav.addObject("m8f", m8f);
		mav.addObject("m9f", m9f);
		mav.addObject("m10f", m10f);
		mav.addObject("m11f", m11f);
		mav.addObject("m12f", m12f);

		// 총합
		int total = sub_total + profit;
		mav.addObject("total", total);

		mav.addObject("t1", m1f + m1);
		mav.addObject("t2", m2f + m2);
		mav.addObject("t3", m3f + m3);
		mav.addObject("t4", m4f + m4);
		mav.addObject("t5", m5f + m5);
		mav.addObject("t6", m6f + m6);
		mav.addObject("t7", m7f + m7);
		mav.addObject("t8", m8f + m8);
		mav.addObject("t9", m9f + m9);
		mav.addObject("t10", m10f + m10);
		mav.addObject("t11", m11f + m11);
		mav.addObject("t12", m12f + m12);

		mav.addObject("year", YEAR);
		mav.addObject("month", MONTH);
		mav.setViewName("admin_views/statistics/statistics_revenue");
		mav = setTop(mav);
		return mav;
	}

	// 프리미엄등급 구독료 관리
	@RequestMapping(value = "manage_subscription_fee.do")
	public ModelAndView manage_subscription_fee(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin_views/fee/manage_subscription_fee");

		String YearMonth = YEAR + "/" + MONTH;

		// 총 구독료
		int total = userSer.total();
		// 이번달 구독료
		int sub_total = (userSer.subscriptTotal(YearMonth) * 9900);

		// 상위 5명
		List<UserDTO> list = null;
		list = userSer.ranked();

		mav.addObject("year", YEAR);
		mav.addObject("month", MONTH);
		mav.addObject("total", total);
		mav.addObject("sub_total", sub_total);
		mav.addObject("list", list);
		mav = setTop(mav);

		int m1 = userSer.subscriptTotal(YEAR + "/01") * 9900;

		int m2 = userSer.subscriptTotal(YEAR + "/02") * 9900;

		int m3 = userSer.subscriptTotal(YEAR + "/03") * 9900;

		int m4 = userSer.subscriptTotal(YEAR + "/04") * 9900;

		int m5 = userSer.subscriptTotal(YEAR + "/05") * 9900;

		int m6 = userSer.subscriptTotal(YEAR + "/06") * 9900;

		int m7 = userSer.subscriptTotal(YEAR + "/07") * 9900;

		int m8 = userSer.subscriptTotal(YEAR + "/08") * 9900;

		int m9 = userSer.subscriptTotal(YEAR + "/09") * 9900;

		int m10 = userSer.subscriptTotal(YEAR + "/10") * 9900;

		int m11 = userSer.subscriptTotal(YEAR + "/11") * 9900;

		int m12 = userSer.subscriptTotal(YEAR + "/12") * 9900;

		mav.addObject("m1", m1);
		mav.addObject("m2", m2);
		mav.addObject("m3", m3);
		mav.addObject("m4", m4);
		mav.addObject("m5", m5);
		mav.addObject("m6", m6);
		mav.addObject("m7", m7);
		mav.addObject("m8", m8);
		mav.addObject("m9", m9);
		mav.addObject("m10", m10);
		mav.addObject("m11", m11);
		mav.addObject("m12", m12);

		return mav;
	}

	// 프로젝트 등록 화면
	@RequestMapping(value = "projectReg.do")
	public ModelAndView projectReg(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("projectReg");
		mav = setTop(mav);
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

	// 프로젝트 리스트 조회 ( 페이징 )
	@RequestMapping(value = "projectSearch.do")
	public ModelAndView list(PagingDTO dto, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "wk", required = false) String wk) {

		System.out.println("ProjectSearch.jsp" + wk);

		int total = projectSer.countBoard();

		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";

		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}

		dto = new PagingDTO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

		List<ProjectDTO> list = projectSer.selectProject(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("projectSearch");
		mav.addObject("paging", dto);
		mav.addObject("viewAll", list);
		mav = setTop(mav);
		return mav;
	}

	// 프로젝트 검색 테스트

	@RequestMapping(value = "testSearch.do")
	public ModelAndView test(PagingDTO dto, Model model,

			@RequestParam(value = "nowPage", required = false) String nowPage,

			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,

			@RequestParam(value = "wk", required = false) String wk,

			@RequestParam(value = "mkd", required = false) String mkd,

			@RequestParam(value = "mkds", required = false) String mkds,

			@RequestParam(value = "addr", required = false) String addr, HttpServletResponse response) {

		System.out.println("현재 페이지 : " + nowPage);
		System.out.println("카운트 페이지 : " + cntPerPage);
		System.out.println("근무 형태 : " + wk);
		System.out.println("메인 카테고리 : " + mkd);
		System.out.println("미들 카테고리 : " + mkds);
		System.out.println("지역 : " + addr);

		if (wk == "undefined") {
			System.out.println("안해안해");
		}
		List<ProjectDTO> list = null;
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";

		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}

		int total = projectSer.countBoard();
		dto = new PagingDTO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

		int end = dto.getEnd();
		int start = dto.getStart();

		Map<String, Object> map = new HashMap<String, Object>();

		// 1.근무 형태만 선택되었을 때
		if (wk != null) {
			if (mkd == "") {
				if (mkds == "") {
					if (addr == "") {
						System.out.println("근무 형태만 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_WORKING_KIND", wk);
						list = projectSer.getW(map);
					}
				}
			}
		}

		// 1.개발 카테고리만 선택되었을 때
		if (wk == "") {
			System.out.println("1");
			if (mkd != null) {
				System.out.println("2");
				if (mkds == "") {
					System.out.println("3");
					if (addr == "") {
						System.out.println("개발만 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_MIDDLE_KATEGORY", mkd);
						list = projectSer.getMKD(map);
					}
				}
			}
		}

		// 1.디자인 카테고리만 선택되었을 때
		if (wk == "") {
			System.out.println("1");
			if (mkd == "") {
				System.out.println("2");
				if (mkds != null) {
					System.out.println("3");
					if (addr == "") {
						System.out.println("디자인만 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_MIDDLE_KATEGORY", mkds);
						list = projectSer.getMKDS(map);
					}
				}
			}
		}

		// 1.지역만 선택되었을 때
		if (wk == "") {
			System.out.println("1");
			if (mkd == "") {
				System.out.println("2");
				if (mkds == "") {
					System.out.println("3");
					if (addr != null) {
						System.out.println("지역만 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_ADDRESS", addr);
						list = projectSer.getAddr(map);
					}
				}
			}
		}

		// 2.근무/개발
		if (wk != null) {
			System.out.println("1");
			if (mkd != null) {
				System.out.println("2");
				if (mkds == "") {
					System.out.println("3");
					if (addr == "") {
						System.out.println("근무/개발만 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_WORKING_KIND", wk);
						map.put("PROJECT_MIDDLE_KATEGORY", mkd);
						list = projectSer.getWMKD(map);
					}
				}
			}
		}

		// 2.근무/디자인
		if (wk != null) {
			System.out.println("1");
			if (mkd == "") {
				System.out.println("2");
				if (mkds != null) {
					System.out.println("3");
					if (addr == "") {
						System.out.println("근무/디자인만 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_WORKING_KIND", wk);
						map.put("PROJECT_MIDDLE_KATEGORY", mkds);
						list = projectSer.getWMKDS(map);
					}
				}
			}
		}

		// 2.근무/지역
		if (wk != null) {
			System.out.println("1");
			if (mkd == "") {
				System.out.println("2");
				if (mkds == "") {
					System.out.println("3");
					if (addr != null) {
						System.out.println("근무/지역만 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_WORKING_KIND", wk);
						map.put("PROJECT_ADDRESS", addr);
						list = projectSer.getWADDR(map);
					}
				}
			}
		}

		// 2.개발/디자인
		if (wk == "") {
			System.out.println("1");
			if (mkd != null) {
				System.out.println("2");
				if (mkds != null) {
					System.out.println("3");
					if (addr == "") {
						System.out.println("개발/디자인만 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_MIDDLE_KATEGORY", mkd);
						map.put("PROJECT_MIDDLE", mkds);
						list = projectSer.getDMKD(map);
					}
				}
			}
		}

		// 2.개발/지역
		if (wk == "") {
			System.out.println("1");
			if (mkd != null) {
				System.out.println("2");
				if (mkds == "") {
					System.out.println("3");
					if (addr != null) {
						System.out.println("개발/지역만 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_MIDDLE_KATEGORY", mkd);
						map.put("PROJECT_ADDRESS", addr);
						list = projectSer.getMADDR(map);
					}
				}
			}
		}

		// 2.디자인/지역
		if (wk == "") {
			System.out.println("1");
			if (mkd == "") {
				System.out.println("2");
				if (mkds != null) {
					System.out.println("3");
					if (addr != null) {
						System.out.println("디자인/지역만 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_MIDDLE_KATEGORY", mkds);
						map.put("PROJECT_ADDRESS", addr);
						list = projectSer.getMKADDR(map);
					}
				}
			}
		}

		// 3.근무/개발/디자인
		if (wk != null) {
			System.out.println("1");
			if (mkd != null) {
				System.out.println("2");
				if (mkds != null) {
					System.out.println("3");
					if (addr == "") {
						System.out.println("근무/개발/디자인 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_WORKING_KIND", wk);
						map.put("PROJECT_MIDDLE_KATEGORY", mkd);
						map.put("PROJECT_MIDDLE", mkds);
						list = projectSer.getWDMKD(map);
					}
				}
			}
		}

		// 3.근무/개발/지역
		if (wk != null) {
			System.out.println("1");
			if (mkd != null) {
				System.out.println("2");
				if (mkds == "") {
					System.out.println("3");
					if (addr != null) {
						System.out.println("근무/개발/지역 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_WORKING_KIND", wk);
						map.put("PROJECT_MIDDLE_KATEGORY", mkd);
						map.put("PROJECT_ADDRESS", addr);
						list = projectSer.getWMKDADDR(map);
					}
				}
			}
		}

		// 3.근무/디자인/지역
		if (wk != null) {
			System.out.println("1");
			if (mkd == "") {
				System.out.println("2");
				if (mkds != null) {
					System.out.println("3");
					if (addr != null) {
						System.out.println("근무/디자인/지역 선택");
						map.put("start", start);
						map.put("end", end);
						map.put("PROJECT_WORKING_KIND", wk);
						map.put("PROJECT_MIDDLE_KATEGORY", mkds);
						map.put("PROJECT_ADDRESS", addr);
						list = projectSer.getWDMKDADDR(map);
					}
				}
			}
		}

		// 4.근무/디자인/지역
		/*
		 * if (wk != null && mkd != null && mkds != null && addr != null) { if (wk
		 * !=null) { System.out.println("1"); if(mkd!=null) { System.out.println("2");
		 * if(mkds!=null) { System.out.println("3"); if(addr!=null) {
		 * System.out.println("근무/개발/디자인/지역 선택"); map.put("start", start);
		 * map.put("end", end); map.put("PROJECT_WORKING_KIND", wk);
		 * map.put("PROJECT_MIDDLE_KATEGORY", mkd); map.put("PROJECT_MIDDLE", mkds);
		 * map.put("PROJECT_ADDRESS", addr); list = projectSer.getAll(map); } } } } }
		 */

		System.out.println("리스트값 " + list.get(0));

		PrintWriter out;
		try {
			out = response.getWriter();

			if (list == null) {
				out.println("<script>alert('검색 결과 없음');</script>");
				out.println("<script>locatiof.href=history.go(-1);</script>");
				out.flush();
			} else {
				System.out.println(list.get(0));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// 프로젝트 게시글 조회
	@RequestMapping(value = "projectView.do")
	public ModelAndView view(@RequestParam int PROJECT_IDX, HttpSession session) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("projectView");

		mav.addObject("dto", projectSer.projectRead(PROJECT_IDX));
		mav = setTop(mav);
		return mav;
	}

	// 프로젝트 등록 처리
	@RequestMapping(value = "projectRegOk.do", method = RequestMethod.POST)
	public String projectWrite(Locale local, ProjectDTO dto, HttpServletRequest request, HttpSession session)
			throws Exception {

		System.out.println("등록 테스트");

		String USER_ID = (String) session.getAttribute("userId");

		String ImagePath = projectSer.getImage(USER_ID);

		int budget = Integer.parseInt(request.getParameter("PROJECT_BUDGET"));
		int cBudget = Integer.parseInt(request.getParameter("PROOJECT_BUDGET_COORDINATION"));
		String start_date = request.getParameter("PROJECT_START_DATE");
		String end_date = request.getParameter("PROJECT_END_DATE");

		java.sql.Date SD = java.sql.Date.valueOf(start_date);
		java.sql.Date ED = java.sql.Date.valueOf(end_date);

		dto.setPROJECT_BUDGET(budget);
		dto.setPROJECT_BUDGET_COORDINATION(cBudget);
		dto.setPROJECT_START_DATE(SD);
		dto.setPROJECT_END_DATE(ED);
		dto.setPROJECT_IMAGE_PATH(ImagePath);

		System.out.println("아이디 : " + USER_ID);
		System.out.println("이미지 경로 : " + dto.getPROJECT_IMAGE_PATH());
		System.out.println("대분류 " + dto.getPROJECT_MAIN_KATEGORY());
		System.out.println("중분류 " + dto.getPROJECT_MIDDLE_KATEGORY());
		System.out.println("제목 : " + dto.getPROJECT_SUBJECT());
		System.out.println("내용 : " + dto.getPROJECT_CONTENT());
		System.out.println("근무 형태 : " + dto.getPROJECT_WORKING_KIND());
		System.out.println("근무 위치 : " + dto.getPROJECT_ADDRESS());
		System.out.println("예산 : " + dto.getPROJECT_BUDGET());
		System.out.println("예산 조율 여부 " + dto.getPROJECT_BUDGET_COORDINATION());
		System.out.println("시작일 : " + dto.getPROJECT_START_DATE());
		System.out.println("마감일 : " + dto.getPROJECT_END_DATE());

		projectSer.projectWrite(dto);

		System.out.println("등록완료");
		/*
		 * ModelAndView mav = new ModelAndView(); mav.setViewName("projectSearch");
		 */
		return "redirect:projectSearch.do";
	}

	// 프로젝트 신청 처리 ( 프리랜서가 프로젝트 신청 )
	@RequestMapping(value = "projectJoinOk.do")
	public String projectJoin(Locale local, ProjectJoinDTO dto, HttpServletRequest request) throws Exception {

		System.out.println("조인 테스트");
		int idx = Integer.parseInt(request.getParameter("PROJECT_IDX"));
		dto.setFREELANCER_ID("test");
		dto.setPROJECT_STATUS(3);
		System.out.println("프로젝트 번호 : " + idx);
		System.out.println("프로젝트 제목 : " + dto.getPROJECT_SUBJECT());
		System.out.println("클라이언트 아이디 : " + dto.getCLIENT_ID());
		System.out.println("프리랜서 아이디 : " + dto.getFREELANCER_ID());
		System.out.println("프로젝트 상태 : " + dto.getPROJECT_STATUS());

		projectSer.projectJoin(dto);

		System.out.println("등록완료");
		/*
		 * ModelAndView mav = new ModelAndView(); mav.setViewName("projectSearch");
		 */
		// return "redirect:projectSearch.do";
		return "redirect:projectSearch.do";
	}

	// 상단 배너
	ModelAndView setTop(ModelAndView mav) {
		int regProject = 0;
		int regFree = 0;
		int edPrice = 0;
		int allUser = 0;
		int bbsCount = 0;
		int outCount = 0;

		outCount = userSer.outCount();
		bbsCount = projectSer.bbsCount();
		regProject = etcSer.ProjectCount() + bbsCount;
		regFree = etcSer.RegFreeCount();
		edPrice = etcSer.EdPrice();
		allUser = etcSer.AllUser() - outCount;
		System.out.println("탈퇴한 회원수: " + outCount);

		mav.addObject("regProject", regProject);
		mav.addObject("regFree", regFree);
		mav.addObject("edPrice", edPrice);
		mav.addObject("allUser", allUser);
		return mav;
	}

}
