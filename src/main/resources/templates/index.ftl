<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="icon" href="assets/favicon.ico">
    <title>Ompampassas</title>

    <!-slick.css START-->
    <link rel="stylesheet" type="text/css" href="assets/slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="assets/slick/slick-theme.css"/>
    <!-slick.css END-->

    <script type="text/javascript">
        function initAutocomplete() {
            // Create the autocomplete object, restricting the search to geographical
            // location types.
            var autocomplete = new google.maps.places.Autocomplete(
                    /** @type {!HTMLInputElement} */(document.getElementById('gautofill')),
                    {types: ['geocode']});

            // When the user selects an address from the dropdown, populate the address
            // fields in the form.
            autocomplete.addListener('place_changed', fillInAddress);
        }
        function fillInAddress() {
            // Get the place details from the autocomplete object.
            var place = autocomplete.getPlace();
        }
    </script>
</head>

<body>
<#include "layout/defaultHeader.ftl">
<@layout>
</@layout>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <form>
            <div class="panel panel-success">
                <div class="panel-heading">Find an Event near you</div>
                <div class="panel-body">
                    <div class="form-inline">
                        <div class="form-group has-feedback">
                            <!--<label class="control-label">Search Location</label>-->
                            <input type="text" class="form-control" placeholder="Area" id="gautofill"/>
                            <i class="glyphicon glyphicon-map-marker form-control-feedback"></i>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="text" class="form-control" placeholder="Keywords"/>
                            <i class="glyphicon glyphicon-search  form-control-feedback"></i>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="date" class="form-control" name="event_date" min="2016-12-31">
                            <i class="glyphicon glyphicon-calendar form-control-feedback"></i>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="time" name="time" class="form-control" min="2016-12-31">
                            <i class="glyphicon glyphicon-hourglass form-control-feedback"></i>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="number" min="1" max="100" class="form-control" data-toggle="tooltip"
                                   title="Attendees Ages"/>
                            <i class="glyphicon glyphicon-sunglasses form-control-feedback"></i>
                        </div>
                    </div>
                    </p>
                    Area Search Radius:
                    <div class="btn" disabled>
                        <input type="range" name="rangeInput" min="0" max="100" onchange="updateTextInput(this.value);">
                        <input type="text" id="rangeArea" value="50">
                    </div>
                    <input type="submit" class="btn btn-info btn-md pull-right" value="Search Now">
                </div>
            </div>

        </form>

        <p><a class="btn btn-primary btn-lg" href="/one" role="button">See All Events &raquo;</a></p>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="slickClass slider">
        <div>
            <img src="assets/images/slider/aaa.jpg"/>
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div>
            <img src="assets/images/slider/ccc.jpg"/>
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div>
            <img src="assets/images/slider/ddd.jpg"/>
            <h2>Heading</h2>
            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula
                porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                fermentum massa justo sit amet risus.</p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div><img src="assets/images/slider/eee.jpg"/>
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div><img src="assets/images/slider/sss.jpg"/>
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div><img src="assets/images/slider/ttt.jpg"/>
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div><img src="assets/images/slider/zzz.jpg"/>
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
    </div>

    <hr>
    <footer>
        <p>&copy; 2017 Ompampassas, Inc.</p>
    </footer>
</div> <!-- /container -->

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA3WqcVF0nlc5jIAw7iAXuNT7K45wA8RVs&libraries=places&callback=initAutocomplete"
        async defer></script>


<script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="assets/slick/slick.min.js"></script>


</body>
</html>
