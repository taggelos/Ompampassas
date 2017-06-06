<#include "layout/default.ftl">


<#macro content>
<body>
<div class="jumbotron">
    <div class="info-container">
        <div class="event-basics">
            <h2>Event 1</h2>
            <p>
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star"></span>
            </p>
            <h4> Place 102,City Y</h4>
            <h4><a href="#">User comments & ratings</a>
        </div>


    </div>
</div>
<div class="panel panel-success">
    <h2>Information</h2>
    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula
        porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
        ut
        fermentum massa justo sit amet risus.</p>
</div>
<script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7/html5shiv.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.3.0/respond.js"></script>
<script src="assets/js/btn-number.js"></script>
<div class="container">


    <div class="input-group">
          <span class="input-group-btn">
              <button type="button" class="btn btn-danger btn-number" data-type="minus" data-field="quant[2]">
                <span class="glyphicon glyphicon-minus"></span>
              </button>
          </span>
        <input type="text" name="quant[2]" class="form-control input-number" value="10" min="1" max="100">
        <span class="input-group-btn">
              <button type="button" class="btn btn-success btn-number" data-type="plus" data-field="quant[2]">
                  <span class="glyphicon glyphicon-plus"></span>
              </button>
          </span>
    </div>
</div>
<style>
    #map-container {
        height: 300px;
        float: right
    }
</style>
</head>

<div id="map-container" class="col-md-6"></div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script>

    function init_map() {
        var var_location = new google.maps.LatLng(45.430817, 12.331516);

        var var_mapoptions = {
            center: var_location,
            zoom: 14
        };

        var var_marker = new google.maps.Marker({
            position: var_location,
            map: var_map,
            title: "Venice"
        });

        var var_map = new google.maps.Map(document.getElementById("map-container"),
                var_mapoptions);

        var_marker.setMap(var_map);

    }

    google.maps.event.addDomListener(window, 'load', init_map);

</script>


</#macro>

<@display_page/>