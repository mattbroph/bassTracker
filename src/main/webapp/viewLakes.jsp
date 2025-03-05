<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/viewTables.css">
<!-- Data Tables -->
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src="https://cdn.datatables.net/datetime/1.5.5/js/dataTables.dateTime.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css">
<link rel="stylesheet" href="https://cdn.datatables.net/datetime/1.5.5/css/dataTables.dateTime.min.css">
<!-- Data Tables Export Feature -->
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/3.2.2/css/buttons.dataTables.css">
<script src="https://cdn.datatables.net/buttons/3.2.2/js/dataTables.buttons.js"></script>
<script src="https://cdn.datatables.net/buttons/3.2.2/js/buttons.dataTables.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/3.2.2/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/3.2.2/js/buttons.print.min.js"></script>
<!-- JavaScript -->
<script src="js/viewLakes.js"></script>
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>${user.firstName}'s Lakes</h1>

    <%-- Hooked up to ActionAddLake at the moment --%>
    <c:if test="${lakeMessage != null}">
        <h2 id="message">${lakeMessage}</h2>
        <br>
        <c:remove var="lakeMessage" scope="session" />
    </c:if>

    <a href="addLake" class="greenAnchorButton">Add a Lake</a>
    <br><br>
    <br>
    <h2>Lakes Table</h2>
    <br>
    <!-- Table of Lake Entries -->
    <table id="table" class="display" style="width:100%">
        <thead>
        <tr>
            <th>Edit</th>
            <th>Lake</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="lake" items="${userLakes}">
            <tr>
                <td>
                    <a href="editLake?lakeId=${lake.id}">
                        <img src="images/editIcon.svg" alt="edit lake">
                    </a>
                </td>
                <td>${lake.lakeName}</td>
                <td>${lake.isActive ? 'Active' : 'Not Active'}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>
<c:import url="footer.jsp" />

</body>
</html>