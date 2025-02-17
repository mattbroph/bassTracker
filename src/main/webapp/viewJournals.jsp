<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/viewJournals.css">
<!-- Data Tables -->
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src="https://cdn.datatables.net/datetime/1.5.5/js/dataTables.dateTime.min.js"></script>

<link rel="stylesheet" href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css">
<link rel="stylesheet" href="https://cdn.datatables.net/datetime/1.5.5/css/dataTables.dateTime.min.css">
<!-- JavaScript -->
<script src="js/viewJournals.js"></script>
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>{$}Matt's Fishing Journals</h1>
    <a href="addJournal" class="greenAnchorButton">Add Journal Entry</a>
    <br><br>
    <br>
    <h2>Journals Table</h2>
    <br>
    <!-- Table of Date Inputs for DataTables -->
    <table cellspacing="5" cellpadding="5">
        <tbody><tr>
            <td>Start Range:</td>
            <td><input type="text" id="min" name="min"></td>
        </tr>
        <tr>
            <td>End Range:</td>
            <td><input type="text" id="max" name="max"></td>
        </tr>
        <tr>
            <td><a href="viewJournals" class="yellowAnchorButton">Clear Filters</a></td>
        </tr>
        </tbody>
    </table>
    <!-- Table of Journal Entries -->
    <table id="journalsTable" class="display" style="width:100%">
        <thead>
        <tr>
            <th>View Details</th>
            <th>Date</th>
            <th>Lake</th>
            <th>Bass Count</th>
            <th>Hours</th>
            <th>Air Temp</th>
            <th>Method</th>
            <th>Weather</th>
            <th>Wind</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="journal" items="${journals}">
            <tr>
                <td>
                    <a href="viewJournalDetails.jsp?id=${journal.id}">
                        <img src="images/openIcon.svg" alt="view details">
                    </a>
                </td>
                <td>${journal.journalDate}</td>
                <td>${journal.lake.lakeName}</td>
                <td>${journal.totalBassCount}</td>
                <td>${journal.hours}</td>
                <td>${journal.airTemp}</td>
                <td>${journal.method.methodName}</td>
                <td>${journal.weather.weatherType}</td>
                <td>${journal.wind.windType}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>
<c:import url="footer.jsp" />

</body>
</html>