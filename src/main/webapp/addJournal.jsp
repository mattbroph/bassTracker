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

    <h1>Add a Journal Entry</h1>

    <c:choose>

        <c:when test="${empty userLakes}">
            <p id="message">You currently have no active lakes available.<br>
                To submit a journal entry, please visit the "Lakes" section, where you can add a new lake or activate an existing one.<br>
                Once you've done that, return here to submit your journal entry.</p>
        </c:when>

        <c:otherwise>
            <form action="actionAddJournal"
                  method="post">

                <fieldset>
                    <legend>Fishing Details</legend>
                    <!-- Date -->
                    <label for="date">*Date</label>
                    <input type="date"
                           name="date"
                           id="date"
                           required>
                    <br>
                    <!-- Lake -->
                    <label for="lake">*Lake</label>
                    <select name="lake" id="lake">
                        <option value="" selected disabled>Select an option</option>
                        <%-- Populate the user active lake options --%>
                        <c:forEach var="lake" items="${userLakes}">
                            <option value="${lake.id}">${lake.lakeName}</option>
                        </c:forEach>
                    </select>
                    <br>

                    <!-- Hours Fished -->
                    <label for="hoursFished">*Hours Fished</label>
                    <input type="number"
                           name="hoursFished"
                           id="hoursFished"
                           step="0.25"
                           min="0"
                           required>
                    <br>
                    <!-- Fishing Method -->
                    <label for="fishingMethod">*Fishing Method</label>
                    <select name="fishingMethod" id="fishingMethod" required>
                        <option value="" selected disabled>Select an option</option>
                        <c:forEach var="method" items="${methodList}">
                            <option value="${method.id}">${method.methodName}</option>
                        </c:forEach>
                    </select>
                </fieldset>

                <fieldset>
                    <legend>Fishing Conditions</legend>
                    <!-- Air Temp -->
                    <label for="airTemp">*Air Temp</label>
                    <input type="number"
                           name="airTemp"
                           id="airTemp"
                           required>
                    <br>
                    <!-- Weather -->
                    <label for="weather">*Weather</label>
                    <select name="weather" id="weather" required>
                        <option value="" selected disabled>Select an option</option>
                        <c:forEach var="weather" items="${weatherList}">
                            <option value="${weather.id}">${weather.weatherType}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <!-- Wind -->
                    <label for="wind">*Wind</label>
                    <select name="wind" id="wind" required>
                        <option value="" selected disabled>Select an option</option>
                        <c:forEach var="wind" items="${windList}">
                            <option value="${wind.id}">${wind.windType}</option>
                        </c:forEach>
                    </select>
                </fieldset>

                <fieldset>
                    <legend>Bass counts</legend>
                    <!-- Bass Count Fields -->
                    <div id="bassCountFields">
                        <div id="smallMouthFields">
                            <label for="sm-14-16">*Small Mouth 14"-16"</label>
                            <input type="number"
                                   name="sm-14-16"
                                   id="sm-14-16"
                                   value="0"
                                   min="0"
                                   required>
                            <br>
                            <label for="sm-16-19">*Small Mouth 16"-19"</label>
                            <input type="number"
                                   name="sm-16-19"
                                   id="sm-16-19"
                                   value="0"
                                   min="0"
                                   required>
                            <br>
                            <label for="sm-19-plus">*Small Mouth Bass 19"+</label>
                            <input type="number"
                                   name="sm-19-plus"
                                   id="sm-19-plus"
                                   value="0"
                                   min="0"
                                   required>
                            <br>
                        </div>
                        <div id="largeMouthFields">
                            <label for="lm-14-16">*Large Mouth 14"-16"</label>
                            <input type="number"
                                   name="lm-14-16"
                                   id="lm-14-16"
                                   value="0"
                                   min="0"
                                   required>
                            <br>
                            <label for="lm-16-19">*Large Mouth 16"-19"</label>
                            <input type="number"
                                   name="lm-16-19"
                                   id="lm-16-19"
                                   value="0"
                                   min="0"
                                   required>
                            <br>
                            <label for="lm-19-plus">*Large Mouth 19"+</label>
                            <input type="number"
                                   name="lm-19-plus"
                                   id="lm-19-plus"
                                   value="0"
                                   min="0"
                                   required>
                            <br>
                        </div>
                    </div>
                </fieldset>

                <fieldset>
                        <legend>Optional Data</legend>
                    <!-- Comments -->
                    <label for="comments">Comments</label>
                    <textarea name="comments"
                              id="comments"
                              placeholder="enter comments here"></textarea>
                    <br>
                    <!-- Photo -->
                    <label for="photo">Photo of the day</label>
                    <input type="text"
                           name="photo"
                           placeholder="enter URL here"
                           id="photo">
                    <br>
                </fieldset>
                <!-- Button fields -->
                <div id="buttonContainer">
                    <input type="submit" value="Add Journal">
                    <a href="viewJournals" class="cancelButton">Cancel</a>
                </div>
            </form>
        </c:otherwise>
    </c:choose>

    <br>
    <br>
</main>
<c:import url="footer.jsp" />
</body>
</html>