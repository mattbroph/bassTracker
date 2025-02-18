<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<!-- JavaScript -->
<script src="js/dashboard.js"></script>
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/journal.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Edit Journal: ${journal.journalDate} | ${journal.lake.lakeName}</h1>
    <br>
    <form action="#"
          method="post">
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
                    <option value="${lake.id}">${lake.lakeName}</option>
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
        <br>
        <!-- Air Temp -->
        <label for="airTemp">*Air Temp</label>
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
        <br>
        <!-- Bass Count Fields -->
        <div id="bassCountFields">
            <div id="smallMouthFields">
                <label for="sm-14-16">*Small Mouth 14"-16"</label>
                <input type="number"
                       name="sm-14-16"
                       id="sm-14-16"
                       value="${journal.smallMouth1416}"
                       required>
                <br>
                <label for="sm-16-18">*Small Mouth 16"-19"</label>
                <input type="number"
                       name="sm-16-18"
                       id="sm-16-18"
                       value="${journal.smallMouth1619}"
                       required>
                <br>
                <label for="sm-19-plus">*Small Mouth Bass 19"+</label>
                <input type="number"
                       name="sm-19-plus"
                       id="sm-19-plus"
                       value="${journal.smallMouth19Plus}"
                       required>
                <br>
            </div>
            <div id="largeMouthFields">
                <label for="lg-14-16">*Large Mouth 14"-16"</label>
                <input type="number"
                       name="lg-14-16"
                       id="lg-14-16"
                       value="${journal.largeMouth1416}"
                       required>
                <br>
                <label for="lg-16-18">*Large Mouth 16"-19"</label>
                <input type="number"
                       name="lg-16-18"
                       id="lg-16-18"
                       value="${journal.largeMouth1619}"
                       required>
                <br>
                <label for="lg-19-plus">*Large Mouth 19"+</label>
                <input type="number"
                       name="lg-19-plus"
                       id="lg-19-plus"
                       value="${journal.largeMouth19Plus}"
                       required>
                <br>
            </div>
        </div>
        <!-- Comments -->
        <label for="comments">Comments</label>
        <textarea name="comments"
                  id="comments"
                  placeholder="${journal.comments}"></textarea>
        <br>
        <!-- Photo -->
        <label for="photo">Photo of the day</label>
        <input type="text"
               name="photo"
               placeholder="${journal.imageURL}"
               id="photo">
        <br>
        <br>

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