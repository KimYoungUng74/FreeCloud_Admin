package com.spring.freecloud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
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
		/*
		 * List<ProjectDTO> list = projectSer.selectProject(dto); for(int i=0;
		 * i<list.size(); i++) { System.out.println(i + "번째 값 : " + list.get(i)); }
		 * System.out.println("값이 없다는거임?"); System.out.println(list + " 값좀줘요");
		 */
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

			@RequestParam(value = "addr", required = false) String addr,
			HttpServletResponse response) {

		
		
		
		System.out.println("현재 페이지 : " + nowPage);
		System.out.println("카운트 페이지 : " + cntPerPage);
		System.out.println("근무 형태 : " + wk);
		System.out.println("메인 카테고리 : " + mkd);
		System.out.println("미들 카테고리 : " + mkds);
		System.out.println("지역 : " + addr);

		if(wk == "undefined") {
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
			if(mkd=="") {
				if(mkds=="") {
					if(addr=="") {
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
			if(mkd!=null) {
				System.out.println("2");
				if(mkds=="") {
					System.out.println("3");
					if(addr=="") {
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
			if(mkd=="") {
				System.out.println("2");
				if(mkds!=null) {
					System.out.println("3");
					if(addr=="") {
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
			if(mkd=="") {
				System.out.println("2");
				if(mkds=="") {
					System.out.println("3");
					if(addr!=null) {
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
			if(mkd!=null) {
				System.out.println("2");
				if(mkds=="") {
					System.out.println("3");
					if(addr=="") {
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
			if(mkd=="") {
				System.out.println("2");
				if(mkds!=null) {
					System.out.println("3");
					if(addr=="") {
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
			if(mkd=="") {
				System.out.println("2");
				if(mkds=="") {
					System.out.println("3");
					if(addr!=null) {
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
			if(mkd!=null) {
				System.out.println("2");
				if(mkds!=null) {
					System.out.println("3");
					if(addr=="") {
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
		if (wk =="") {
			System.out.println("1");
			if(mkd!=null) {
				System.out.println("2");
				if(mkds=="") {
					System.out.println("3");
					if(addr!=null) {
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
		if (wk =="") {
			System.out.println("1");
			if(mkd=="") {
				System.out.println("2");
				if(mkds!=null) {
					System.out.println("3");
					if(addr!=null) {
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
		if (wk !=null) {
			System.out.println("1");
			if(mkd!=null) {
				System.out.println("2");
				if(mkds!=null) {
					System.out.println("3");
					if(addr=="") {
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
		if (wk !=null) {
			System.out.println("1");
			if(mkd!=null) {
				System.out.println("2");
				if(mkds=="") {
					System.out.println("3");
					if(addr!=null) {
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
		if (wk !=null) {
			System.out.println("1");
			if(mkd=="") {
				System.out.println("2");
				if(mkds!=null) {
					System.out.println("3");
					if(addr!=null) {
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
			
			if(list == null) {
				out.println("<script>alert('검색 결과 없음');</script>");
				out.println("<script>locatiof.href=history.go(-1);</script>");
				out.flush();
			}else {
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
