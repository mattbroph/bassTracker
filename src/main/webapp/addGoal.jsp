<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<!-- JavaScript -->
<script src="js/dashboard.js"></script>
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/forms.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Add a Bass Goal</h1>

    <form action="actionAddGoal"
          method="post">

        <fieldset>
            <legend>Bass Goal</legend>
            <!-- Year -->
            <label for="year">*Year</label>
            <input type="number"
                   name="year"
                   id="year"
                   min="2020"
                   max="2050"
                   step="1"
                   required>
            <!-- Bass Goal -->
            <label for="bassGoal">*Goal</label>
            <input type="number"
                   name="bassGoal"
                   id="bassGoal"
                   min="0"
                   step="1"
                   required>
            <br>
        </fieldset>
        <br>
        <!-- Button fields -->
        <div id="buttonContainer">
            <input type="submit" value="Add Goal">
            <a href="viewProfile" class="cancelButton">Cancel</a>
        </div>
    </form>
    <br>
    <br>
</main>
<c:import url="footer.jsp" />
</body>
</html>