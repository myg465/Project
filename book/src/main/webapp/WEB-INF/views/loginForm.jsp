<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link type="stylesheet" >
		<title>로그인 페이지</title>
		<link rel="stylesheet" type="text/css" href="css/admin_login.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="js/login_custom.js"></script>
	</head>
	<body>
		<section>
			<h1>admin Login</h1>
			<div>
				<h1><span>BOOK RENTAL</span> System</h1>
				<div id="login_div">
					<ul>
						<li id="img_div" style="background: url('images/lock.png') center center no-repeat; background-size:130px 130px;"></li>
						<li id="input_div">
							<label style="background: url('images/bg_user.gif')96% 48% no-repeat;"><input type="text" name="id" id="id" maxlength="20" required></label><br>
							<label style="background: url('images/bg_pw.gif') 96% 48% no-repeat;"><input type="password" name="pw" id="pw" maxlength="20" required></label><br>
						</li>
						<li id="btn_div">
							<a onclick="loginOk()"><button style="background: url('images/btn_login.png') 0 0 no-repeat;">Login</button></a>
						</li>
					
					</ul>
				</div>
				<p id="loginResult" style=" color: red; text-align: center; font-weight: bold; font-size: 16px;"></p>
			</div>
		</section>
	</body>
</html>