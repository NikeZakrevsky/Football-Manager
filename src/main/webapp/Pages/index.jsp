<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
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
					<div id="carousel-example-generic" class="carousel slide">
						<!-- Indicators -->
						<ol class="carousel-indicators hidden-xs">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img class="img-responsive img-full"
									src="resources/img/slide-1.jpg" alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full"
									src="resources/img/slide-2.jpg" alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full"
									src="resources/img/slide-3.jpg" alt="">
							</div>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span class="icon-prev"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="icon-next"></span>
						</a>
					</div>
					<h2 class="brand-before">
						<small>Добро пожаловать на сайт</small>
					</h2>
					<h1 class="brand-name">Организации Футбольных Матчей</h1>
					<hr class="tagline-divider">
					<h2>
						<small>By <strong>Yakhovsky Team</strong>
						</small>
					</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Организуйте матчи <strong>с другими командами</strong>
					</h2>
					<hr>
					<img class="img-responsive img-border img-left"
						src="resources/img/intro-pic.png" alt="">
					<hr class="visible-xs">
					<p>Соревнования по футболу, как и в любом другом виде спорта —
						важная составляющая игры. Соревнование организуется федерацией,
						для каждого турнира составляется регламент, в котором обычно
						определяют состав участников, схему турнира, правила определения
						победителя при равенстве очков и какие-то отклонения от правил,
						например количество замен. Соревнования делятся на внутренние и
						международные, которые в свою очередь разделяются на клубные и
						национальных сборных. Футбольные турниры собирают десятки тысяч
						зрителей на трибунах стадиона и многомиллионные аудитории по
						телевидению.</p>
					<p>Ритуальные игры с мячом давно были распространены на всех
						континентах. Древние кожаные мячи были найдены при раскопках в
						Англии и Греции. Согласно преданиям античности, первый мяч дала
						Эросу богиня Афродита, сказав ему такие слова: «Я дам тебе
						чудесную игрушку: это шар быстро летучий, иной лучшей забавы ты не
						добудешь из рук Гефеста». В зависимости от ритуала мяч мог
						символизировать и Солнце, и Луну, и Землю, и даже полярное сияние.
						В Австралии мячи делали из шкур сумчатых крыс, мочевых пузырей
						крупных животных, из скрученных волос. У индейцев лакота (сиу)
						игра в мяч называлась Тапа Банка Яп («Бросание мяча»). Она
						появилась благодаря видению вождя Уаскн Мани (Идущий в Движении).
						Изначально эта игра была направлена на обеспечение процветания
						племени. Обряд требовал длительной подготовки, в течение которой
						сооружался алтарь, символизирующий центр Земли.</p>
					<p>У эскимосов игра в мяч называется тунгатгак. Она проводится
						с наступлением первых морозов. Вначале игроки разбиваются на две
						команды. Цель игры — не допустить, чтобы команда противника
						завладела мячом. Поединок, как правило, прекращается поздно
						вечером по соглашению сторон. У китайцев была известна игра цуцзю
						(кит. 蹴鞠), («Толкать ногой») которая входила в обязательную
						программу физической подготовки солдат. Упоминания о цуцзю
						относятся к II веку до н. э. ФИФА в 2004 году официально признала,
						что именно китайский вариант футбола — самый древний. В Италии
						играли в кальчо. Эта игра может считаться главным предком футбола,
						потому что в ней были и нападающие, и защитники, и судьи.</p>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Футбол - <strong>игра миллионов</strong>
					</h2>
					<hr>
					<p>Футбо́л (от англ. foot — ступня, ball — мяч) — командный вид
						спорта, в котором целью является забить мяч в ворота соперника
						ногами или другими частями тела (кроме рук) большее количество
						раз, чем команда соперника. В настоящее время самый популярный и
						массовый вид спорта в мире</p>
					<p>Самым престижным соревнованием является Чемпионат мира,
						проводящийся раз в 4 года. Первый розыгрыш прошёл в 1930 году в
						Уругвае. В квалификации на чемпионат мира участвуют около 200
						национальных сборных</p>
				</div>
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
