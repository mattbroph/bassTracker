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

    <div class="headerWithPic">
        <h1>${user.firstName}'s ${bassGoal.goalYear} Dashboard</h1>
        <img class="profileIcon" src="${empty user.profilePicture ? 'images/defaultProfile.svg' : user.profilePicture}" alt="profile picture">
    </div>
    <form name="dashboard"
          action="dashboard"
          method="get">
        <!-- Dashboard Year -->
        <label for="dashboardYear"></label>
        <select name="dashboardYear" id="dashboardYear" required>
                <option value="${bassGoal.goalYear}" selected disabled>${bassGoal.goalYear}</option>
                <c:forEach var="goal" items="${bassGoalList}">
                        <option value="${goal.goalYear}">${goal.goalYear}</option>
                </c:forEach>
        </select>
        <!-- Button-->
        <br>
        <input type="submit" value="Change Year" class="greenAnchorButton">
    </form>
    <%-- If yearly bass goal is 0, let the user know they can update it on their profile page--%>
    <c:if test="${bassGoal.goalCount == 0}">
        <p id="message">Your ${bassGoal.goalYear} bass goal is currently set to 0.<br>You can update your yearly goals on your profile page.</p>
    </c:if>
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
            <h2>Trip History</h2>
            <p>${dashboard.currentTripTotalForYear} Trips</p>
            <canvas id="tripChart">
            </canvas>
        </div>
        <div id="catchChartContainer"
                <c:forEach var="catchHistory" items="${dashboard.catchHistory.entrySet()}">
                    data-month-${catchHistory.key}="${catchHistory.value}"
                </c:forEach>
                data-monthly-catch-goal="${dashboard.monthlyCatchGoal}"
        >
            <h2>Catch History</h2>
            <p>Goal: ${dashboard.monthlyCatchGoal} Per Month</p>
            <canvas id="catchChart">
            </canvas>
        </div>
    </section>

</main>
<c:import url="footer.jsp" />
</body>
</html>