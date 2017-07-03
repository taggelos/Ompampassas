<#assign pageName = "info">
<#include "layout/default.ftl">

<#macro content>
<body xmlns="http://www.w3.org/1999/html">
<div class="jumbotron_info">
    <div class="info-container">
        <div class="event-basics">
            <h1>${event.getTitle()}</h1>

            <script>
                printStars(${event.getProviderMetadataByProviderId().getRating()}, ${event.getProviderMetadataByProviderId().getNumberOfRatings()});
            </script>

            <p> ${event.getPlaceByPlaceId().getAddress()}</p>
            <h3><a href="#comment_section">Σχόλια και Αξιολογήσεις</a>

        </div>
    </div>
</div>
<div class="panel panel-success">
    <h1>Πληροφορίες</h1>
    <p>${event.getDescription()}</p>
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
            <#if currentUser.getRole()=="ROLE_PARENT">
                <div class="form-group has-feedback">
                    <form class="form-inline" method="get" action="/confirmation">
                        <div class="form-group has-feedback">
                            <p>Αριθμός Εισιτηρίων:
                                <input type="number" min="1" max="100" title="Αριθμός Εισιτηρίων"
                                       onchange="updateTextInput2(this.value,${event.getPrice()});">
                            </p>
                            <label>Τιμή Εισιτηρίων:
                                <p id="tickets">0 πόντοι</p>
                            </label>
                        </div>
                        <br>
                        <button type="submit" class="btn btn-success  btn-lg"> Δημιουργία Κράτησης &raquo</button>
                    </form>
                </div>
            </#if>
        </div>
        <div class="col-md-9">
            <div id="map-container" class="col-md-9"></div>
        </div>
    </div>


    <script src="https://maps.google.com/maps/api/js?key=AIzaSyCnA7it801_F6RDT7TvIxTxATpEh_A9DGI&js?sensor=false"></script>
    <script>

        function init_map() {

            var long =${event.getPlaceByPlaceId().getLongitude()};
            var lat =${event.getPlaceByPlaceId().getLatitude()};
            var var_location = new google.maps.LatLng(lat, long);

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

<div class="comment-container" id="comment_section">
    <ul class="user_comments">
        <li class="user_comment clearfix">
            <div class="row">
                <div class="col-md-3">
                    <h3>Username</h3>
                    <p class="review_item_date">2 Ιουνιου 2017</p>
                </div>
                <div class="col-md-8">
                    <div class="reviewer_review">
                        <div class="reviewer_review_container">
                            <div class="reviewer_review_header">
                                <div class="row">
                                    <div class="col-md-3">
                                        <p>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                        </p>
                                    </div>
                                    <div class="col-md-7">
                                        <div class="reviewer_review_header_title">
                                            Excellent!
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="reviewer_review_content">
                                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="user_comment clearfix">
            <div class="row">
                <div class="col-md-3">
                    <h3>Username</h3>
                    <p class="review_item_date">1 Ιουνιου 2017</p>
                </div>
                <div class="col-md-8">
                    <div class="reviewer_review">
                        <div class="reviewer_review_container">
                            <div class="reviewer_review_header">
                                <div class="row">
                                    <div class="col-md-3">
                                        <p>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                        </p>
                                    </div>
                                    <div class="col-md-7">
                                        <div class="reviewer_review_header_title">
                                            Excellent!
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="reviewer_review_content">
                                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="user_comment clearfix">
            <div class="row">
                <div class="col-md-3">
                    <h3>Username</h3>
                    <p class="review_item_date">4 Ιουνιου 2017</p>
                </div>
                <div class="col-md-8">
                    <div class="reviewer_review">
                        <div class="reviewer_review_container">
                            <div class="reviewer_review_header">
                                <div class="row">
                                    <div class="col-md-3">
                                        <p>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                        </p>
                                    </div>
                                    <div class="col-md-7">
                                        <div class="reviewer_review_header_title">
                                            Mediocre!
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="reviewer_review_content">
                                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </li>
    </ul>


</div>


</#macro>

<@display_page/>