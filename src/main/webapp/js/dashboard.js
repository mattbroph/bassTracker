/* Kicks off processes to build dashboard graphs
*/
const init = () => {

    buildBassGoalDonut();
    buildBassSizeCount();
    buildTripChart();
    buildCatchChart();

}

/* Builds the bass goal donut and displays it to the browser
*/
const buildBassGoalDonut = () => {

    let bassGoalDiv = document.getElementById("bassGoalContainer");
    let bassGoal = parseInt(bassGoalDiv.getAttribute("data-bassGoal"));
    let currentBassCount = parseInt(bassGoalDiv.getAttribute("data-currentBassCount"));

    let remaining;

    // Define "remaining" goal value
    if (currentBassCount >= bassGoal) {
        remaining = 0;
    } else {
        remaining = bassGoal - currentBassCount;
    }

    // Define the data for the donut
    const data = {
        labels: ['Current', 'Remaining'],
        datasets: [{
            label: 'Bass Goal',
            data: [currentBassCount, remaining],
            backgroundColor: [
                '#536642', // Green
                '#F6D86B'  // Yellow
            ],
            hoverOffset: 4
        }]
    };

    // Define the chart configuration
    const config = {
        type: 'doughnut',
        data: data,
    };

    // Build and display the chart
    const ctx = document.getElementById('bassGoalDonut').getContext('2d');
    const bassGoalDonut = new Chart(ctx, config);

}

/* Builds the bass size count donut
*/
const buildBassSizeCount = () => {

    let bassSizeDiv = document.getElementById("bassSizeContainer");
    let smallMouth1416 = parseInt(bassSizeDiv.getAttribute("data-sm1416"));
    let smallMouth1619 = parseInt(bassSizeDiv.getAttribute("data-sm1619"));
    let smallMouth19Plus = parseInt(bassSizeDiv.getAttribute("data-sm19Plus"));
    let largeMouth1416 = parseInt(bassSizeDiv.getAttribute("data-lm1416"));
    let largeMouth1619 = parseInt(bassSizeDiv.getAttribute("data-lm1619"));
    let largeMouth19Plus = parseInt(bassSizeDiv.getAttribute("data-lm19Plus"));

    // Define the data for the chart
    const data = {
        labels: [
            'SM 14"-16"',
            'SM 16"-19"',
            'SM 19"+',
            'LM 14"-16"',
            'LM 16"-19"',
            'LM 19"+'
        ],
        datasets: [{
            label: 'Count',
            data: [smallMouth1416, smallMouth1619, smallMouth19Plus, largeMouth1416,
                    largeMouth1619, largeMouth19Plus],
            backgroundColor: [
                '#F8E089',
                '#F6D86B',
                '#D0B556',
                '#718162',
                '#536642',
                '#425235'
            ]
        }]
    };

    // Define the chart config
    const config = {
        type: 'polarArea',
        data: data,
        options: {}
    };

    // Render the chart
    const ctx = document.getElementById('bassSizeDonut').getContext('2d');
    const bassSizeDonut = new Chart(ctx, config);
}


