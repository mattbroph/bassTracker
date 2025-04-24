<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/forms.css">
<link rel="stylesheet" href="css/viewProfile.css">
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
<script src="js/viewProfile.js"></script>
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Reports</h1>
    <br><br>
    <%-- Hibernate validator messages. See ActionCreateReport servlet --%>
    <c:if test="${errorMessages != null}">
        <c:forEach var="error" items="${errorMessages}">
            <p class="message">${error}</p>
        </c:forEach>
        <c:remove var="errorMessages" scope="session" />
    </c:if>

    <!-- Form -->
    <c:if test="${empty catchRateStats}">
        <form action="actionCreateReport"
              method="post">
            <!-- Select Report -->
            <legend>Select a Report</legend>
            <label for="catchReport">
                <input class="radio" id="catchReport" type="radio" name="reportType" value="catchReport" checked>Catch Rate
            </label>
            <br>
            <!-- Placeholder for future reports -->
            <!-- <label for="placeholderReport">
            <input id="placeholderReport" type="radio" name="reportType" value="placeholderReport">Placeholder</label> -->
            <br>
            <!-- Start Date -->
            <fieldset>
                <legend>Catch Report</legend>

                <label for="startDate">*Start Date</label>
                <input type="date"
                       name="startDate"
                       id="startDate"
                       required>
                <br>
                <!-- End Date -->
                <label for="endDate">*End Date</label>
                <input type="date"
                       name="endDate"
                       id="endDate"
                       required>
                <br>
                <!-- Lake -->
                <label for="lake">*Lake</label>
                <select name="lake" id="lake">
                    <option value="allLakes" selected>All</option>
                    <%-- Populate the user lake options --%>
                    <c:forEach var="lake" items="${userLakes}">
                        <option value="${lake.id}">${lake.lakeName}</option>
                    </c:forEach>
                </select>
                <br>
                <!-- Fishing Method -->
                <label for="fishingMethod">*Fishing Method</label>
                <select name="fishingMethod" id="fishingMethod" required>
                    <option value="allMethods" selected>All</option>
                    <c:forEach var="method" items="${methodList}">
                        <option value="${method.id}">${method.methodName}</option>
                    </c:forEach>
                </select>
            </fieldset>
            <!-- Button fields -->
            <div id="buttonContainer">
                <input type="submit" value="Submit">
                <a href="viewReports" class="cancelButton">Clear</a>
            </div>
        </form>
    </c:if>

    <!-- Table of Results -->
    <c:if test="${not empty catchRateStats}">
        <a href="viewReports" class="greenAnchorButton">Run New Report</a>
        <br>
        <br>
        <br>
        <h2>Catch Rate</h2>
        <table id="table" class="display" style="width:100%">
            <thead>
            <tr>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Lake</th>
                <th>Method</th>
                <th>Catch Rate</th>
                <th>Bass Count</th>
                <th>Hours</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${startDate}</td>
                <td>${endDate}</td>
                <td>${lakeName}</td>
                <td>${methodName}</td>
                <td>${catchRateStats.currentCatchRateForUser}</td>
                <td>${catchRateStats.currentTotalBassCountForUser}</td>
                <td>${catchRateStats.currentTotalHoursForUser}</td>
            </tr>
            </tbody>
        </table>
    </c:if>
</main>
<c:import url="footer.jsp" />
</body>
</html>