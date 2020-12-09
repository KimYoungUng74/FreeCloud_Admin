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

<!-- TOAST UI CHART CDN LINK -->
     <link rel="stylesheet" href="https://uicdn.toast.com/tui.chart/latest/tui-chart.min.css">
    <script type='text/javascript' src='https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.min.js'></script>
    <script type='text/javascript' src='https://uicdn.toast.com/tui.chart/latest/raphael.js'></script>
    <script src="https://uicdn.toast.com/tui.chart/latest/tui-chart.min.js"></script>
<!-- TOAST UI CHART CDN LINK END -->

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
	$(function() {
		//프로필 바꾸기
		$('#CHANGE')
				.click(
						function() {
							// ajax로 전달할 폼 객체
							var formData = new FormData();
							// 폼 객체에 파일추가, append("변수명", 값)
							formData.append('file', $('#file')[0].files[0]);
							formData.append('originalProfile', $(
									'#originalProfile').val());
							$
									.ajax({
										type : "POST",
										url : "fileUploadAjax.do",
										data : formData,
										dataType : "text",
										processData : false,
										contentType : false,
										success : function(data) { //data : checkId에서 넘겨준 결과값
											if ($.trim(data) != "Fail") {
												var test = "<img alt=\"\"src=\"<c:url value='http://localhost:8181/img/profile/"
														+ $.trim(data)
														+ "'/>\">";
												$('#profile').html(test);
												$('#profileClose').click();

											} else {
												alert("실패");
											}
										}
									})
						})

		// 비밀번호 확인				
		$(function() {
			//비밀번호 확인
			$('#myPass').click(function() {

				$.ajax({
					type : "POST",
					url : "checkMyPass.do",
					data : {
						"pw" : $('#myPassCheck').val()
					},
					success : function(data) { //data : seekPw에서 넘겨준 결과값(pw)
						if (data == "Not_Match") {
							alert("비밀번호가 일치하지 않습니다.");
						} else {
							$('#infoForm').submit();
						}
					}
				})
			})

		});

		// 포트폴리오 전송
		$('#portfolioBtn')
				.click(
						function() {
							// ajax로 전달할 폼 객체
							var formData = new FormData();
							// 폼 객체에 파일추가, append("변수명", 값)
							formData.append('portfolio',
									$('#myPortfolio')[0].files[0]);

							$
									.ajax({
										type : "POST",
										url : "myPortfolioUploadAjax.do",
										data : formData,
										dataType : "text",
										processData : false,
										contentType : false,
										success : function(data) { //data : checkId에서 넘겨준 결과값
											if ($.trim(data) != "Fail") {
												var idx = data.indexOf("_") + 1;
												var test = "<div><a href='${path}/upload/displayFile?fileName="
														+ data
														+ "'>"
														+ data.substr(idx)
														+ "</a><span data-src="+data+">[삭제]</span></div>";
												$('#portfolio').html(test);
											} else {
												alert("실패");
											}
										}
									})
						})

		$("#portfolio").on("click", "span", function(event) {
			var that = $(this); // 여기서 this는 클릭한 span태그
			$.ajax({
				url : "myPortfolioDeleteAjax.do",
				type : "post",
				// data: "fileName="+$(this).attr("date-src") = {fileName:$(this).attr("data-src")}
				// 태그.attr("속성")
				data : {
					fileName : $(this).attr("data-src")
				}, // json방식
				dataType : "text",
				success : function(result) {
					if (result == "deleted") {
						// 클릭한 span태그가 속한 div를 제거
						that.parent("div").remove();
					}
				}
			});
		})
	});
