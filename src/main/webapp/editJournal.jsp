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

    <h1>Edit Journal: ${journal.journalDate} | ${journal.lake.lakeName}</h1>
    <br>
    <form action="actionEditJournal"
          method="post">
        <fieldset>
            <legend>Fishing Details</legend>
            <!-- Date -->
            <label for="date">*Date</label>
            <input type="date"
                   name="date"
                   id="date"
                   value="${journal.journalDate}"
                   required>
            <br>
            <!-- Lake -->
            <label for="lake">*Lake</label>
            <select name="lake" id="lake">
            <c:forEach var="lake" items="${userLakes}">
                <c:choose>
                    <c:when test="${lake.id == journal.lake.id}">
                        <option value="${lake.id}" selected>${lake.lakeName}</option>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${lake.isActive}">
                            <option value="${lake.id}">${lake.lakeName}</option>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            </select>
            <br>

            <!-- Hours Fished -->
            <label for="hoursFished">*Hours Fished</label>
            <input type="number"
                   name="hoursFished"
                   id="hoursFished"
                   value="${journal.hours}"
                   step="0.25"
                   min="0"
                   required>
            <br>
            <!-- Fishing Method -->
            <label for="fishingMethod">*Fishing Method</label>
            <select name="fishingMethod" id="fishingMethod" required>
                <c:forEach var="method" items="${methodList}">
                    <c:choose>
                        <c:when test="${method.id == journal.method.id}">
                            <option value="${method.id}" selected>${method.methodName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${method.id}">${method.methodName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </fieldset>

        <fieldset>
            <legend>Fishing Conditions</legend>
            <!-- Air Temp -->
            <label for="airTemp">*Air Temp &#8457;</label>
            <input type="number"
                   name="airTemp"
                   id="airTemp"
                   value="${journal.airTemp}"
                   required>
            <br>
            <!-- Weather -->
            <label for="weather">*Weather</label>
            <select name="weather" id="weather" required>
                <c:forEach var="weather" items="${weatherList}">
                    <c:choose>
                        <c:when test="${weather.id == journal.weather.id}">
                            <option value="${weather.id}" selected>${weather.weatherType}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${weather.id}">${weather.weatherType}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <br>
            <!-- Wind -->
            <label for="wind">*Wind</label>
            <select name="wind" id="wind" required>
                <c:forEach var="wind" items="${windList}">
                    <c:choose>
                        <c:when test="${wind.id == journal.wind.id}">
                            <option value="${wind.id}" selected>${wind.windType}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${wind.id}">${wind.windType}</option>
                        </c:otherwise>
                    </c:choose>
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
                           value="${journal.smallMouth1416}"
                           min="0"
                           required>
                    <br>
                    <label for="sm-16-19">*Small Mouth 16"-19"</label>
                    <input type="number"
                           name="sm-16-19"
                           id="sm-16-19"
                           value="${journal.smallMouth1619}"
                           min="0"
                           required>
                    <br>
                    <label for="sm-19-plus">*Small Mouth Bass 19"+</label>
                    <input type="number"
                           name="sm-19-plus"
                           id="sm-19-plus"
                           value="${journal.smallMouth19Plus}"
                           min="0"
                           required>
                    <br>
                </div>
                <div id="largeMouthFields">
                    <label for="lm-14-16">*Large Mouth 14"-16"</label>
                    <input type="number"
                           name="lm-14-16"
                           id="lm-14-16"
                           value="${journal.largeMouth1416}"
                           min="0"
                           required>
                    <br>
                    <label for="lm-16-19">*Large Mouth 16"-19"</label>
                    <input type="number"
                           name="lm-16-19"
                           id="lm-16-19"
                           value="${journal.largeMouth1619}"
                           min="0"
                           required>
                    <br>
                    <label for="lm-19-plus">*Large Mouth 19"+</label>
                    <input type="number"
                           name="lm-19-plus"
                           id="lm-19-plus"
                           value="${journal.largeMouth19Plus}"
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
                      id="comments">${journal.comments}</textarea>
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
                   value="${journal.imageURL}"
                   id="photo">
            <br>
        </fieldset>

        <%-- Hidden field to provide journal id to doPost method  --%>
        <input type="hidden" name="journalId" value="${journal.id}">

        <!-- Button fields -->
        <div id="buttonContainer">
            <input type="submit" value="Edit Journal">
            <a href="viewJournals" class="cancelButton">Cancel</a>
        </div>
    </form>
    <br>
    <br>
</main>
<c:import url="footer.jsp" />
</body>
</html>