<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Home One || Witter Multipage Responsive Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value='resources/writer/img/favicon.ico'/>">
<!-- Place favicon.ico in the root directory -->
<!-- Google Fonts -->
<link
	href='https://fonts.googleapis.com/css?family=Poppins:400,700,600,500,300'
	rel='stylesheet' type='text/css'>

<!-- all css here -->
<!-- bootstrap v3.3.6 css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/css/bootstrap.min.css'/>">
<!-- animate css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/css/animate.css'/>">
<!-- jquery-ui.min css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/css/jquery-ui.min.css'/>">
<!-- meanmenu css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/css/meanmenu.min.css'/>">
<!-- Font-Awesome css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/css/font-awesome.min.css'/>">
<!-- pe-icon-7-stroke css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/css/pe-icon-7-stroke.css'/>">
<!-- Flaticon css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/css/flaticon.css'/>">
<!-- venobox css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/venobox/venobox.css'/>"
	type="text/css" media="screen" />
<!-- nivo slider css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/lib/css/nivo-slider.css'/>"
	type="text/css" />
<link rel="stylesheet"
	href="<c:url value='resources/writer/lib/css/preview.css'/>"
	type="text/css" media="screen" />
<!-- owl.carousel css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/css/owl.carousel.css'/>">
<!-- style css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/style.css'/>">
<!-- responsive css -->
<link rel="stylesheet"
	href="<c:url value='resources/writer/css/responsive.css'/>">
<!-- modernizr css -->
<script
	src="<c:url value='resources/writer/js/vendor/modernizr-2.8.3.min.js'/>"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

		// 비밀번호 확인				
		$(function() {
			//비밀번호 확인
			$('#restraint').click(function() {
				var check ="";
				check = prompt("제재사유를 적으세요.");
				
				if(check != "") {
					$('#why_restraint').val(check);
					$('#restraint_form').submit();
				}
				
			})

		});

		
</script>
<script type="text/javascript">

</script>

