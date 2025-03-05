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

    <h1>Welcome to bass tracker</h1>

    <c:choose>
        <c:when test="${empty user}">
            <a href = "logIn">Log in</a>
        </c:when>
        <c:otherwise>
            <h3>Welcome ${user.userEmail}</h3>
            <a href = "logOut">Log out</a>
        </c:otherwise>
    </c:choose>

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