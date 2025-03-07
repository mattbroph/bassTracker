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

    <h1>${user.firstName}'s Bass Goal</h1>

    <form name="actionEditGoal"
          action="actionEditGoal"
          method="post">

        <fieldset>
            <legend>Bass Goal | ${bassGoal.goalYear}</legend>

            <!-- Bass Goal -->
            <label for="bassGoal">*${bassGoal.goalYear} Goal</label>
            <input type="number"
                   name="bassGoal"
                   id="bassGoal"
                   min="0"
                   step="1"
                   value="${bassGoal.goalCount}"
                   required>
            <br>
        </fieldset>

        <%-- Hidden field to provide goal id to doPost method  --%>
        <input type="hidden" name="goalId" value="${bassGoal.id}">

        <br>
        <!-- Button fields -->
        <div id="buttonContainer">
            <input type="submit" value="Edit Goal">
            <a href="viewProfile" class="cancelButton">Cancel</a>
        </div>
    </form>


</main>
<c:import url="footer.jsp" />

</body>
</html>