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
          <h2>Players</h2>
          <table class="tg">
            <tr>
              <th width="80">Player ID</th>
              <th width="120">Name</th>
              <th width="120">Number</th>
              <th width="120">Weight</th>
              <th width="120">Height</th>
              <th width="120">Team name</th>
              <th width="60">Delete</th>
            </tr>
            <s:iterator value="players" var="player">
              <tr>
                <td><s:property value="#player.id"/></td>
                <td><s:property value="#player.name"/></td>
                <td><s:property value="#player.number"/></td>
                <td><s:property value="#player.weight"/></td>
                <td><s:property value="#player.hight"/></td>
                <td><s:property value="#player.teamName"/></td>
                <td>
                  <s:url id="deleteURL" action="deletePlayer">
                    <s:param name="id" value="%{id}"></s:param>
                  </s:url>
                  <s:a href="%{deleteURL}">Delete</s:a>
                </td>

              </tr>
            </s:iterator>
          </table>
          <h2>Users</h2>
          <form action="addUser" method="post">
            <s:hidden name="user.id" />
            <p><b>Username:</b><br>
              <s:textfield name="user.login" size="40" /></p>
            <p><b>Password:</b><br>
              <s:textfield type="text" name="user.password" size="40" /></p>
            <p><b>Role:</b><br>
              <s:textfield type="text" name="role" size="40" /></p>
            <input type="submit" value="Отправить">
          </form>
          <table class="tg">
            <tr>
              <th width="80">User ID</th>
              <th width="120">Username</th>
              <th width="120">Password</th>
              <th width="120">Role</th>
              <th width="60">Edit</th>
              <th width="60">Delete</th>
            </tr>
            <s:iterator value="users" var="user">
              <tr>
                <td><s:property value="#user.id"/></td>
                <td><s:property value="#user.login"/></td>
                <td><s:property value="#user.password"/></td>
                <td><s:property value="#user.role.name"/></td>
                <td><s:url id="editURL" action="editUser">
                  <s:param name="id" value="%{id}"></s:param>
                </s:url>
                  <s:a href="%{editURL}">Edit</s:a>
                </td>
                <td>
                  <s:url id="deleteURL" action="deleteUser">
                    <s:param name="id" value="%{id}"></s:param>
                  </s:url>
                  <s:a href="%{deleteURL}">Delete</s:a>
                </td>
              </tr>
            </s:iterator>
          </table>
          <h2>Stadiums</h2>
          <form action="addStadium" method="post">
            <s:hidden name="stadium.id" />
            <p><b>Name:</b><br>
              <s:textfield name="stadium.name" value="%{stadium.name}" size="40" /></p>
            <p><b>Town:</b><br>
              <s:textfield type="text" name="stadium.town" size="40" /></p>
            <p><b>Capacity:</b><br>
              <s:textfield type="text" name="stadium.capacity" size="40" /></p>
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
            <s:iterator value="stadiums" status="stadium">
              <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="name"/></td>
                <td><s:property value="town"/></td>
                <td><s:property value="capacity"/></td>
                <td><s:url id="editURL" action="editStadium">
                  <s:param name="id" value="%{id}"></s:param>
                </s:url>
                  <s:a href="%{editURL}">Edit</s:a>
                </td>
                <td><s:url id="deleteURL" action="deleteStadium">
                      <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                    <s:a href="%{deleteURL}">Delete</s:a>
                </td>
              </tr>
            </s:iterator>
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
