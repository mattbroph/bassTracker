/* Kicks off processes to build dashboard graphs
*/
const init = () => {

    console.log("hey der world");
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
            data: [11, 16, 7, 3, 14, 15],
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

    // Define the data for the chart
    const labels = ['Jan', 'Feb', 'Mar', 'Apr', 'May',
        'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];

    const data = {
        labels: labels,
        datasets: [{
            label: '# of Trips',
            data: [10, 5, 7, 30, 25, 40, 55, 35, 15, 25, 32, 40],
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
            data: [20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20],
            fill: false,
            borderColor: '#0a0a0a',
            borderWidth: .25
        }, {
            type: 'bar',
            label: 'Catch Count',
            data: [10, 20, 30, 32, 12, 20, 30, 40, 10, 20, 30, 10],
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




