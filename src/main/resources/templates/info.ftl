<#ftl output_format="HTML">
<#assign pageName = "info">
<#include "layout/default.ftl">

<#macro content>
<body xmlns="http://www.w3.org/1999/html">
    <#if currentUser?? && currentUser.id == event.providerMetadataByProviderId.userId>
    <a href="/provider_tickets/${event.id}">Δείτε τις αποδείξεις</a>
    </#if>

<div class="jumbotron_info">
    <div class="info-container">
        <div class="event-basics">
            <h1>${event.getTitle()}</h1>

            <#assign provider = event.getProviderMetadataByProviderId()>
            <#if provider.getNumberOfRatings() == 0>
                <#assign stars = 0>
            <#else>
                <#assign stars = provider.getRating()/provider.getNumberOfRatings()>
            </#if>
            <#list 1..5 as x>
                <span class='glyphicon glyphicon-star${(x > stars)?then('-empty','')}'></span>
            </#list>

            <p> ${event.getPlaceByPlaceId().getAddress()}</p>
            <h3><a href="#comment_section">Σχόλια και Αξιολογήσεις</a>

        </div>
    </div>
</div>
<div class="panel panel-success">
    <h1>Πληροφορίες</h1>
    <p>${event.getDescription()}</p>
    <p>Διαθέσιμες Θέσεις : ${event.getNumberOfTickets()}</p>
</div>

<style>
    #map-container {
        height: 300px
    }
</style>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <#if currentUser?? && currentUser.getRole()=="ROLE_PARENT">
                <div class="form-group has-feedback">
                    <form class="form-inline" method="get" action="/confirmation">
                        <input type="hidden" name="eventid" id="eventid" value="${event.getId()}">
                        <div class="form-group has-feedback">
                            <p>Αριθμός Εισιτηρίων:
                                <input type="number" min="1" max="100" title="Αριθμός Εισιτηρίων" name="point" required
                                       value="0" onchange="updateTextInput2(this.value,${event.getPrice()});">
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
<br>
<div class="comment-container" id="comment_section">
    <#if currentUser??>
        <br>
        <hr>
        <#if avatar??>
            <img src="/assets/imagedir/${currentUser.getEmail()}/${avatar}" width="50" height="50">
        <#else>
            <img src="/assets/images/defaultprof.png" width="50" height="50"/>
        </#if>
        <form action="" method="POST">
            <#include "partials/csrf_token.ftl">
            <input class="form-control" name="title" placeholder="Τίτλος" type="text"/>
            <textarea class="form-control" name="description" rows="9" cols="25"
                      required="required" placeholder="Σχόλιο"></textarea>

            <button class="btn btn-large btn-primary btn-block" type="submit">
                Post
            </button>
        </form>
    </#if>
    <hr>
    <ul class="user_comments">
        <#list event.commentsById as comment>
            <#assign user=comment.userByUserId>
            <#if user.role == "ROLE_ADMIN">
                <#assign name="Admin">
            <#elseif user.role == "ROLE_PROVIDER">
                <#assign name=user.providerMetadataById.title>
            <#elseif user.role == "ROLE_PARENT">
                <#assign name=user.parentMetadataById.firstName>
            </#if>

            <li class="user_comment clearfix">
                <div class="row">
                    <div class="col-md-3">
                        <h3>${name}</h3>
                        <p class="review_item_date">${comment.timestamp}</p>
                    </div>
                    <div class="col-md-8">
                        <div class="reviewer_review">
                            <div class="reviewer_review_container">
                                <div class="reviewer_review_header">
                                    <div class="row">
                                        <div class="col-md-7">
                                            <div class="reviewer_review_header_title">
                                                <h3>${comment.title}</h3>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="reviewer_review_content">
                                    <p>${comment.message}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </#list>
    </ul>
</div>

</#macro>

<#macro end_of_body>
<script>
        <#assign provider=event.getProviderMetadataByProviderId()>

    var count1 = ${provider.getRating()};
    var count2 = ${provider.getNumberOfRatings()};
    if (count2 === 0) {
        printStars(0, "#printstars");
    } else printStars(count1 / count2, "#printstars");

</script>
</#macro>

<@display_page/>