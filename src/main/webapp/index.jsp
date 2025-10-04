<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/dashboard.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Welcome to Bass Tracker</h1>

    <c:choose>
    <%-- User is not logged in --%>
        <c:when test="${empty user}">
            <h2>Overview</h2>
            <br>
            <p>With an account you can...</p>
            <ul>
                <li>Log and review fishing journal entries</li>
                <li>View dashboard statistics</li>
                <li>Analyze your fishing data and trends</li>
            </ul>
            <br>
            <a href = "logIn" class="greenAnchorButton">Log In / Sign Up</a>
        </c:when>
        <c:otherwise>
            <%-- User is logged in --%>
            <h2>Hi ${user.firstName}, you are now logged in.</h2>
            <br>
            <a href = "logOut" class="greenAnchorButton">Log out</a>
        </c:otherwise>
    </c:choose>
    <br>
    <br>
    <br>
    <h2>Getting Started</h2>
    <ol>
        <li>Log in or sign up for an account</li>
        <li>Add at least one lake under the lakes page</li>
        <li>Update your yearly bass goals under your profile page</li>
        <li>Log journals</li>
        <li>Explore</li>
    </ol>
    <br>
    <br>
    <h2>Special Thanks To:</h2>
        <ul>
            <li><a href="https://datatables.net/" target="_blank">DataTables</a></li>
            <li><a href="https://www.chartjs.org/docs/latest/" target="_blank">Chart.js</a></li>
            <li><a href="https://dev.meteostat.net/api/#quick-start" target="_blank">MeteoStat Weather API</a></li>
            <li><a href="https://www.geonames.org/" target="_blank">GeoNames Location API</a></li>
        </ul>

    <%-- If an error occured while inserting the user into the db. Check
    UserService addUserSession() for details --%>
    <c:if test=" ${not empty newUserError}">
        <h2>${newUserError}</h2>
        <c:remove var="newUserError" scope="session" />
    </c:if>

</main>
<c:import url="footer.jsp" />
</body>
</html>