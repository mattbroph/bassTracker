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
        <c:when test="${empty userEmail}">
            <a href = "logIn">Log in</a>
        </c:when>
        <c:otherwise>
            <h3>Welcome ${userEmail}</h3>
        </c:otherwise>
    </c:choose>

</main>
<c:import url="footer.jsp" />
</body>
</html>