<#include "layout/default.ftl">

<#macro content>
<body>
<div class="jumbotron_info">
    <div class="info-container">
        <div class="event-basics">
            <h1>Event 1</h1>
            <h2>
                <p>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                </p>
                <p> Place 102,City Y</p></h2>
                <h3><a href="#">User comments & ratings</a>

        </div>


    </div>
</div>
<div class="panel panel-success">
    <h1>Information</h1>
    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula
        porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
        ut fermentum massa justo sit amet risus Duis aute irure
        dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
        Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
</div>

<style>
    #map-container {
        height: 300px;
        float: right
    }
</style>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="form-group has-feedback">
                <form class="form-inline">
                    <div class="form-group has-feedback">
                        <p>Number of Tickets<i class="fa fa-ticket" aria-hidden="true"></i>
                        <input type="number" min="1" max="100" title="Number of Tickets"
                               onchange="updateTextInput2(this.value,3);">
                        </p>
                        <label>Price
                        <p id="tickets">0 $</p>
                        </label>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-success  btn-lg"> Make Reservation ></button>
                </form>
            </div>
        </div>
        <div class="col-md-9">
            <div id="map-container" class="col-md-9"></div>
        </div>
    </div>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script src="http://maps.google.com/maps/api/js?key=AIzaSyCnA7it801_F6RDT7TvIxTxATpEh_A9DGI&js?sensor=false"></script>
    <script>

        function init_map() {
            var var_location = new google.maps.LatLng(38.035152, 23.670934);

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
</div>

<div class="container">

</div>


</#macro>

<@display_page/>