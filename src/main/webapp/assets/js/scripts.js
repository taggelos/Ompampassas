$(function () {
    initializeSlick();
    initializeChosen();
});

function initializeChosen() {
    $(".chosen-select").chosen({
        disable_search_threshold: 10,
        no_results_text: "Δε βρέθηκαν αποτελέσματα",
        placeholder_text_single: "Πληκτρολογήστε εδώ...",
        search_contains: true
    });
}

function initializeTooltips() {
    $('[data-toggle="tooltip"]').tooltip();
}

function initializeSlick() {
    $('.slickClass').slick({
        arrows: true,
        dots: true,
        autoplay: true,
        infinite: true,
        //variableWidth: true
        //centerMode: true,
        slidesToShow: 3
        //slidesToScroll: 2
    });
}

function updateTextInput(val) {
    document.getElementById('rangeArea').value = val;
}
function updateTextInput2(val, price) {
    document.getElementById('tickets').innerHTML = (val * price).toString();
}