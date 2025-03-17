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

    <h1>Edit ${lake.lakeName}</h1>

    <%-- Hooked up to ActionAddLake.
         If user tried to submit a lake that exists, this message will appear.
    --%>
    <c:if test="${lakeMessage != null}">
        <h2 id="message">${lakeMessage}</h2>
        <br>
        <br>
        <c:remove var="lakeMessage" scope="session" />
    </c:if>

    <form action="actionEditLake"
          method="post">

        <fieldset>
            <legend>Lake Details</legend>
            <!-- Lake Name -->
            <label for="lakeName">*Lake Name</label>
            <input type="text"
                   name="lakeName"
                   id="lakeName"
                   value="${lake.lakeName}"
                   required>
            <!-- isActive Status -->
            <label for="status">*Lake Status</label>
            <select name="status" id="status">
                <option value="true" ${lake.isActive == true ? 'selected' : ''}>Active</option>
                <option value="false" ${lake.isActive == false ? 'selected' : ''}>Not Active</option>
            </select>
        </fieldset>

        <%-- Hidden field to provide lake id to doPost method  --%>
        <input type="hidden" name="lakeId" value="${lake.id}">

        <br>
        <!-- Button fields -->
        <div id="buttonContainer">
            <input type="submit" value="Edit Lake">
            <a href="viewLakes" class="cancelButton">Cancel</a>
        </div>
    </form>
    <br>
    <br>
</main>
<c:import url="footer.jsp" />
</body>
</html>