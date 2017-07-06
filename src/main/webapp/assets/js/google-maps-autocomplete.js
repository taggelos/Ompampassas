function initAutocomplete() {
    // Create the autocomplete object, restricting the search to geographical
    // location types.
    var autocomplete = new google.maps.places.Autocomplete(
        /** @type {!HTMLInputElement} */(document.getElementById('gautofill')),
        {types: ['geocode']});

    // When the user selects an address from the dropdown, populate the address
    // fields in the form.
    autocomplete.addListener('place_changed', function () {
        // Get the place details from the autocomplete object.
        var place = autocomplete.getPlace();
    });
}

function AdressInfo() {
    var geocoder = new google.maps.Geocoder();
    var address = document.getElementById('gautofill').value;
    geocoder.geocode({'address': address}, function (results, status) {
        if (status === google.maps.GeocoderStatus.OK) {
            var latitude = results[0].geometry.location.lat();
            var longitude = results[0].geometry.location.lng();
            document.getElementById('longitude').value = longitude;
            document.getElementById('latitude').value = latitude;
        }
    });
}
