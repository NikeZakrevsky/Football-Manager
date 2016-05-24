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
  <script
          src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
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
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
</head>

<body ng-app="">
  <div ng-include="'Pages/navBar.jsp'"></div>
    <div class="container">
      <div class="row">
        <div class="box">
        <div class="col-lg-12">
          <form role="form" action="saveStadiumAdmin" method="post">
            <p><b>Name:</b><br>
              <input type="text" name="name" size="40"></p>
            <p><b>Town:</b><br>
              <input type="text" name="town" size="40"></p>
            <p><b>Capacity:</b><br>
              <input type="text" name="capacity" size="40"></p>
            <input type="submit" value="Отправить">
          </form>
          <table class="tg">
            <tr>
              <th width="80">Stadium ID</th>
              <th width="120">Stadium Name</th>
              <th width="120">Stadium Town</th>
              <th width="120">Stadium Capacity</th>
              <th width="60">Edit</th>
              <th width="60">Delete</th>
            </tr>
            <c:forEach items="${stadiums}" var="stadium">
              <tr>
                <td>${stadium.id}</td>
                <td>${stadium.name}</td>
                <td>${stadium.town}</td>
                <td>${stadium.capacity}</td>
                <td><a href="<c:url value='/remove/${stadium.id}' />" >Delete</a></td>
              </tr>
            </c:forEach>
          </table>
        </div>
        </div>
      </div>
    </div>
  </div>
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
