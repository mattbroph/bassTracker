<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
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
    <h1>${user.firstName}'s Profile</h1>

    <%-- Hooked up to ActionEditProfile --%>
    <c:if test="${message != null}">
        <h2 id="message">${message}</h2>
        <br>
        <c:remove var="message" scope="session" />
    </c:if>



    <div id="largeContainer">
        <div id="profileContainer">
            <div id="photoContainer">
                <%-- If user profile is empty or null, grab the default image --%>
                <img id="profilePic" src="${empty user.profilePicture ? 'images/defaultProfile.svg' : user.profilePicture}" alt="profile picture">
            </div>
            <p id="userName">${user.firstName} ${user.lastName}</p>
            <br>
            <div class="buttonContainer">
                <a href="editProfile" class="greenAnchorButton">Edit Profile</a>
            </div>
        </div>

        <div id="statsContainer">
            <div class="statYellow">
                <p class="statCount">${profileStats.currentTotalBassCountForUser}</p>
                <img src="images/hook.svg" alt="fishing hook">
                <p class="statName">Bass Caught</p>
            </div>
            <div class="statGreen">
                <p class="statCount">${profileStats.currentTotalHoursForUser}</p>
                <img src="images/clock.svg" alt="clock">
                <p class="statName">Hours Fished</p>
            </div>
            <div class="statYellow">
                <p class="statCount">${profileStats.currentCatchRateForUser}</p>
                <img src="images/graph.svg" alt="bar graph">
                <p class="statName">Catch Rate</p>
            </div>
        </div>

        <!-- Table of Bass Goals -->
        <div id="bassGoalsContainer">
            <h2>Bass Goals</h2>
            <br>
            <%-- <a href="addGoal" class="yellowAnchorButton">Add Goal</a>--%>
            <%-- <br>--%>
            <%-- <br>--%>
            <table id="table" class="display" style="width:100%">
                <thead>
                <tr>
                    <th>Edit</th>
                    <th>Year</th>
                    <th>Goal</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="goal" items="${bassGoals}">
                    <tr>
                        <td>
                            <a href="editGoal?goalId=${goal.id}">
                                <img src="images/editIcon.svg" alt="edit goal">
                            </a>
                        </td>
                        <td>${goal.goalYear}</td>
                        <td>${goal.goalCount}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <br>

</main>
<c:import url="footer.jsp" />

</body>
</html>