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
    <h1>Matt's Profile</h1>

    <h2>Profile Details</h2>
    <br>
    <p><span>First Name:</span> Matt</p>
    <p><span>Last Name:</span> Brophy</p>
    <p><span>Yearly Bass Goals:</span></p>
    <ul>
        <li>2025 - Goal: 150</li>
        <li>2024 - Goal: 75</li>
    </ul>
    <p id="profilePicTitle"><span>Profile Pic:</span></p>
    <img id="profilePic" src="https://i.postimg.cc/BZmpbFBz/mb-bass.jpg" alt="matt's profile pic">

    <br>
    <div class="buttonContainer">
        <a href="editProfile" class="greenAnchorButton">Edit Profile</a>
    </div>


</main>
<c:import url="footer.jsp" />

</body>
</html>