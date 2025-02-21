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
        <div id="bassSizeContainer">
            <!-- TODO Hardcoded need to update -->
            <h2>Bass Size Count</h2>
            <canvas id="bassSizeDonut">
            </canvas>
        </div>
        <div id="statContainer">
            <!-- Catches Per Hour -->
            <div id="catchPerHourContainer">
                <!-- TODO Hardcoded need to update -->
                <h2>Catches Per Hour</h2>
                <br>
                <p>${dashboard.currentCatchRateForYear}</p>
            </div>
            <!-- Total Hours -->
            <div id="totalHoursContainer">
                <!-- TODO Hardcoded need to update -->
                <h2>Total Hours</h2>
                <br>
                <p>${dashboard.currentTotalHoursForYear}</p>
            </div>
        </div>
    </section>

    <section id="dashboardRowTwo">
        <!-- Trip History -->
        <div id="tripChartContainer">
            <!-- TODO Hardcoded need to update -->
            <h2>Trip History</h2>
            <p>75 Trips</p>
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