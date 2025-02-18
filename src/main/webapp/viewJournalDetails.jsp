<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<!-- JavaScript -->
<script src="js/viewJournalDetails.js"></script>
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/viewJournalDetails.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Journal: ${journal.journalDate} | ${journal.lake.lakeName}</h1>
    <%-- Displays one-time success message if journal was just added --%>
    <c:if test="${addJournalMessage != null}" >
        <h2>${addJournalMessage}</h2>
    <%-- Remove success message from the session--%>
        <c:remove var="addJournalMessage" scope="session" />
    </c:if>
    <br>
    <div id="journalDetails">
        <!-- Left -->
        <div id="journalDetailsLeft">
            <!-- Button fields -->
            <div id="buttonContainer">
                <a href="editJournal?journalId=${journal.id}" class="greenAnchorButton">Edit Journal</a>
                <a href="index.jsp" class="yellowAnchorButton">Delete Journal</a>
            </div>
            <h2>Trip Details</h2>
            <ul>
                <li><span>Date:</span> ${journal.journalDate}</li>
                <li><span>Lake:</span> ${journal.lake.lakeName}</li>
                <li><span>Hours:</span> ${journal.hours}</li>
                <li><span>Fishing Method:</span> ${journal.method.methodName}</li>
                <li><span>Air Temp:</span> ${journal.airTemp}&#8457;</li>
                <li><span>Weather:</span> ${journal.weather.weatherType}</li>
                <li><span>Wind:</span> ${journal.wind.windType}</li>
                <li><span>Bass Caught:</span> ${journal.totalBassCount}</li>
                <li><span>Comments: </span>${journal.comments}</li>
            </ul>
            <!-- Could put the image here but I like it bigger? -->
        </div>
        <!-- Right -->
        <div id="journalDetailsRight">
            <!-- Bass Size Count -->
            <div id="bassSizeContainer"
                 data-sm1416="${journal.smallMouth1416}"
                 data-sm1619="${journal.smallMouth1619}"
                 data-sm19Plus="${journal.smallMouth19Plus}"
                 data-lm1416="${journal.largeMouth1416}"
                 data-lm1619="${journal.largeMouth1619}"
                 data-lm19Plus="${journal.largeMouth19Plus}"
            >
                <h2>Bass Size Count</h2>
                <canvas id="bassSizeDonut">
                </canvas>
            </div>
        </div>
    </div>
    <div id="photoDiv">
        <c:if test="${journal.imageURL != null}">
            <span><h2 id="photoH2">Photo of the Day:</h2></span>
            <img src="${journal.imageURL}" alt="Journal Photo">
        </c:if>
    </div>
    <br>
    <a href="viewJournals" class="greenAnchorButton">Go Back</a>

</main>
<c:import url="footer.jsp" />
</body>
</html>