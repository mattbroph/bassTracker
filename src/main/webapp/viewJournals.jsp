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

    <h1>{$}Matt's Fishing Journals</h1>
    <br>
    <a href="addJournal.jsp" class="greenAnchorButton">Add Journal Entry</a>
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
            <th>Method</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <a href="viewJournalDetails.jsp">
                    <img src="images/openIcon.svg" alt="view details">
                </a>
            </td>
            <td>01/20/25</td>
            <td>Boom Lake</td>
            <td>8</td>
            <td>3.5</td>
            <td>Crib Fishing</td>
        </tr>
        <tr>
            <td>
                <a href="viewJournalDetails.jsp">
                    <img src="images/openIcon.svg" alt="view details">
                </a>
            </td>
            <td>01/18/25</td>
            <td>Lake Kegonsa</td>
            <td>5</td>
            <td>2</td>
            <td>Live Scope</td>
        </tr>
        <tr>
            <td>
                <a href="viewJournalDetails.jsp">
                    <img src="images/openIcon.svg" alt="view details">
                </a>
            </td>
            <td>01/17/25</td>
            <td>Lake Tomahawk</td>
            <td>12</td>
            <td>4</td>
            <td>Live Scope</td>
        </tr>
        <tr>
            <td>
                <a href="viewJournalDetails.jsp">
                    <img src="images/openIcon.svg" alt="view details">
                </a>
            </td>
            <td>01/02/25</td>
            <td>Lake Kegonsa</td>
            <td>3</td>
            <td>4</td>
            <td>Shoreline</td>
        </tr>
        </tbody>
    </table>

</main>

</body>
</html>