<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<!-- JavaScript -->
<%--<script src="js/dashboard.js"></script>--%>
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/forms.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Add a Journal Entry</h1>

    <%-- Hibernate validator messages. See ActionAddJournal Servlet --%>
    <c:if test="${errorMessages != null}">
        <c:forEach var="error" items="${errorMessages}">
            <p class="message">${error}</p>
        </c:forEach>
        <c:remove var="errorMessages" scope="session" />
    </c:if>

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
                           value="0"
                           min="0"
                           max="24"
                           required>
                    <br>
                    <!-- Fishing Method -->
                    <label for="fishingMethod">*Fishing Method</label>
                    <select name="fishingMethod" id="fishingMethod" required>
                        <c:forEach var="method" items="${methodList}">
                            <option value="${method.id}">${method.methodName}</option>
                        </c:forEach>
                    </select>
                </fieldset>

                <fieldset>
                    <legend>Fishing Conditions</legend>
                    <a href="weather" target="_blank">Forgot the weather?</a>
                    <br>
                    <br>
                    <!-- Air Temp -->
                    <label for="airTemp">*Air Temp &#8457;</label>
                    <input type="number"
                           name="airTemp"
                           id="airTemp"
                           min="-100"
                           max="200"
                           required>
                    <br>
                    <!-- Weather -->
                    <label for="weather">*Weather</label>
                    <select name="weather" id="weather" required>
                        <c:forEach var="weatherItem" items="${weatherList}">
                            <option value="${weatherItem.id}">${weatherItem.weatherType}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <!-- Wind -->
                    <label for="wind">*Wind</label>
                    <select name="wind" id="wind" required>
                        <c:forEach var="windItem" items="${windList}">
                            <option value="${windItem.id}">${windItem.windType}</option>
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
                                   max="100"
                                   required>
                            <br>
                            <label for="sm-16-19">*Small Mouth 16"-19"</label>
                            <input type="number"
                                   name="sm-16-19"
                                   id="sm-16-19"
                                   value="0"
                                   min="0"
                                   max="100"
                                   required>
                            <br>
                            <label for="sm-19-plus">*Small Mouth Bass 19"+</label>
                            <input type="number"
                                   name="sm-19-plus"
                                   id="sm-19-plus"
                                   value="0"
                                   min="0"
                                   max="100"
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
                                   max="100"
                                   required>
                            <br>
                            <label for="lm-16-19">*Large Mouth 16"-19"</label>
                            <input type="number"
                                   name="lm-16-19"
                                   id="lm-16-19"
                                   value="0"
                                   min="0"
                                   max="100"
                                   required>
                            <br>
                            <label for="lm-19-plus">*Large Mouth 19"+</label>
                            <input type="number"
                                   name="lm-19-plus"
                                   id="lm-19-plus"
                                   value="0"
                                   min="0"
                                   max="100"
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
                              maxlength="1000"
                              placeholder="enter comments here"></textarea>
                    <br>
                    <!-- Photo -->
                    <div class="toolTipDiv">
                        <label for="photo">Photo of the day</label>
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
                           maxlength="255"
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