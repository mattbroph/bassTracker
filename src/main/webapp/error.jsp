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

    <h1>Something went wrong</h1>

    <c:if test="${addJournalMessage != null}">
        <h2>${deleteJournalMessage}</h2>
    </c:if>

</main>
<c:import url="footer.jsp" />
</body>
</html>