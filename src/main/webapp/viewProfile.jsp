<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/viewProfile.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">
    <h1>${user.firstName}'s Profile</h1>

    <h2>Profile Details</h2>
    <br>
    <p><span>First Name:</span> ${user.firstName}</p>
    <p><span>Last Name:</span> ${user.lastName}</p>
    <p><span>Yearly Bass Goals:</span></p>
    <ul>
        <c:forEach var="goal" items="${bassGoals}">
            <li>${goal.goalYear} - Goal: ${goal.goalCount}</li>
        </c:forEach>
    </ul>
    <p id="profilePicTitle"><span>Profile Pic:</span></p>
    <c:if test="${not empty user.profilePicture}">
        <img id="profilePic" src="${user.profilePicture}" alt="profile picture">
    </c:if>
    <br>
    <div class="buttonContainer">
        <a href="editProfile" class="greenAnchorButton">Edit Profile</a>
    </div>

</main>
<c:import url="footer.jsp" />

</body>
</html>