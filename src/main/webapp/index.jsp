
<!DOCTYPE html>

<html lang="en">
<head>
    <title>Bass Tracker</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <link rel="stylesheet" href="css/main.css">
    <!-- Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- ChartJS -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <!-- JavaScript -->
    <script src="js/dashboard.js"></script>

</head>

<body>
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
                <a href="#home" class="nav-link">Home</a>
                <a href="#aboutMe" class="nav-link">Journals</a>
                <a href="#skillsTables" class="nav-link">Reports</a>
                <a href="#personalProjects" class="nav-link">Lakes</a>
                <a href="#contactMe" class="nav-link">About</a>
                <a href="#profile" class="nav-link">Profile</a>
            </div>
        </div>
    </nav>
</header>

<main id="mainContent">

    <h1>Matt's 2025 Dashboard</h1>
    <br>
    <br>

    <!-- Bass Goal Donut -->
    <div id="bassGoalContainer">
        <!-- TODO Hardcoded need to update -->
        <h2>Number of Bass</h2>
        <p>100 of 150</p>
        <canvas id="bassGoalDonut">
        </canvas>
    </div>


</main>

<!-- Footer -->
<footer>
    <a href="#top"><img src="images/arrow-up.svg" alt="Back to top" id="backToTop"><br/>Back to top</a>
    <br><br>
    <img src="images/logo.png" alt="Bass Tracker Logo">
    <br>
    <span>Bass Tracker &#169; 2025</span>
</footer>

<!-- BootStrap -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>