<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
		 language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Организация Футбольных Матчей</title>
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
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

<body ng-app="">
<div ng-include="'Pages/navBar.jsp'"></div>

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
				<s:form action="playerAdd" method="post">
					<p style="color: red;">
						<s:property value="errorString"></s:property>
					</p>
					<p>
						Имя:<input name="player.name" pattern="^[A-Za-z]{3,30}$" size="40"/>
					</p>
					<p>
						Номер:<input name="player.number" pattern="^[0-9]{1,2}$" size="40"/>
					</p>
					<p>
						Рост:<input name="player.hight" pattern="^[0-9]{3}$" size="40"/>
					</p>
					<p>
						Вес:<input size="40" pattern="^[0-9]{2,3}$" name="player.weight"/>
					</p>
					<p>
						<b>Команда:</b><br>
						<select name="team">
							<c:forEach var="team" items="${teams}">
								<option value="${team.name}">${team.name}</option>
							</c:forEach>
						</select>

					</p>
					<input type="submit" value="Отправить">
				</s:form>
			</div>
		</div>
	</div>
</div>

<!-- /.container -->
<s:iterator value="teams" var="team">
</s:iterator>
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