</script>
<script type="text/javascript">
	$(function() {

		$('#CATAGORY1')
				.change(
						function() {
							$('#CATAGORY2').children('option').remove();
							if ($("#CATAGORY1 option:selected").val() == "") {
								num = new Array("중분류 선택");
								vnum = new Array("");
							} else if ($("#CATAGORY1 option:selected").val() == "design") {
								num = new Array("웹", "제품", "프리젠테이션", "인쇄물",
										"커머스, 쇼핑몰", "로고", "그래픽", "영상", "게임",
										"기타");
								vnum = new Array("WEB", "PRODUCT", "PRE",
										"PRINT", "SHOP", "LOGO", "GRAPHIC",
										"VIDEO", "GAME", "OTHER");
							} else if ($("#CATAGORY1 option:selected").val() == "devel") {
								num = new Array("웹", "애플리케이션", "워드프로세스",
										"퍼블리싱", "일반 소프트웨어", "커머스, 쇼핑몰", "게임",
										"임베디드", "기타");
								vnum = new Array("WEB", "APP", "WORD", "PUB",
										"SOFT", "SHOP", "GAME", "IMB", "OTHER");
							}

							for (var i = 0; i < num.length; i++) {
								$("#CATAGORY2").append(
										"<option value='"+vnum[i]+"'>" + num[i]
												+ "</option>");
							}
						})

		$('#skillBtn').click(
				function() {
					if ($('#mySkill').val() == "") {
						$('#mySkill').val($('#skillInput').val());
					} else {
						var oldMySkill = $('#mySkill').val();
						var newMySkill = oldMySkill.split(',');
						for ( var i in newMySkill) {
							if ($('#skillInput').val() == newMySkill[i]) {
								alert("이미 등록된 보유기술입니다.");
								return;
							}
						}
						$('#mySkill').val(
								$('#mySkill').val() + ","
										+ $('#skillInput').val());
						$('#skillInput').val("");
					}
				})

		$('#skillDeleteBtn').click(
				function() {
					if ($('#mySkill').val() == "") {
						alert("제거할 보유기술이 없습니다.");
					} else {
						var oldMySkill = $('#mySkill').val();
						var newMySkill = oldMySkill.split(',');
						$('#mySkill').val("");
						for ( var i in newMySkill) {
							if ($('#skillInput').val() == newMySkill[i]) {
								continue;
							} else {
								if ($('#mySkill').val() == "") {
									$('#mySkill').val(newMySkill[i]);
								} else {
									$('#mySkill').val(
											$('#mySkill').val() + ","
													+ newMySkill[i]);
								}

							}
						}
						$('#skillInput').val("");
					}
				})
		$('#licenseBtn').click(
				function() {
					if ($('#myLicense').val() == ""
							&& !($('#licenseInput').val() == "")) {
						$('#myLicense').val($('#licenseInput').val());
					} else {

						var oldMySkill = $('#myLicense').val();
						var newMySkill = oldMySkill.split(',');
						for ( var i in newMySkill) {
							if ($('#licenseInput').val() == newMySkill[i]) {
								alert("이미 등록된 자격증입니다.");
								return;
							}
						}
						$('#myLicense').val(
								$('#myLicense').val() + ","
										+ $('#licenseInput').val());
						$('#licenseInput').val("");
					}
				})
		$('#licenseDeleteBtn').click(
				function() {
					if ($('#myLicense').val() == "") {
						alert("제거할 자격증이 없습니다.");
					} else {
						var oldMyLicense = $('#myLicense').val();
						var newMyLicense = oldMyLicense.split(',');
						$('#myLicense').val("");
						for ( var i in newMyLicense) {
							if ($('#licenseInput').val() == newMyLicense[i]) {
								continue;
							} else {
								if ($('#myLicense').val() == "") {
									$('#myLicense').val(newMyLicense[i]);
								} else {
									$('#myLicense').val(
											$('#myLicense').val() + ","
													+ newMyLicense[i]);
								}

							}
						}
						$('#licenseInput').val("");
					}
				})

	});
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
										<a href="projectSearch.do">회원 관리</a>
									</h4>
									<ul class="sub-menu">
										<li><a href="projectReg.do">회원정보 관리</a></li>
										<li><a href="projectSearch.do">문의내역 관리</a></li>
										<li><a href="projectSearch.do">제재내역 관리</a></li>
									</ul></li>
								<li><h4>
										<a href="projectSearch.do">수익 관리</a>
									</h4>
									<ul class="sub-menu">
										<li><a href="manageFees.do">중개수수료 관리</a></li>
										<li><a href="manage_subscription_fee.do">프리미엄등급 구독료 관리</a></li>
									</ul></li>
								<li><h4>
										<a href="boardList.do">게시판 관리</a>
									</h4>
									
								<li><h4>
										<a href="">통계 안내</a>
									</h4>
									<ul class="sub-menu">
										<li><a href="userStatistics.do">회원 수 통계</a></li>
										<li><a href="projectStatistics.do">프로젝트 통계</a></li>
										<li><a href="revenueStatistics.do">수익 통계</a></li>
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
				<form action="myInfoModify.do" method="post" id="infoForm">
					<div class="col-md-3 col-sm-3 col-xs-12" style="font-size: 20px">
						<div class="row shop-widget">

							<div class="basic_btn" style="width: 100%">
								<a href="#" title="Quick view" data-toggle="modal"
									data-target="#pwDialog">중개수수료 관리</a>
							</div>

							<div class="basic_btn" style="width: 100%">
								<a href="#" title="Quick view" data-toggle="modal"
									data-target="#pwDialog">프르미엄 등급 구독료 관리</a>
							</div>

							<br>

						</div>
					</div>
					<div class="col-md-9 col-sm-9 col-xs-12"">
						<div
							style="width: 100%; height: 100%; border: 1px solid #D3D3D3; padding: 10px;">
							<div class="row">
								<div class="col-md-12">
									<p>
										<label style="font-size: 15px; color: gray;"> 중개수수료 관리
										</label>
									<p>
									<p style="font-size: 30px;">
										<label> &nbsp;&nbsp;&nbsp;중개 수수료 : 5%</label>
										&nbsp;&nbsp;&nbsp; <input type="text" style="width: 30%"
											placeholder="중개수수료 입력"> <input type="button"
											style="width: 30%;" value="변경">
									<p>
									<center>
									<div
										style="width: 90%; height: 90%; border: 1px solid #D3D3D3; padding: 10px;">
										
										<label style="font-size: 15px; color: gray;"> 2020년 11월 중개수수료 관리
										</label>
										
										<br>
										<span style="display:inline-block; width:30%; font-size:25px; background-color:#CCCC">총 프로젝트 비용</span>
										<span style="display:inline-block; width:30%; font-size:25px; background-color:#CCCC">지급해야할 금액</span>
										<span style="display:inline-block; width:30%; font-size:25px; background-color:#CCCC">순수익</span>
										
										<p style="font-size: 21px;">
										<input type="text" style="width: 30%">
										<input type="text" style="width: 30%">
										<input type="text" style="width: 30%">
										</p>
										
										<div class="table-responsive" id="checkout-review-table-wrapper">
									<br>
									<table class="data-table" id="checkout-review-table">
										<thead>
											<tr>
												<th rowspan="1">번호</th>
												<th rowspan="1">게시글</th>
												<th colspan="1">아이디</th>
												<th rowspan="1">가격(규모)</th>
												<th colspan="1">완료날짜</th>
											</tr>
										</thead>

										<tbody>

											<tr>
												<td><h3>45</h3></td>
												<td><h3 class="product-name">
														<a href="boardView.do?BBS_IDX=45">완료게시글1</a>
													</h3></td>
												<td><span class="cart-price"><span
														class="check-price">opq</span></span></td>
												<td>12.000.000</td>
												<!-- sub total starts here -->
												<td><span class="cart-price"><span
														class="check-price">2020-07-08</span></span></td>
											</tr>


											<tr>
												<td><h3>44</h3></td>
												<td><h3 class="product-name">
														<a href="boardView.do?BBS_IDX=44">완료게시글2</a>
													</h3></td>
												<td><span class="cart-price"><span
														class="check-price">opq</span></span></td>
												<td>17.000.000</td>
												<!-- sub total starts here -->
												<td><span class="cart-price"><span
														class="check-price">2020-07-08</span></span></td>
											</tr>


											<tr>
												<td><h3>43</h3></td>
												<td><h3 class="product-name">
														<a href="boardView.do?BBS_IDX=43">완료게시글3</a>
													</h3></td>
												<td><span class="cart-price"><span
														class="check-price">opq</span></span></td>
												<td>15.000.000</td>
												<!-- sub total starts here -->
												<td><span class="cart-price"><span
														class="check-price">2020-07-08</span></span></td>
											</tr>


											<tr>
												<td><h3>42</h3></td>
												<td><h3 class="product-name">
														<a href="boardView.do?BBS_IDX=42">완료게시글4</a>
													</h3></td>
												<td><span class="cart-price"><span
														class="check-price">opq</span></span></td>
												<td>20.000.000</td>
												<!-- sub total starts here -->
												<td><span class="cart-price"><span
														class="check-price">2020-07-08</span></span></td>
											</tr>


											<tr>
												<td><h3>41</h3></td>
												<td><h3 class="product-name">
														<a href="boardView.do?BBS_IDX=41">완료게시글5 </a>
													</h3></td>
												<td><span class="cart-price"><span
														class="check-price">opq</span></span></td>
												<td>100.000.000<d>
												<!-- sub total starts here -->
												<td><span class="cart-price"><span
														class="check-price">2020-07-08</span></span></td>
											</tr>
											
											
										</tbody>

									</table>
								</div>
								<br>
									<div>
										<div id="chart-area"></div>
									</div>
								
									</div>
									
									
									</center>
								</div>

								<div class="col-md-12">
									<div class="basic_btn" style="width: 30%; float: left">
										<a title="Quick view" data-toggle="modal"
											data-target="#idDialog">뒤로 가기</a>
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
	
	<!-- CHart -->
	<script type="text/javascript">
		var container = document.getElementById('chart-area');
		var data = {
		    categories: ['1월', '2월', '3월', '4월', '5월', '6월','7월', '8월', '9월', '10월', '11월', '12월'],
		    series: [
		        {
		            name: '중개수수료 수익(천만원)',
		            data: [500, 600, 873, 1235, 6377, 7685, 7599, 6466, 7777, 8000, 8888,9999]
		        }
		        
		    ]
		};
		var options = {
		    chart: {
		        width: 700,
		        height: 540,
		        title: '월별 전체 통계'
		    },
		    yAxis: {
		        title: '원',
		        pointOnColumn: true
		    },
		    xAxis: {
		        title: '월'
		    },
		    series: {
		        spline: true,
		        showDot: false
		    },
		    tooltip: {
		        suffix: ''
		    }
		};
		var theme = {
		    series: {
		        colors: [
		            '#83b14e', '#458a3f', '#295ba0', '#2a4175', '#289399',
		            '#289399', '#617178', '#8a9a9a', '#516f7d', '#dddddd'
		        ]
		    }
		};
	
		// For apply theme
	
		// tui.chart.registerTheme('myTheme', theme);
		// options.theme = 'myTheme';
	
		tui.chart.lineChart(container, data, options);
	</script>
</body>
</html>