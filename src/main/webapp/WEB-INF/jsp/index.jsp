<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>cafe_App&#176;</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/cover/">


    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="resources/css/style.css?v=2">
</head>
<body class="text-center">

<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand" align="left">cafe_App&#176;

                <br>

                ☕🍦🍨🍩🍰🧉🧁🍷🍟🍕🥪🌮🥙🍚🍜🍣🍤🥤</h3>
            <%--      <nav class="nav nav-masthead justify-content-center">--%>
            <%--        <a class="nav-link active" href="#">Home</a>--%>
            <%--        <a class="nav-link" href="#">Features</a>--%>
            <%--        <a class="nav-link" href="#">Contact</a>--%>
            <%--      </nav>--%>
        </div>
    </header>

    <main role="main" class="inner cover">
        <br>
        <br>
        <h1 class="cover-heading">A voting system for deciding where to have lunch</h1>
        <p class="lead">
            2 types of users: admin and regular users <br>
            Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and
            price)<br>
            Menu changes each day (admins do the updates)<br>
            Users can vote for a restaurant they want to have lunch at today<br>
            Only one vote counted per user<br>
            If user votes again the same day:<br>
            If it is before 11:00 we assume that he changed his mind.<br>
            If it is after 11:00 then it is too late, vote can't be changed
            Each restaurant provides a new menu each day.<br>

        <h4>Available rest endpoints:</h4>

        GET http://localhost:8080/cafeapp/rest/votes/today_winner
        <br>
        GET http://localhost:8080/cafeapp/rest/restaurants
        <br>
        GET http://localhost:8080/cafeapp/rest/admin/users
        </p>
        <p class="lead">
            <%--      <a href="#" class="btn btn-lg btn-secondary">Learn more</a>--%>
        </p>
    </main>

    <footer class="mastfoot mt-auto">
        <div class="inner">
            Kornilova Olga - Side project (active development phase) - Application with REST API using
            Hibernate/SpringMVC/SpringSecurity/Postgres/Jackson/Maven without frontend
        </div>
    </footer>
</div>
</body>
</html>
