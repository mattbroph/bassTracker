<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!-- Bootstrap Nav Bar -->
<header class="header">
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #536642">
        <div class="container-fluid">
            <a class="navbar-brand" href="#home">
                <img src="images/logo.png" class="d-inline-block align-top" alt="logo">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav ms-auto">
                    <%-- If user is not logged in, only display non user nav links --%>
                    <a href="home" class="nav-link ${lastClicked == 'Home' ? 'active' : ''}">Home</a>
                    <c:if test="${not empty user}">
                        <a href="dashboard" class="nav-link ${lastClicked == 'Dashboard' ? 'active' : ''}">Dashboard</a>
                        <a href="viewJournals" class="nav-link ${lastClicked == 'Journal' ? 'active' : ''}">Journals</a>
                        <a href="reports.jsp" class="nav-link ${lastClicked == 'Reports' ? 'active' : ''}">Reports</a>
                        <a href="viewLakes" class="nav-link ${lastClicked == 'Lakes' ? 'active' : ''}">Lakes</a>
                    </c:if>
                    <a href="about.jsp" class="nav-link ${lastClicked == 'About' ? 'active' : ''}">About</a>
                        <a href="weather" class="nav-link ${lastClicked == 'Weather' ? 'active' : ''}">Weather</a>
                    <c:if test="${not empty user}">
                        <a href="viewProfile" class="nav-link ${lastClicked == 'Profile' ? 'active' : ''}">Profile</a>
                    </c:if>
                </div>
            </div>
        </div>
    </nav>
</header>