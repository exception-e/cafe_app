<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>


<div>
    <div>
        <h3>Users</h3>
        <button class="btn btn-primary" onclick="add()">
            <span class="fa fa-plus"></span>
        </button>
        <table class="table table-striped" id="datatable">
            <thead>

            </thead>
        </table>
    </div>
</div>

</body>
</html>