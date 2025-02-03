/*
*
*/
const init = () => {

    console.log("hey der world");
    buildBassCountDonut();

}

/*
*/
const buildBassCountDonut = () => {

    // TODO will have to get this data from the DB somehow (hardcoded for now) 
    // Declare variables
    let current = 100;
    let goal = 150;
    let remaining;

    // Define "remaining" goal value
    if (current >= goal) {
        remaining = 0;
    } else {
        remaining = goal - current;
    }

    // Define the data for the donut
    const data = {
        labels: ['Current', 'Remaining'],
        datasets: [{
            label: 'Bass Goal',
            data: [current, remaining],
            backgroundColor: [
                '#536642', // Yellow
                '#F6D86B'  // Green
            ],
            hoverOffset: 4
        }]
    };

    // Define the chart configuration
    const config = {
        type: 'doughnut',
        data: data,
    };

    // Create a new Chart instance
    const ctx = document.getElementById('bassGoalDonut').getContext('2d');
    const bassGoalDonut = new Chart(ctx, config);


}

/* Kicks off JS after DOM content is loaded */
document.addEventListener("DOMContentLoaded", () => {
    init();
});