/* Builds the trip history chart
*/
const buildTripChart = () => {

    // Define the y-axis data for the chart
    let bassSizeDiv = document.getElementById("tripChartContainer");
    let januaryTrips = parseInt(bassSizeDiv.getAttribute("data-month-1"));
    let februaryTrips = parseInt(bassSizeDiv.getAttribute("data-month-2"));
    let marchTrips = parseInt(bassSizeDiv.getAttribute("data-month-3"));
    let aprilTrips = parseInt(bassSizeDiv.getAttribute("data-month-4"));
    let mayTrips = parseInt(bassSizeDiv.getAttribute("data-month-5"));
    let juneTrips = parseInt(bassSizeDiv.getAttribute("data-month-6"));
    let julyTrips = parseInt(bassSizeDiv.getAttribute("data-month-7"));
    let augustTrips = parseInt(bassSizeDiv.getAttribute("data-month-8"));
    let septemberTrips = parseInt(bassSizeDiv.getAttribute("data-month-9"));
    let octoberTrips = parseInt(bassSizeDiv.getAttribute("data-month-10"));
    let novemberTrips = parseInt(bassSizeDiv.getAttribute("data-month-11"));
    let decemberTrips = parseInt(bassSizeDiv.getAttribute("data-month-12"));

    // Define the x-axis data for the chart
    const labels = ['Jan', 'Feb', 'Mar', 'Apr', 'May',
        'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];

    const data = {
        labels: labels,
        datasets: [{
            label: '# of Trips',
            data: [januaryTrips, februaryTrips, marchTrips, aprilTrips, mayTrips,
                    juneTrips, julyTrips, augustTrips, septemberTrips, octoberTrips,
                    novemberTrips, decemberTrips],
            backgroundColor: [
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82'
            ],
            borderColor: [
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82',
                '#8F9C82'
            ],
            borderWidth: .25
        }]
    };


    const config = {
        type: 'bar',
        data: data,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        },
    };

    // Render the chart
    const ctx = document.getElementById('tripChart').getContext('2d'); // Get canvas context
    const myChart = new Chart(ctx, config); // Create a new Chart instance

}


/**
 * Builds the catch history chart
 */
const buildCatchChart = () => {

    // Define the y-axis data for the chart
    let bassSizeDiv = document.getElementById("catchChartContainer");
    let januaryCatch = parseInt(bassSizeDiv.getAttribute("data-month-1"));
    let februaryCatch = parseInt(bassSizeDiv.getAttribute("data-month-2"));
    let marchCatch = parseInt(bassSizeDiv.getAttribute("data-month-3"));
    let aprilCatch = parseInt(bassSizeDiv.getAttribute("data-month-4"));
    let mayCatch = parseInt(bassSizeDiv.getAttribute("data-month-5"));
    let juneCatch = parseInt(bassSizeDiv.getAttribute("data-month-6"));
    let julyCatch = parseInt(bassSizeDiv.getAttribute("data-month-7"));
    let augustCatch = parseInt(bassSizeDiv.getAttribute("data-month-8"));
    let septemberCatch = parseInt(bassSizeDiv.getAttribute("data-month-9"));
    let octoberCatch = parseInt(bassSizeDiv.getAttribute("data-month-10"));
    let novemberCatch = parseInt(bassSizeDiv.getAttribute("data-month-11"));
    let decemberCatch = parseInt(bassSizeDiv.getAttribute("data-month-12"));
    let monthlyCatchGoal = parseInt(bassSizeDiv.getAttribute("data-monthly-catch-goal"));

    // Define the data for the chart
    const data = {
        labels: [
            'Jan',
            'Feb',
            'Mar',
            'Apr',
            'May',
            'Jun',
            'Jul',
            'Aug',
            'Sep',
            'Oct',
            'Nov',
            'Dec'
        ],
        datasets: [{
            type: 'line',
            label: 'Monthly Goal',
            data: [monthlyCatchGoal, monthlyCatchGoal, monthlyCatchGoal, monthlyCatchGoal,
                monthlyCatchGoal, monthlyCatchGoal, monthlyCatchGoal, monthlyCatchGoal,
                monthlyCatchGoal, monthlyCatchGoal, monthlyCatchGoal, monthlyCatchGoal],
            fill: false,
            borderColor: '#0a0a0a',
            borderWidth: .25
        }, {
            type: 'bar',
            label: 'Catch Count',
            data: [januaryCatch, februaryCatch, marchCatch, aprilCatch, mayCatch,
                    juneCatch, julyCatch, augustCatch, septemberCatch, octoberCatch,
                    novemberCatch, decemberCatch],
            borderColor: '#F8E089',
            backgroundColor: '#F8E089',
            borderWidth: .25
        }]
    };


    const config = {
        type: 'scatter',
        data: data,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    };

    // Render the chart
    const ctx = document.getElementById('catchChart').getContext('2d');
    const catchChart = new Chart(ctx, config);


}


/* Kicks off JS after DOM content is loaded */
document.addEventListener("DOMContentLoaded", () => {
    init();
});




