$(document).ready(function(){
    $('#signin_button').click(function () {
        $('#messasadge').addClass('alert alert-warning').text('AXNE');
    })
})


function updateTextInput(val) {
    document.getElementById('rangeArea').value=val;
}

$(document).ready(function(){
    //language=JQuery-CSS
    $('[data-toggle="tooltip"]').tooltip();
});

//slick
$(document).ready(function(){
    $('.slickClass').slick({
        arrows: true,
        dots: true,
        autoplay:true,
        infinite: true,
        //variableWidth: true
        //centerMode: true,
        slidesToShow: 3,
        //slidesToScroll: 2
    });
});