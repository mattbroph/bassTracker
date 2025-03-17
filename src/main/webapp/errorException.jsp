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

    <h1>500 - Something went wrong</h1>
    <h2>We had a bite, but the line snapped.</h2>
    <br>
    <p>
        <b>The status code is:</b> <%= request.getAttribute("javax.servlet.error.status_code") %><br>
        <b>The error message is:</b> <%= request.getAttribute("javax.servlet.error.message") %><br>
        <b>The exception class is:</b> <%= request.getAttribute("javax.servlet.error.exception") %><br>
    </p>

</main>
<c:import url="footer.jsp" />
</body>
</html>