<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<!-- JavaScript -->
<script src="js/dashboard.js"></script>
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/forms.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Add a Lake</h1>

    <%-- Hooked up to ActionAddLake.
     If user tried to submit a lake that exists, this message will appear.
--%>
    <c:if test="${lakeMessage != null}">
        <h2 class="message">${lakeMessage}</h2>
        <br>
        <c:remove var="lakeMessage" scope="session" />
    </c:if>

    <%-- Hibernate validator messages. See ActionAddLake servlet
    retrieveFormData() method --%>
    <c:if test="${errorMessages != null}">
        <c:forEach var="error" items="${errorMessages}">
            <p class="message">${error}</p>
        </c:forEach>
        <c:remove var="errorMessages" scope="session" />
    </c:if>

    <form action="actionAddLake"
          method="post">

        <fieldset>
            <legend>Lake Details</legend>
            <!-- Lake Name -->
            <label for="lakeName">*Lake Name</label>
            <input type="text"
                   name="lakeName"
                   id="lakeName"
                   required>
            <!-- isActive -->
            <label for="status">*Lake Status</label>
            <select name="status" id="status">
                <option value="true">Active</option>
                <option value="false">Not Active</option>
            </select>
        </fieldset>
        <br>
        <!-- Button fields -->
        <div id="buttonContainer">
            <input type="submit" value="Add Lake">
            <a href="viewLakes" class="cancelButton">Cancel</a>
        </div>
    </form>
    <br>
    <br>
</main>
<c:import url="footer.jsp" />
</body>
</html>