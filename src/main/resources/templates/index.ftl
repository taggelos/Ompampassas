<#ftl output_format="HTML">
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

<div class="jumbotron">
    <div class="search_bar_container">
        <form method="GET" action="/search">
            <div class="container">
                <h2 style="color: whitesmoke"><i>Αναζητήστε Δραστηριότητες</i></h2>
                <div class="panel panel-success">
                    <div class="panel-body">
                        <div class="form-group has-feedback">
                            <label for="keywordsearch" style="color: whitesmoke">Λέξεις Κλειδία:</label>
                            <input type="text" class="form-control" name="keyword" id="keywordsearch"
                                   placeholder="π.χ. Παιδότοποι"/>
                            <i class="glyphicon glyphicon-search  form-control-feedback"></i>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="datetimepicker" style="color: whitesmoke">Ημερομηνία:</label>
                            <input type="datetime-local" class="form-control" name="datetimepick"
                                   id="datetimepicker"/>
                            <i class="glyphicon glyphicon-calendar form-control-feedback"></i>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="gautofill" style="color: whitesmoke">Περιοχή:</label>
                            <input type="text" class="form-control" name="area" id="gautofill" placeholder="π.χ. Ζωγράφου"
                                   onchange="AdressInfo();"/>
                            <i class="form-control-feedback glyphicon glyphicon-map-marker "></i>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-success btn-lg pull-right" value="Αναζήτηση &raquo"/>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="container-fluid">
    <div class="well" style="text-align: center;">
        <h2 style="color: dimgrey">Δημοφιλέστεροι πάροχοι</h2>
    </div>
    <div class="slickClass slider">
        <#list attributes as info>
            <div>
                <img src="/assets/${info.getFinalPic()}"/>
                <div class="panel panel-success">
                    <h3>${info.getTitle()}</h3>
                    <div>
                        <#list 1..5 as x>
                            <span class='glyphicon glyphicon-star${(x > info.providerRating)?then('-empty','')}'></span>
                        </#list>
                    </div>
                    <h4>${info.getNumOfRatings()} ψήφοι</h4>
                    <p><a class="btn btn-default" href="/provider/${info.getProviderName()}" role="button">Δείτε Τώρα
                        &raquo;</a></p>
                </div>
            </div>
        </#list>
    </div>
</div>

</#macro>

<@display_page/>