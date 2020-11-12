package com.spring.freecloud.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.freecloud.dto.MyfreelancerDTO;
import com.spring.freecloud.dto.ProjectDTO;
import com.spring.freecloud.dto.ProjectViewDTO;
import com.spring.freecloud.dto.UserDTO;
import com.spring.freecloud.service.EtcService;
import com.spring.freecloud.service.UserService;
import com.spring.freecloud.util.PagingDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userSer;
	@Autowired
	EtcService etcSer;
	// xml에 설정된 리소스 참조
	// bean의 id가 uploadPath인 태그를 참조 파일업로드
	@Autowired
	@Resource(name = "uploadPath")
	String uploadPath;

	// 회원가입 화면
	@RequestMapping(value = "signup.do")
	public ModelAndView signup(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();
		mav = setTop(mav);
		mav.setViewName("signup");
		return mav;
	}
	// 회원 가입 처리
	@RequestMapping(value = "signupOk.do", method = RequestMethod.POST)
	public ModelAndView signupOk(Locale locale, UserDTO dto) {
		System.out.println("userName : " + dto.getUSER_NAME());
		if (1 == userSer.signupUser(dto)) {
			System.out.println("회원가입 되었음");
		} else {
			System.out.println("회원가입 실패");
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav = sethome(mav);
		return mav;
	}

	// 아이디 중복 체크
	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	public @ResponseBody String AjaxView(@RequestParam("id") String id) throws Exception{
		System.out.println("넘어가세요");
		String str = "";
		boolean idcheck = userSer.checkId(id);
		if (idcheck) { // 이미 존재하는 계정
			str = "NO";
		} else { // 사용 가능한 계정
			str = "YES";
		}
		return str;
	}

	// 이메일 중복 체크
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	public @ResponseBody String AjaxView2(@RequestParam("email") String email) {
		String str = "";
		boolean emailcheck = userSer.checkEmail(email);
		if (emailcheck) { // 이미 존재하는 계정
			str = "NO";
		} else { // 사용 가능한 계정
			str = "YES";
		}
		return str;
	}

	// 로그인 화면
	@RequestMapping(value = "login.do")
	public ModelAndView login(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();
		mav = setTop(mav);
		mav.setViewName("login");
		return mav;
	}

	// 로그인 처리
	@RequestMapping(value = "loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute UserDTO dto, HttpSession sessison, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean result = userSer.loginCheck(dto, sessison);
		ModelAndView mav = new ModelAndView();

		if (result) { // 로그인 성공
			mav.setViewName("home");
			mav.addObject("msg", "success");
			System.out.println("로그인 성공");
			mav = sethome(mav);
		} else { // 로그인 실패
			// login.jsp로 이동
			mav.setViewName("login");
			mav.addObject("msg", "failure");
			System.out.println("로그인 실패");
		}
		return mav;
	}

	// 로그아웃
	@RequestMapping(value = "logout.do")
	public ModelAndView logOut(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		userSer.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("msg", "logout");
		mav = sethome(mav);
		return mav;
	}

	// 아이디 찾기
	@RequestMapping(value = "/seekId", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String seekid(@RequestParam("name") String name, @RequestParam("email") String email) {
		System.out.println("seekid에 접근함");

		String str = "";
		String idcheck = userSer.seekId(name, email);
		if (idcheck != "") { // 정보가 일치할 경우
			str = "찾으신 아이디는 \'" + idcheck + "\'입니다.";
		} else { // 가입된 회원이 아닐경우
			str = "가입된 정보가 없습니다 입력한 정보를 확인하세요";
		}

		return str;
	}

	// 아이디 찾기
	@RequestMapping(value = "/seekPw", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String seekpw(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("email") String email) {
		System.out.println("seekpw에 접근함");
		String str = "";
		String pwcheck = userSer.seekPw(id, name, email);
		if (pwcheck == "dbError") { // 정보가 일치하지 않을 경우
			str = "DB오류가 발생했습니다 다시 시도해주세요";
		} else if (pwcheck == "notFound") { // 가입된 회원이 아닐경우
			str = "가입된 정보가 없습니다 입력한 정보를 확인하세요";
		} else {
			str = "임시비밀번호 : \'" + pwcheck + " \'로그인시 변경해주세요";
		}

		return str;
	}

	// 회원정보 수정 페이지
	@RequestMapping(value = "mypage.do", produces = "application/text; charset=utf8")
	public ModelAndView mypage(Locale locale, HttpSession sessison) {
		System.out.println("mypage에 접근함");
		UserDTO dto = new UserDTO();
		dto = userSer.myInfo(sessison.getAttribute("userId").toString());
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("mypage");
		mav = setTop(mav);
		return mav;
	}

	// 나의 프로젝트
	@RequestMapping(value = "myProject.do", produces = "application/text; charset=utf8")
	public ModelAndView myProject(Locale locale, HttpSession sessison) {
		System.out.println("myProject에 접근함");
		
		List<ProjectDTO> ingList = null; // 진행중인 프로젝트
		List<ProjectDTO> edList = null; // 완료한 프로젝트
		String userId =sessison.getAttribute("userId").toString();	// 유저 아이디
		String myprofile = userSer.myProfile(userId); // 프로필 사진 가져오기
		ingList = userSer.ingMyProject(userId); // 진행중인 프로젝트 - 의뢰
		edList = userSer.edMyProject(userId);  // 완료한 프로젝트 - 의뢰
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ingList", ingList);
		mav.addObject("edList", edList);
		mav.addObject("myprofile", myprofile);
		mav.setViewName("myProject");
		mav = setTop(mav);
		return mav;
	}

	// 프로젝트 지원 현황
	@RequestMapping(value = "projectRequest.do", produces = "application/text; charset=utf8")
	public ModelAndView projectApply(Locale locale, HttpSession sessison) {
		System.out.println("projectRequest에 접근함");

		List<ProjectDTO> ingList = null; // 진행중인 프로젝트
		List<ProjectDTO> requestedList = null; // 지원 요청 된 프로젝트
		List<ProjectDTO> requestList = null; // 지원한 프로젝트
		List<ProjectDTO> edList = null; // 완료한 프로젝트
		
		String userId =sessison.getAttribute("userId").toString();	// 유저 아이디
		String myprofile = userSer.myProfile(userId); // 프로필 사진 가져오기
		ingList = userSer.rIngMyProject(userId); // 진행중인 프로젝트 - 지원
		requestedList = userSer.requestedProject(userId);  // 완료한 프로젝트 - 의뢰
		requestList = userSer.requestProject(userId); // 진행중인 프로젝트 - 의뢰
		edList = userSer.rEdMyProject(userId);  // 완료한 프로젝트 - 지원
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ingList", ingList);
		mav.addObject("requestedList", requestedList);
		mav.addObject("requestList", requestList);
		mav.addObject("edList", edList);
		mav.addObject("myprofile", myprofile);
		mav.setViewName("projectRequest");
		mav = setTop(mav);
		return mav;
	}

	// 나의 게시판
	@RequestMapping(value = "projectState.do", produces = "application/text; charset=utf8")
	public ModelAndView projectState(Locale locale, HttpSession sessison) {
		System.out.println("projectState에 접근함");
		String myprofile = userSer.myProfile(sessison.getAttribute("userId").toString()); // 프로필 사진 가져오기
		ModelAndView mav = new ModelAndView();
		mav.addObject("myprofile", myprofile);
		mav.setViewName("projectState");
		mav = setTop(mav);
		return mav;
	}

	// 아이디 찾기
	@RequestMapping(value = "/checkMyPass.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String checkMyPass(@RequestParam("pw") String pw, HttpSession sessison) {
		System.out.println("checkMyPass에 접근함");
		String str = "";
		str = userSer.checkPw(sessison.getAttribute("userId").toString(), pw);
		System.out.println(str);
		if (str == null) { // 비밀번호 일치함
			str = "Not_Match";
		} else { // 비밀번호 일치 하지 않음
			str = "Same";
		}

		return str;
	}

	// 회원정보 수정
	@RequestMapping(value = "myInfoModify.do", method = RequestMethod.POST)
	public ModelAndView myInfoModify(Locale locale, UserDTO dto) {
		if(dto.getUSER_PW().equals("")) {
			if (1 == userSer.userModify(dto)) {
				System.out.println("회원정보 수정 되었음");
			} else {
				System.out.println("회원정보 수정 실패");
			}

		} else {
			if (1 == userSer.userModify(dto)) {
				System.out.println("회원정보 수정 되었음");
			} else {
				System.out.println("회원정보 수정 실패");
			}
		}
		ModelAndView mav = new ModelAndView();
		mav = sethome(mav);
		return mav;
	}

	// 업로드 흐름 : 업로드 버튼클릭 => 임시디렉토리에 업로드=> 지정된 디렉토리에 저장 => 파일정보가 file에 저장
	@RequestMapping(value = "/upload/uploadForm", method = RequestMethod.GET)
	public void uplodaForm() {
		// upload/uploadForm.jsp(업로드 페이지)로 포워딩
	}

	// 외부저장소에서 이미지 불러오기위해
	// 톰켓 sever.xml에 <Context path="/banzzackimg" reloadable="true"
	// docBase="D:\freecloud"/> 추가

	// 파일 업로드
	@RequestMapping(value = "/fileUpload.do", method = RequestMethod.POST)
	public ModelAndView uplodaForm(MultipartFile file, ModelAndView mav) throws Exception {
		System.out.println("fileUpload에 접근함");
		logger.info("파일이름 :" + file.getOriginalFilename());
		logger.info("파일크기 : " + file.getSize());
		logger.info("컨텐트 타입 : " + file.getContentType());

		String savedName = file.getOriginalFilename();

		File target = new File(uploadPath, savedName);

		// 임시디렉토리에 저장된 업로드된 파일을 지정된 디렉토리로 복사
		// FileCopyUtils.copy(바이트배열, 파일객체)
		FileCopyUtils.copy(file.getBytes(), target);

		mav.setViewName("mypage");
		mav.addObject("savedName", savedName);

		return mav; // mypage.jsp(결과화면)로 포워딩
	}

	// 파일 업로드 Ajax
	@RequestMapping(value = "/fileUploadAjax.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String uplodaFormAjax(MultipartFile file, String originalProfile, HttpSession sessison,
			ModelAndView mav) throws IOException, Exception {

		System.out.println("원래 파일이름 : " + originalProfile);
		String dirname = File.separator + "profile";
		System.out.println(file);
		System.out.println("fileUploadAjax에 접근함");

		String savedName = file.getOriginalFilename();
		logger.info("파일이름 :" + file.getOriginalFilename());
		logger.info("파일크기 : " + file.getSize());
		logger.info("컨텐트 타입 : " + file.getContentType());

		System.out.println("파일이름 :" + file.getOriginalFilename());

		// 랜덤생성+파일이름 저장
		// 파일명 랜덤생성 메서드호출
		savedName = uploadFile(savedName, file.getBytes(), dirname);

		// 프로필 DB변경
		userSer.changeProfile(savedName, sessison.getAttribute("userId").toString());

		if (originalProfile != "basic.png")
			new File(uploadPath + File.separator + "profile" + File.separator + originalProfile).delete();

		return savedName;

	}

	// 포트폴리오 업로드 Ajax
	@RequestMapping(value = "/	myPortfolioUploadAjax.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String myPortfolioUploadAjax(MultipartFile portfolio, HttpSession sessison, ModelAndView mav)
			throws IOException, Exception {

		String dirname = File.separator + "portfolio";
		System.out.println(portfolio);
		System.out.println("fileUploadAjax에 접근함");

		String originalName = portfolio.getOriginalFilename();

		logger.info("파일이름 :" + portfolio.getOriginalFilename());
		logger.info("파일크기 : " + portfolio.getSize());
		logger.info("컨텐트 타입 : " + portfolio.getContentType());

		System.out.println("파일이름 :" + portfolio.getOriginalFilename());

		// 랜덤생성+파일이름 저장
		// 파일명 랜덤생성 메서드호출
		String savedName = uploadFile(originalName, portfolio.getBytes(), dirname);
		userSer.addPortfolio(originalName, savedName, sessison.getAttribute("userId").toString());
		
		return savedName;

	}

	// 포트폴리오 파일 삭제
	@RequestMapping(value = "myPortfolioDeleteAjax.do", method = RequestMethod.POST)
	public @ResponseBody String deleteFile(String fileName, HttpSession sessison) {

		userSer.deletePortfolio(sessison.getAttribute("userId").toString());
		// 원본 파일 삭제
		System.out.println(uploadPath + File.separator + "portfolio" + fileName.replace('/', File.separatorChar));
		new File(uploadPath + File.separator + "portfolio" + File.separator + fileName.replace('/', File.separatorChar))
				.delete();

		return "deleted";
	}

	// 파일명 랜덤생성 메서드
	private String uploadFile(String originalName, byte[] fileData, String dirName) throws Exception {

		// 폴더 생성
		makeDir(uploadPath, dirName);
		// uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
		UUID uuid = UUID.randomUUID();
		// 랜덤생성+파일이름 저장
		String savedName = uuid.toString() + "_" + originalName;
		File target = new File(uploadPath + dirName, savedName);
		// 임시디렉토리에 저장된 업로드된 파일을 지정된 디렉토리로 복사
		// FileCopyUtils.copy(바이트배열, 파일객체)
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
	 // 디렉토리 생성
    private static void makeDir(String uploadPath, String... paths) {
        // 디렉토리가 존재하면
        if (new File(paths[paths.length - 1]).exists()){
            return;
        }
        // 디렉토리가 존재하지 않으면
        for (String path : paths) {
            // 
            File dirPath = new File(uploadPath + path);
            // 디렉토리가 존재하지 않으면
            if (!dirPath.exists()) {
                dirPath.mkdir(); //디렉토리 생성
            }
        }
    }  
    
    // 프리랜서 목록 리스트 조회 화면
  	@RequestMapping(value = "freelancerSearch.do")
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
		int total = userSer.countBoard();

		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";

		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}

		dto = new PagingDTO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

		List<ProjectDTO> list = userSer.selectProject(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("freelancerSearch");
		mav.addObject("paging", dto);
		mav.addObject("viewAll", list);
		mav = setTop(mav);
		return mav;
  	}
  	
 // 프리랜서 상세 페이지
 	@RequestMapping(value = "freelancerPage.do", produces = "application/text; charset=utf8")
 	public ModelAndView freelancerPage(Locale locale, @RequestParam("userId") String userId, HttpSession sessison) {
 		System.out.println("freelancerPage에 접근함");
 		
 		List<ProjectDTO> ingList = null; // 진행중인 프로젝트
 		
 		ingList = userSer.ingMyProject(sessison.getAttribute("userId").toString()); // 진행중인 프로젝트 - 의뢰
 		UserDTO dto = new UserDTO();
 		dto = userSer.myInfo(userId);
 		ModelAndView mav = new ModelAndView();
 		mav.addObject("dto", dto);
 		mav.addObject("ingList", ingList);
 		mav.setViewName("freelancerPage");
 		mav = setTop(mav);
 		return mav;
 	}
 	 // 프로젝트 지원요청
 	@RequestMapping(value = "RequestProject.do", produces = "application/text; charset=utf8")
 	public ModelAndView RequestProject(Locale locale, @RequestParam("PROJECT_SUBJECT") String PROJECT_SUBJECT, @RequestParam("PROJECT_IDX") String PROJECT_IDX, @RequestParam("userId") String userId, HttpSession sessison) {
 		System.out.println("RequestProject에 접근함");
 		 		
 		etcSer.RequestProject(PROJECT_IDX, PROJECT_SUBJECT, userId, sessison.getAttribute("userId").toString());
 		UserDTO dto = new UserDTO();
 		dto = userSer.myInfo(userId);
 		ModelAndView mav = new ModelAndView();
 		mav.addObject("dto", dto);
 		mav.addObject("msg", "ok");
 		mav.setViewName("freelancerPage");
 		mav = setTop(mav);
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

		mav.setViewName("home");
		return mav;
	}
	
}
