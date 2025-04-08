<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/forms.css">
<!-- JavaScript -->
<script src="js/viewProfile.js"></script>
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Reports</h1>

    <br><br>
    <!-- Form -->
    <form name="contactUs"
          action="actionReports"
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
            <a href="index.html" class="cancelButton">Clear</a>
        </div>
    </form>
    <br>
    <br>
    <br>


    <!-- Table of Results -->

    <h2>Catch Rate</h2>
    <table id="table" class="display" style="width:100%">
        <thead>
        <tr>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Lake</th>
            <th>Fishing Type</th>
            <th>Catch Rate</th>
            <th>Bass Count</th>
            <th>Hours</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>01/18/25</td>
            <td>01/22/25</td>
            <td>Lake Kegonsa</td>
            <td>Shoreline</td>
            <td>2</td>
            <td>4</td>
            <td>2</td>
        </tr>
        </tbody>
    </table>



</main>
<c:import url="footer.jsp" />
</body>
</html>