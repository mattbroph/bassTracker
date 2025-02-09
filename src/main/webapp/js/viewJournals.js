/* Creates the data table object
*/
const init = () => {

    new DataTable('#journalsTable', {
        scrollX: true
    });


}

/* Kicks off JS after DOM content is loaded */
document.addEventListener("DOMContentLoaded", () => {
    init();
});
