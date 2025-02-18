<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<!-- JavaScript -->
<script src="js/dashboard.js"></script>
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/journal.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Viewing Journal Details</h1>

    <c:if test="${addJournalMessage != null}" >

        <h2>${addJournalMessage}</h2>
<%--        <c:remove var="project4AddMessage" scope="session" />--%>
    </c:if>




</main>
<c:import url="footer.jsp" />
</body>
</html>