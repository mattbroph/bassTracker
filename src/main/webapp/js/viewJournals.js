"use strict";
/* THIS JS CODE WAS PROVIDED BY DATATABLES WEBSITE
*/

/* Creates the data table object */
const init = () => {
    let minDate, maxDate;

    // Initialize the date inputs
    minDate = new DateTime('#min', {
        format: 'YYYY-MM-DD'
    });
    maxDate = new DateTime('#max', {
        format: 'YYYY-MM-DD'
    });

    // Initialize DataTable
    let table = new DataTable('#journalsTable', {
        scrollX: true
    });

    // Custom filtering function which will search data in the Date column (index 1)
    DataTable.ext.search.push(function (settings, data, dataIndex) {
        let min = minDate.val();
        let max = maxDate.val();
        let rawDate = data[1].trim(); // Ensure clean string
        let date = new Date(rawDate);

        if (isNaN(date)) return false; // Skip invalid dates

        // Convert min/max to Date objects, treating empty values as null
        min = min && min !== "" ? new Date(min) : null;
        max = max && max !== "" ? new Date(max) : null;

        // Add 1 day to max date to make it inclusive
        if (max) {
            max.setDate(max.getDate() + 1);
        }

        return (
            (min === null && max === null) ||  // Show all if both are empty
            (min === null && date < max) ||
            (min <= date && max === null) ||
            (min <= date && date < max)
        );
    });

    // Refilter the table when date inputs change
    document.querySelectorAll('#min, #max').forEach((el) => {
        el.addEventListener('change', () => {
            table.draw();
        });
    });
};



/* Kicks off JS after DOM content is loaded */
document.addEventListener("DOMContentLoaded", () => {
    init();
});
