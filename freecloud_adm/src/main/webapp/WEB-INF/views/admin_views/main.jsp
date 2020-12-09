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
	$(document).ready(function() {
		$("#clickDevel").click();
		$("#clickDesign").click();
		$("#devel2Click").click();		
		$("#design2Click").click();
	});
</script>

</head>
<body>
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<c:if test="${msg == 'logout'}">
		<script>
			alert("로그아웃 되었습니다.");
		</script>
	</c:if>
	<c:if test="${msg == 'success'}">
		<script>
			alert("${sessionScope.userName}님 환영합니다.");
		</script>
	</c:if>
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
				<br>
								<input type="text" placeholder="검색어를 입력하세요">
                                 <button name="submitcreate" id="submitcreate" type="submit" class="btn-default">
                                    <span>
                                        <i class="fa fa-search left"></i>
                                        	
                                    </span>
                                </button>
                            
				</div>

			</div>
		</div>
	</div>
	<!--Header Area End-->
	
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
	<!-- Featured Product Area Start -->
	<div class="featured-product-area section-padding">
		<h2 class="section-title">통계</h2>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="tab-menu">
						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="first-item active"><a
								id="clickDesign" href="#design" aria-controls="arrival"
								role="tab" data-toggle="tab">전체 월별 통계</a></li>
							<li role="presentation"><a href="#devel" id="clickDevel"
								aria-controls="sale" role="tab" data-toggle="tab">회원 통계(실시간)</a></li>
							<li role="presentation"><a href="#contents"
								aria-controls="sale" role="tab" data-toggle="tab">프로젝트 통계</a></li>
							
							
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="product-list tab-content">
					<div role="tabpanel" class="tab-pane fade in active" id="design">
						<div class="featured-product-list indicator-style">
							
								<!-- 메뉴 시작-->
									<div id="chart-area" style="margin: 0 auto;"></div>
									
								<!-- 메뉴 끝 -->
							
						</div>
					</div>
					<div role="tabpanel" class="tab-pane fade in active" id="devel">
						<div class="featured-product-list indicator-style">
								<!-- 메뉴 시작-->
									<div id="chart-area1" style="margin: 0 auto;"></div>
									
								<!-- 메뉴 끝 -->
						</div>
					</div>
					<div role="tabpanel" class="tab-pane fade in active" id="contents">
						<div class="featured-product-list indicator-style">
							<!-- 메뉴 시작-->
									<div id="chart-area2" style="margin: 0 auto;"></div>
									
								<!-- 메뉴 끝 -->
						</div>
					</div>
					
						
				</div>
				</div>
			</div>
		</div>

	               
	<!--  -->
	<br><br>

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
		            name: '회원(명)',
		            data: [500, 600, 873, 1235, 6377, 7685, 7599, 6466, 7777, 8000, 8888,9999]
		        },
		        {
		            name: '구독자(명)',
		            data: [200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300]
		        },
		        {
		            name: '프리미엄 등급 수익(천만원)',
		            data: [159, 223, 533, 235, 666, 444, 333, 352, 500, 600, 263, 400]
		        },
		        {
		            name: '중개수수료 수익(천만원)',
		            data: [1000, 1200, 1400, 1468, 1112, 2222, 2252, 3356, 2356, 5555, 6666,5434]
		        },
		        {
		            name: '완료된 프로젝트(갯수)',
		            data: [100, 500, 300, 800, 1000, 800, 700, 600, 450, 470, 900, 980]
		        },
		        
		    ]
		};
		var options = {
		    chart: {
		        width: 1200,
		        height: 540,
		        title: '월별 전체 통계'
		    },
		    yAxis: {
		        title: '회원(명)/수익(천만원)',
		        pointOnColumn: true
		    },
		    xAxis: {
		        title: 'Month'
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
		
		
		// chart 2
		function getRandom(start, end) {
		    return start + (Math.floor(Math.random() * (end - start + 1)));
		}
		
		function zeroFill(number) {
		    var filledNumber;
		
		    if (number < 10) {
		        filledNumber = '0' + number;
		    } else {
		        filledNumber = number;
		    }
		
		    return filledNumber;
		}
		
		function adjustTime(time, addTime) {
		    addTime = addTime || 60;
		    if (time < 0) {
		        time += addTime;
		    }
		    return time;
		}
		
		function makeDate(hour, minute, second) {
		    return zeroFill(adjustTime(hour, 24)) + ':' + zeroFill(adjustTime(minute)) + ':' + zeroFill(adjustTime(second));
		}
		
		function range(start, stop, step) {
		    var arr = [];
		    var flag;
		
		    if (typeof stop === 'undefined') {
		        stop = start || 0;
		        start = 0;
		    }
		
		    step = step || 1;
		    flag = step < 0 ? -1 : 1;
		    stop *= flag;
		
		    for (; start * flag < stop; start += step) {
		        arr.push(start);
		    }
		
		    return arr;
		}
		
		var legends = ['회원(명)', '구독자(명)'];
		var seriesData = range(2).map(function (value, index) {
		    var name = legends[index];
		    var data = range(20).map(function () {
		        return getRandom(150, 200);
		    });
		    return {
		        name: name,
		        data: data
		    };
		});
		var baseNow = new Date();
		var startSecond = baseNow.getSeconds() - seriesData[0].data.length - 1;
		var categories = seriesData[0].data.map(function (value, index) {
		    var hour = baseNow.getHours();
		    var minute = baseNow.getMinutes();
		    var second = startSecond + index;
		
		    if (second < 0) {
		        minute -= 1;
		    }
		
		    if (minute < 0) {
		        hour -= 1;
		    }
		    return makeDate(hour, minute, (startSecond + index));
		});
		var container1 = document.getElementById('chart-area1');
		var data1 = {
		    categories: categories,
		    series: seriesData
		};
		var options1 = {
		    chart: {
		        width: 1200,
		        height: 540,
		        title: '실시간 회원 통계'
		    },
		    xAxis: {
		        title: '시간',
		        labelInterval: 3,
		        tickInterval: 'auto'
		    },
		    yAxis: {
		        title: '명'
		    },
		    series: {
		        spline: true,
		        showDot: true,
		        shifting: true
		    },
		    tooltip: {
		        grouped: true
		    }
		};
		var chart = tui.chart.lineChart(container1, data1, options1);
		
		chart.on('load', function () {
		    var index = categories.length;
		    setInterval(function () {
		        var now = new Date();
		        var category = makeDate(now.getHours(), now.getMinutes(), now.getSeconds());
		        var values = [getRandom(150, 200), getRandom(150, 200)];
		
		        chart.addData(category, values);
		        index += 1;
		    }, 1000);
		});
		
		//chart 3
			var container2 = document.getElementById('chart-area2');
			var data2 = {
			    categories: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
			    series: [
			        {
			            name: '총 프로젝트(갯수)',
			            data: [5000, 3000, 5000, 7000, 6000, 4000, 1000, 5000, 3000, 5000, 7000, 6000, 4000, 1000]
			        },
			        {
			            name: '완료한 프로젝트(갯수)',
			            data: [8000, 1000, 7000, 2000, 6000, 3000, 5000, 8000, 1000, 7000, 2000, 6000, 3000, 5000]
			        }
			    ]
			};
			var options2 = {
			    chart: {
			        width: 1200,
			        height: 650,
			        title: '월별 완료 프로젝트 현황',
			        'format': '1,000'
			    },
			    yAxis: {
			        title: 'Month'
			    },
			    xAxis: {
			        title: 'Amount',
			        max: 14000
			    },
			    series: {
			        stack: 'normal'
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
			
			tui.chart.barChart(container2, data2, options2);
	</script>
</body>
</html>