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
            <label for="photo">Profile Picture</label>
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