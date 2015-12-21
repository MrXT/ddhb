// This file contain some small javascript functions
// require for Open Cafe to work.

// Following function is used in sidebar nav menu
$(document).ready(function () {
    if ($("#LoadData").length > 0) {
        $("#LoadData").bonegrid({
            url: $("#LoadData").attr("dataUrl")
        });
    }  
});