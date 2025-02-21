<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<!-- JavaScript -->
<script src="js/dashboard.js"></script>
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/dashboard.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>{$}Matt's ${bassGoal.goalYear} Dashboard</h1>
    <br>
    <br>
    <section id="dashboardRowOne">
        <!-- Bass Goal Donut -->
        <div id="bassGoalContainer"
             data-currentBassCount="${dashboard.currentTotalBassCountForYear}"
             data-bassGoal="${bassGoal.goalCount}"
        >
            <h2>Bass Goal</h2>
            <p>${dashboard.currentTotalBassCountForYear} of ${bassGoal.goalCount}</p>
            <canvas id="bassGoalDonut">
            </canvas>
        </div>
        <!-- Bass Size Count -->
        <div id="bassSizeContainer"
             data-sm1416="${dashboard.currentSmallMouth1416ForYear}"
             data-sm1619="${dashboard.currentSmallMouth1619ForYear}"
             data-sm19Plus="${dashboard.currentSmallMouth19PlusForYear}"
             data-lm1416="${dashboard.currentLargeMouth1416ForYear}"
             data-lm1619="${dashboard.currentLargeMouth1619ForYear}"
             data-lm19Plus="${dashboard.currentLargeMouth19PlusForYear}"
             >
            <h2>Bass Size Count</h2>
            <canvas id="bassSizeDonut">
            </canvas>
        </div>
        <div id="statContainer">
            <!-- Catches Per Hour -->
            <div id="catchPerHourContainer">
                <h2>Catches Per Hour</h2>
                <br>
                <p>${dashboard.currentCatchRateForYear}</p>
            </div>
            <!-- Total Hours -->
            <div id="totalHoursContainer">
                <h2>Total Hours</h2>
                <br>
                <p>${dashboard.currentTotalHoursForYear}</p>
            </div>
        </div>
    </section>

    <section id="dashboardRowTwo">
        <!-- Trip History -->
        <div id="tripChartContainer"
                <c:forEach var="history" items="${dashboard.tripHistory.entrySet()}">
                    data-month-${history.key}="${history.value}"
                </c:forEach>
        >
            <!-- TODO Hardcoded need to update -->
            <h2>Trip History</h2>
            <p>${dashboard.currentTripTotalForYear} Trips</p>
            <canvas id="tripChart">
            </canvas>
        </div>
        <div id="catchChartContainer">
            <!-- TODO Hardcoded need to update -->
            <h2>Catch History</h2>
            <p>Goal: 25 Per Month</p>
            <canvas id="catchChart">
            </canvas>
        </div>
    </section>

</main>
<c:import url="footer.jsp" />
</body>
</html>