<html>
<!-- Bootstrap Nav Bar -->
<header class="header">
    <nav class="navbar navbar-expand-lg navbar-dark"
         style="background-color: #536642">

        <a class="navbar-brand" href="#home">
            <img src="images/logo.png"
                 class="d-inline-block align-top" alt="logo">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav ml-auto">
<%--               TODO Use id="active" to underscore--%>
                <a href="index.jsp" class="nav-link">Home</a>
                <a href="dashboard" class="nav-link">Dashboard</a>
                <a href="viewJournals" class="nav-link">Journals</a>
                <a href="reports.jsp" class="nav-link">Reports</a>
                <a href="viewLakes.jsp" class="nav-link">Lakes</a>
                <a href="about.jsp" class="nav-link">About</a>
                <a href="profile.jsp" class="nav-link">Profile</a>
            </div>
        </div>
    </nav>
</header>