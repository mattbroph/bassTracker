<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<!-- JavaScript -->
<script src="js/viewJournals.js"></script>
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/viewJournals.css">
<!-- Data Tables -->
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <c:if test="${not empty journals}">
        <h2>We've got journals folks</h2>
    </c:if>

    <h1>{$}Matt's Fishing Journals</h1>
    <br>
    <a href="addJournal" class="greenAnchorButton">Add Journal Entry</a>
    <br><br>
    <br><br>
    <br>
    <h2>Viewing All Journals</h2>
    <br>
    <form action="#" id="viewJournalRange">
        <div id="dateRange">
            <!-- Start Range -->
            <label for="startRange">*Start Range</label>
            <input type="date"
                   name="startRange"
                   id="startRange"
                   required>
            <!-- End Range -->
            <label for="endRange">*End Range</label>
            <input type="date"
                   name="endRange"
                   id="endRange"
                   required>
            <br>
            <br>
            <!-- Submit Date Range Button -->
            <input type="submit" value="Select Range" class="yellowSubmitButton">
        </div>
    </form>
    <br><br>
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
                <td>${journal.lakeID}</td>
                <td>${journal.totalBassCount}</td>
                <td>${journal.hours}</td>
                <td>${journal.airTemp}</td>
                <td>${journal.methodID}</td>
                <td>${journal.weatherID}</td>
                <td>${journal.windID}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>
<c:import url="footer.jsp" />

</body>
</html>