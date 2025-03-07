"use strict";
/* THIS JS CODE WAS PROVIDED BY DATATABLES WEBSITE
*/

/* Creates the data table object */
const init = () => {

    // Initialize DataTable
    let table = new DataTable('#table', {
        scrollX: true,
        // Export feature
        layout: {
            topStart: {
                buttons: ['pageLength', 'copy','excel']
            }
        }
    });

};

/* Kicks off JS after DOM content is loaded */
document.addEventListener("DOMContentLoaded", () => {
    init();
});
