<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/forms.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Edit ${user.firstName}'s Profile</h1>

    <%-- Hibernate validator messages. See ActionEditProfile servlet --%>
    <c:if test="${errorMessages != null}">
        <c:forEach var="error" items="${errorMessages}">
            <p class="message">${error}</p>
        </c:forEach>
        <c:remove var="errorMessages" scope="session" />
    </c:if>

    <form name="editProfile"
          action="actionEditProfile"
          method="post">

        <fieldset>
            <legend>Profile Details</legend>

            <!-- First Name -->
            <label for="firstName">*First Name</label>
            <input type="text"
                   name="firstName"
                   id="firstName"
                   value="${user.firstName}"
                   required>
            <br>
            <!-- Last Name -->
            <label for="lastName">*Last Name</label>
            <input type="text"
                   name="lastName"
                   id="lastName"
                   value="${user.lastName}"
                   required>
            <br>
            <!-- Profile Picture -->
            <div class="toolTipDiv">
                <label for="photo">Profile Picture</label>
                    <div class="tooltip-container">
                        <img src="images/toolTip.svg" alt="tooltip" class="tooltip-icon">
                        <!-- Tool Tip Text-->
                        <span class="tooltip-text">
                            <span class="bold">Upload your photo to a free image hosting site.</span><br>
                            <ol>
                                <li>Sign up / login to <a href="https://postimages.org/" target="_blank" rel="noopener noreferrer">PostImages</a></li>
                                <li>Upload your photo</li>
                                <li>Click 'Share'</li>
                                <li>Copy the 'Direct Link' URL</li>
                                <li>Paste the URL here</li>
                            </ol>
                        </span>
                    </div>
            </div>
            <input type="text"
                   name="photo"
                   placeholder="enter URL here"
                   id="photo"
                   value="${user.profilePicture}">
        </fieldset>
        <br>
        <!-- Button fields -->
        <div id="buttonContainer">
            <input type="submit" value="Edit Profile">
            <a href="viewProfile" class="cancelButton">Cancel</a>
        </div>
    </form>


</main>
<c:import url="footer.jsp" />

</body>
</html>