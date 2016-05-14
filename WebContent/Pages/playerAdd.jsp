<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Организация Футбольных Матчей</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/business-casual.css" rel="stylesheet">

<!-- Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="brand">Организация Футбольных Матчей</div>
	<div class="address-bar">
		Yakhovsky Team(Yakhovsky, Zakrevsky, Moskalenko) <a href="#">Регистрация|</a><a
			href="#">Вход</a>
	</div>

	<!-- Navigation -->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
				<a class="navbar-brand" href="index.do">Business Casual</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="index.do">Главная</a></li>
					<li><a href="teams.do">Команды</a></li>
					<li><a href="stadiums.do">Стадионы</a></li>
					<li><a href="matches.do">Матчи</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<div class="container">

		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<hr class="tagline-divider">
					<h2 class="brand-before">Добавление Нового Игрока</h2>
					<hr class="tagline-divider">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<form role="form" action="savePlayer.do" method="post">
						<p>
							<b>Имя:</b><br> <input type="text" name="name" size="40">
						</p>
						<p>
							<b>Номер:</b><br> <input type="text" name="number" size="40">
						</p>
						<p>
							<b>Рост:</b><br> <input type="text" name="hight" size="40">
						</p>
						<p>
							<b>Вес:</b><br> <input type="text" size="40" name="weight">
						</p>
						<p>
							<b>Команда:</b><br> 
							<select name="teamName">
								<c:forEach var="listValue" items="${lists}">
									<option value="${listValue.name}">${listValue.name}</option>
								</c:forEach>
							</select> 
							<input type="submit" value="Отправить">
					</form>
				</div>
			</div>
		</div>



		<!-- /.container -->

		<footer>
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<p>Copyright &copy; Yakhovsky Team</p>
					</div>
				</div>
			</div>
		</footer>

		<!-- jQuery Version 1.11.0 -->
		<script src="resources/js/jquery-1.11.0.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="resources/js/bootstrap.min.js"></script>

		<!-- Script to Activate the Carousel -->
		<script>
			$('.carousel').carousel({
				interval : 5000
			//changes the speed
			})
		</script>
</body>

</html>
