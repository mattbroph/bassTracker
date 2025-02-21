/* Kicks off processes to build dashboard graphs
*/
const init = () => {
    buildBassSizeCount();
}


/* Builds the bass size count donut
*/
const buildBassSizeCount = () => {

    // Get the values from data-attribute fields
    let dataDiv = document.getElementById("bassSizeContainer");
    let smallMouth1416 = parseInt(dataDiv.getAttribute("data-sm1416"));
    let smallMouth1619 = parseInt(dataDiv.getAttribute("data-sm1619"));
    let smallMouth19Plus = parseInt(dataDiv.getAttribute("data-sm19Plus"));
    let largeMouth1416 = parseInt(dataDiv.getAttribute("data-lm1416"));
    let largeMouth1619 = parseInt(dataDiv.getAttribute("data-lm1619"));
    let largeMouth19Plus = parseInt(dataDiv.getAttribute("data-lm19Plus"));




    // Define the data for the chart
    const data = {
        labels: [
            'Small Mouth 14"-16"',
            'Small Mouth 16"-19"',
            'Small Mouth 19"+',
            'Large Mouth 14"-16"',
            'Large Mouth 16"-19"',
            'Large Mouth 19"+'
        ],
        datasets: [{
            label: 'Count',
            data: [smallMouth1416, smallMouth1619, smallMouth19Plus,
                largeMouth1416, largeMouth1619, largeMouth19Plus],
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

/* Kicks off JS after DOM content is loaded */
document.addEventListener("DOMContentLoaded", () => {
    init();
});




