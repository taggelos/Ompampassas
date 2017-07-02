<#assign pageName = "index">
<#include "layout/default.ftl">

<#macro content>

<script type="text/javascript">
    function initAutocomplete() {
        // Create the autocomplete object, restricting the search to geographical
        // location types.
        var autocomplete = new google.maps.places.Autocomplete(
                /** @type {!HTMLInputElement} */(document.getElementById('gautofill')),
                {types: ['geocode']});

        autocomplete.addListener('place_changed', fillInAddress);
    }
    function fillInAddress() {
        // Get the place details from the autocomplete object.
        var place = autocomplete.getPlace();
    }
</script>
<script type="text/javascript">

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
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA3WqcVF0nlc5jIAw7iAXuNT7K45wA8RVs&libraries=places&callback=initAutocomplete"
        async defer></script>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
            <legend><i class="glyphicon glyphicon-globe"></i> Εκδήλωση</legend>
            <form method="Post">
                <#include "partials/csrf_token.ftl">
                <input type="text" class="form-control" name="area" placeholder="Περιοχή" id="gautofill"
                       onchange="AdressInfo();"/>
                <input class="form-control" name="place_title" placeholder="Place Title" type="text"/>
                <input class="form-control" name="title" placeholder="Όνομα Εκδήλωσης" type="text"/>
                <input class="form-control" name="category" placeholder="Κατηγορία Εκδήλωσης" type="text"/>
                <input class="form-control" id="longitude" name="longitude" value="" type="hidden"/>
                <input class="form-control" id="latitude" name="latitude" value="" type="hidden"/>
                <textarea name="description" id="Description" class="form-control" rows="9" cols="25"
                          required="required" placeholder="Περιγραφή Εκδήλωσης"></textarea>

                <label for="">Έναρξη Εκδήλωσης </label>
                <div class="form-group has-feedback">
                    <input type="datetime-local" name="start" class="form-control">
                    <i class="glyphicon glyphicon-hourglass form-control-feedback"></i>
                </div>
                <label for="">Λήξη Εκδήλωσης </label>
                <div class="form-group has-feedback">
                    <input type="datetime-local" name="end" class="form-control">
                    <i class="glyphicon glyphicon-hourglass form-control-feedback"></i>
                </div>
                <label for="">Τιμή Εισιτηρίου </label>
                <div class="form-group has-feedback">
                    <input name="price" type="number" min="1" max="500" class="form-control" data-toggle="tooltip"
                           title="Τιμή Εισιτηρίου">
                    <i class="glyphicon glyphicon-euro form-control-feedback"></i>
                </div>
                <label for="">Αριθμός Εισιτηρίων </label>
                <div class="form-group has-feedback">
                    <input name="notickets" type="number" min="1" max="10000" class="form-control" data-toggle="tooltip"
                           title="Αριθμός Εισιτηρίων">
                    <i class="glyphicon glyphicon-tags form-control-feedback " aria-hidden="true"></i>
                </div>
                <button class="btn btn-large btn-primary btn-block" type="submit">
                    Δημιουργία Εκδήλωσης
                </button>
            </form>
        </div>
    </div>
</div>
</#macro>

<@display_page/>