</head>
<body>
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

	<!-- Add your site or application content here -->
	<!--Header Area Start-->
	<div class="header-area">
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<div class="header-logo">
						<a href="home.do"> <img
							src="<c:url value='resources/writer/img/freeCloud/logo.png'/>"
							alt="">
						</a>
					</div>
				</div>
				<div class="col-md-7">
					<div class="mainmenu text-center">
						<nav id="dropdown">
							<ul id="nav">
								<li><h4>
										<a href="userManage.do">회원 관리</a>
									</h4>
									<ul class="sub-menu">
										<li><a href="userManage.do">회원정보 관리</a></li>
										<li><a href="inquireManage.do">문의내역 관리</a></li>
										<li><a href="restraintManage.do">제재내역 관리</a></li>
									</ul></li>
								<li><h4>
										<a href="projectSearch.do">수익 관리</a>
									</h4>
									<ul class="sub-menu">
										<li><a href="projectReg.do">중개수수료 관리</a></li>
										<li><a href="projectSearch.do">프리미엄등급 구독료 관리</a></li>
									</ul></li>
								<li><h4>
										<a href="boardList.do">게시판 관리</a>
									</h4>
								<li><h4>
										<a href="about.do">통계 안내</a>
									</h4>
									<ul class="sub-menu">
										<li><a href="useProject.do">회원 수 통계</a></li>
										<li><a href="useFreelancer.do">프로젝트 통계</a></li>
										<li><a href="useProjectSerch.do">수익 통계</a></li>
									</ul></li>
							</ul>
						</nav>
					</div>
				</div>
				<div class="col-md-3">
					<br> <input type="text" placeholder="검색어를 입력하세요">
					<button name="submitcreate" id="submitcreate" type="submit"
						class="btn-default">
						<span> <i class="fa fa-search left"></i>

						</span>
					</button>

				</div>
			</div>
		</div>
	</div>
	<!--Header Area End-->
	<!-- Mobile Menu Start -->
	<div class="mobile-menu-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div class="mobile-menu">
						<nav id="dropdown">
							<ul id="nav">
								<li><h4>
										<a href="projectSearch.do">프로젝트</a>
									</h4>
									<ul class="sub-menu">
										<li><a href="projectReg.do">프로젝트 등록</a></li>
										<li><a href="projectSearch.do">프로젝트 찾기</a></li>
									</ul></li>
								<li><h4>
										<a href="freelancerSearch.do">프리랜서 찾기</a>
									</h4></li>
								<li><h4>
										<a href="boardList.do">정보구름</a>
									</h4>
									<ul class="sub-menu">
										<li><a href="boardReg.do">게시글 등록</a></li>
										<li><a href="boardList.do">게시글 목록</a></li>
									</ul></li>
								<li><h4>
										<a href="about.do">서비스 안내</a>
									</h4>
									<ul class="sub-menu">
										<li><a href="useProject.do">프로젝트 이용방법</a></li>
										<li><a href="useFreelancer.do">프리랜서 이용방법</a></li>
										<li><a href="useProjectSerch.do">프로젝트 찾기</a></li>
									</ul></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Mobile Menu End -->
	<!-- Counter Area Start -->
	<div class="counter-area section-padding text-center"
		style="background-color: #a3d4f7">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="single-counter wow" data-wow-duration="1.5s"
						data-wow-delay=".2s">
						<div class="counter-info">
							<span class="fcount"> <span class="counter">${regProject}</span>
							</span>
							<h3>프로젝트 수</h3>
						</div>
					</div>
				</div>
				<div class="col-md-2 col-sm-3 col-xs-6">
					<div class="single-counter wow" data-wow-duration="1.5s"
						data-wow-delay=".2s">
						<div class="counter-info">
							<span class="fcount"> <span class="counter">${regFree}</span>명
							</span>
							<h3>프리랜서 수</h3>
						</div>
					</div>
				</div>
				<div class="col-md-5 col-sm-3 col-xs-6">
					<div class="single-counter wow" data-wow-duration="1.5s"
						data-wow-delay=".2s">
						<div class="counter-info">
							<span class="fcount"> <span class="counter">${edPrice}</span>원
							</span>
							<h3>완료 금액</h3>
						</div>
					</div>
				</div>
				<div class="col-md-2 col-sm-3 col-xs-6">
					<div class="single-counter wow" data-wow-duration="1.5s"
						data-wow-delay=".2s">
						<div class="counter-info">
							<span class="fcount"> <span class="counter">${allUser}</span>명
							</span>
							<h3>회원 수</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Counter Area End -->
	<!-- Shop Area Start -->
	<div class="shopping-area section-padding">
		<div class="container">
			<div class="row">
			<form id="restraint_form" action="restraint.do" method="post">
				<input name="USER_ID" type="hidden" value="${dto.USER_ID}">
				<input id="why_restraint" name="WHY_RESTRAINT" type="hidden" >
			</form>
				<form action="myInfoModify.do" method="post" id="infoForm">
					<div class="col-md-3 col-sm-3 col-xs-12" style="font-size: 20px">
						<div class="row shop-widget">
							<div class="thumbnail">
								<div class="centered" id="profile">
									<img alt=""
										src="<c:url value='http://localhost:8181/img/profile/${dto.FREELANCER_IMAGE_PATH}'/>">
									<input id="originalProfile" type="hidden" value="basic.png">
								</div>
							</div>
							
							<div class="basic_btn" id="restraint" style="width: 100%">
								<a>제재 하기</a></div>
							<br>

						</div>
					</div>
					<div class="col-md-9 col-sm-9 col-xs-12" style="font-size: 20px;">
						<div
							style="width: 100%; height: 100%; border: 1px solid #D3D3D3; padding: 10px;">
							<div class="row">
								<div class="col-md-6">
									<p>
										<label> ID : </label> <input name="USER_ID"
											value="${dto.USER_ID}" readonly="readonly">
									<p>
									<p>
										<label> 지역 : </label> <select name="USER_ADDRESS">
											<option value="${dto.USER_ADDRESS}" hidden selected>${dto.USER_ADDRESS}</option>
											<option value="서울">서울</option>
											<option value="경기도">경기도</option>
											<option value="강원도">강원도</option>
										</select>
									<p>
								</div>
								<div class="col-md-6">
									<p>
										<label> 비밀번호 : </label> <input type="password"
											disabled="disabled" name="USER_PW" value="">
									<p>
									<p>
										<label> 이름 : </label> <input type="text" name="USER_NAME"
											readonly="readonly" value="${dto.USER_NAME}">
									<p>
								</div>
								<div class="col-md-6">
									<p>
										<label> 이메일 : </label> <input type="email" name="USER_EMAIL"
											readonly="readonly" value="${dto.USER_EMAIL}"
											placeholder="freeCloud@free.com">
									</p>
								</div>
								<div class="col-md-6">
									<label> 최종학력 : </label> <select name="USER_EDU">
										<option value="${dto.USER_EDU}" selected="selected">${dto.USER_EDU}</option>
									</select>
								</div>

								<div class="col-md-12">
									<label> 전화번호 </label>
								</div>
								<div class="col-md-4">
									<input type="text" name="USER_PHONE1" style="width: 90%;"
										readonly="readonly" value="${dto.USER_PHONE1}">
									&nbsp;&nbsp;-
								</div>
								<div class="col-md-4">
									<input type="text" name="USER_PHONE2" style="width: 90%;"
										readonly="readonly" value="${dto.USER_PHONE2}">
									&nbsp;&nbsp;-
								</div>
								<div class="col-md-4">
									<input type="text" name="USER_PHONE3" style="width: 100%;"
										readonly="readonly" value="${dto.USER_PHONE3}">
								</div>

								<div class="col-md-12">
									<br> <label> 자기소개 </label>

									<textarea rows="4" name="FREELANCER_ABOUT_ME"
										readonly="readonly" style="width: 100%; resize: none;">${dto.FREELANCER_ABOUT_ME}</textarea>
								</div>
								<div class="col-md-8">
									<p>
										<label> 전문분야 : </label> <select id="CATAGORY1"
											name="FREELANCER_MAIN_KATEGORY">
											<option value="${dto.FREELANCER_MAIN_KATEGORY}"
												selected="selected">${dto.FREELANCER_MAIN_KATEGORY}</option>

										</select> &nbsp; <select id="CATAGORY2"
											name="FREELANCER_MIDDEL_KATEGORY">
											<option value="${dto.FREELANCER_MIDDEL_KATEGORY}"
												selected="selected">${dto.FREELANCER_MIDDEL_KATEGORY}</option>
										</select>
									</p>
								</div>
								<div class="col-md-4">
									<p>
										<label> 경력 : </label> <select name="FREELANCER_CAREER">
											<c:choose>
												<c:when test="${dto.FREELANCER_CAREER == 0}">
													<option value="${dto.FREELANCER_CAREER}" hidden selected>1년미만</option>
												</c:when>
												<c:otherwise>
													<option value="${dto.FREELANCER_CAREER}" hidden selected>${dto.FREELANCER_MIDDEL_KATEGORY}년</option>
												</c:otherwise>
											</c:choose>

											<option value=0>1년미만</option>
											<option value=1>1년</option>
											<option value=3>3년</option>
										</select>
									</p>
								</div>
								<div class="col-md-12 basicBtn2">
									<p>
										<label> 보유기술 : </label> <input type="text" id="mySkill"
											name="FREELANCER_SKILL" readonly="readonly"
											value="${dto.FREELANCER_SKILL}">
									<p />
								</div>


								<div class="col-md-12" id="portfolio"></div>

								<div class="col-md-12 basicBtn2">
									<p>
										<label> 자격증 : </label> <input type="text" id="myLicense"
											name="FREELANCER_CERTIFICATE" readonly="readonly"
											value="${dto.FREELANCER_CERTIFICATE}">
									<p />
								</div>

								<div class="col-md-12">
									<br> <label> 진행중 프로젝트 </label>

									<div
										style="overflow: auto; border: 1px solid #D3D3D3; width: 100%; height: 250px;">
										<c:forEach var="row" items="${ingList}">
											<a href="projectView.do?PROJECT_IDX=${row.PROJECT_IDX }">${row.PROJECT_SUBJECT}</a>
											<br>
										</c:forEach>
									</div>
								</div>

								<div class="col-md-12">
									<br> <label> 완료한 프로젝트 </label>

									<div
										style="overflow: auto; border: 1px solid #D3D3D3; width: 100%; height: 250px;">
										<c:forEach var="row" items="${edList}">
											<a href="$projectView.do?PROJECT_IDX=${row.PROJECT_IDX }">${row.PROJECT_SUBJECT}</a>
											<br>
										</c:forEach>
									</div>
								</div>

								<div class="col-md-12">
									<br> <label> 문의 내역 </label>

									<textarea rows="4" name="FREELANCER_ABOUT_ME"
										style="width: 100%; resize: none;"></textarea>
								</div>

								<div class="col-md-12">
									<br> <label> 제재 내역 </label>

									<textarea rows="4" name="FREELANCER_ABOUT_ME"
										style="width: 100%; resize: none;">제재내역 없음</textarea>
								</div>
								<div class="col-md-12">
									<div class="basic_btn" onclick="history.go(-1);" style="width: 100%">
										<a>뒤로 가기</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Shop Area End -->
	<!-- Footer Area Start -->
	<footer>
		<div class="footer-top-area">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-sm-8">
						<div class="footer-left">
							<div class="col-md-3">
								<a href="home"> <img
									src="<c:url value='resources/writer/img/freeCloud/logo.png'/>"
									alt="">
								</a>
							</div>
							<div class="col-md-9">
								<br>
								<h2 class="footer-title">
									<p>
										<a href="#">회사소개</a>&nbsp;|&nbsp;<a href="#">이용약관</a>&nbsp;|&nbsp;<a
											href="#">FAQ</a>&nbsp;|&nbsp;<a href="#">개인정보 처리방침</a>
								</h2>
							</div>
							<br> <br> <br> <br>
							<p>㈜ Free구름&nbsp;&nbsp;|&nbsp;&nbsp;대표자 :
								김영웅&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사업자등록번호 :
								123-12-12345</p>
							<ul class="footer-contact">
								<li><i class="flaticon-location"></i> 14558 경기도 의정부시 서부로
									545 융합소프트웨어과 404호
								<li>
								<li><i class="flaticon-web"></i> negahero@freeClude.com</li>
							</ul>
						</div>
					</div>
					<div class="col-md-4 hidden-sm">
						<div class="single-footer">
							<h1 class="footer-title">고객센터</h1>
							<ul class="footer-contact">
								<li><h4>운영시간 : 평일 09:00 ~ 18:00</h4></li>
								<li><i class="flaticon-technology"></i> (+800) 123 4567 890
								</li>
								<li><i class="flaticon-web"></i> negahero@freeClude.com</li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="footer-bottom-left pull-left">
							<p>
								Copyright &copy; 2020 <span><a href="#">FreeCloud</a></span>.
								All Right Reserved.
							</p>
						</div>
					</div>
					<div class="col-md-6">
						<div class="footer-bottom-right pull-right">
							<img src="<c:url value='resources/writer/img/paypal.png'/>"
								alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Area End -->
	<!--Quickview Product Start -->
	<div id="quickview-wrapper">
		<!-- Modal -->
		<div class="modal fade" id="productModal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="modal-product">
							<div class="product-images"></div>
							<div class="product-info">
								<h1>Frame Princes Cut Diamond</h1>
								<div class="price-box">
									<p class="s-price">
										<span class="special-price"><span class="amount">$280.00</span></span>
									</p>
								</div>
								<a href="product-details.html" class="see-all">See all
									features</a>
								<div class="quick-add-to-cart">
									<form method="post" class="cart">
										<div class="numbers-row">
											<input type="number" id="french-hens" value="3">
										</div>
										<button class="single_add_to_cart_button" type="submit">Add
											to cart</button>
									</form>
								</div>
								<div class="quick-desc">Lorem ipsum dolor sit amet,
									consectetur adipiscing elit. Nam fringilla augue nec est
									tristique auctor. Donec non est at libero vulputate rutrum.
									Morbi ornare lectus quis justo gravida semper. Nulla tellus mi,
									vulputate adipiscing cursus eu, suscipit id nulla.</div>
								<div class="social-sharing">
									<div class="widget widget_socialsharing_widget">
										<h3 class="widget-title-modal">Share this product</h3>
										<ul class="social-icons">
											<li><a target="_blank" title="Facebook" href="#"
												class="facebook social-icon"><i class="fa fa-facebook"></i></a></li>
											<li><a target="_blank" title="Twitter" href="#"
												class="twitter social-icon"><i class="fa fa-twitter"></i></a></li>
											<li><a target="_blank" title="Pinterest" href="#"
												class="pinterest social-icon"><i class="fa fa-pinterest"></i></a></li>
											<li><a target="_blank" title="Google +" href="#"
												class="gplus social-icon"><i class="fa fa-google-plus"></i></a></li>
											<li><a target="_blank" title="LinkedIn" href="#"
												class="linkedin social-icon"><i class="fa fa-linkedin"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
							<!-- .product-info -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 비밀번호 확인 -->

		<div class="modal fade" id="idDialog" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="modal-product">
							<div class="container">
								<div class="row">
									<div>
										<h2 class="heading-title">비밀번호 확인</h2>

										<p>
											<b>비밀번호 확인</b>
										</p>

										<p class="form-row seekid">
											<input type="password" id="myPassCheck">
										</p>

										<div class="submit" style="float: center">
											<button name="myPass" id="myPass" class="btn-default"
												style="width: 100%">
												<span> <i class="fa fa-user left"></i> 확인
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<!-- .product-info -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 비밀번호 확인 -->

		<!-- 이미지 변경 -->
		<div class="modal fade" id="pwDialog" tabindex="-1" role="dialog">
			<div class="modal-dialog" id="profileChange" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" id="profileClose"
							data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="modal-product">
							<div class="container">
								<div class="row">
									<div>
										<h2 class="heading-title">이미지 변경</h2>
										<p>
											<b>이미지파일</b>
										</p>
										<p class="form-row seekpw">
											<input type="file" name="file" id="file" placeholder="아이디 입력">
										</p>
										<div class="submit" style="float: center">
											<button name="CHANGE" id="CHANGE" class="btn-default"
												style="width: 100%">
												<span> <i class="fa fa-user left"></i> 이미지 변경
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<!-- .product-info -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 이미지 변경 -->


	</div>
	<!--End of Quickview Product-->
	<!-- all js here -->
	<!-- jquery latest version -->
	<script
		src="<c:url value='resources/writer/js/vendor/jquery-1.12.0.min.js'/>"></script>
	<!-- bootstrap js -->
	<script src="<c:url value='resources/writer/js/bootstrap.min.js'/>"></script>
	<!-- owl.carousel js -->
	<script src="<c:url value='resources/writer/js/owl.carousel.min.js'/>"></script>
	<!-- jquery-ui js -->
	<script src="<c:url value='resources/writer/js/jquery-ui.min.js'/>"></script>
	<!-- jquery Counterup js -->
	<script
		src="<c:url value='resources/writer/js/jquery.counterup.min.js'/>"></script>
	<script src="<c:url value='resources/writer/js/waypoints.min.js'/>"></script>
	<!-- jquery countdown js -->
	<script
		src="<c:url value='resources/writer/js/jquery.countdown.min.js'/>"></script>
	<!-- jquery countdown js -->
	<script type="text/javascript"
		src="<c:url value='resources/writer/venobox/venobox.min.js'/>"></script>
	<!-- jquery Meanmenu js -->
	<script src="<c:url value='resources/writer/js/jquery.meanmenu.js'/>"></script>
	<!-- wow js -->
	<script src="<c:url value='resources/writer/js/wow.min.js'/>"></script>
	<script>
		new WOW().init();
	</script>
	<!-- scrollUp JS -->
	<script
		src="<c:url value='resources/writer/js/jquery.scrollUp.min.js'/>"></script>
	<!-- plugins js -->
	<script src="<c:url value='resources/writer/js/plugins.js'/>"></script>
	<!-- Nivo slider js -->
	<script
		src="<c:url value='resources/writer/lib/js/jquery.nivo.slider.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='resources/writer/lib/home.js'/>"
		type="text/javascript"></script>
	<!-- main js -->
	<script src="<c:url value='resources/writer/js/main.js'/>"></script>
</body>
</html>