<#include "layout/default.ftl">

<#macro content>
<!-- Main jumbotron for search area -->
<div class="jumbotron">
    <div class="container">
        <form method="POST">
            <#include "partials/csrf_token.ftl">
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
    <#if registered??>
        <div class="row">
            <div class="col-sm-12">
                <div class="alert alert-success">
                    You have successfully registered! Have fun!
                </div>
            </div>
        </div>
    </#if>

    <!-- Example row of columns -->
    <div class="slickClass slider">
        <div>
            <img src="assets/images/slider/aaa.jpg"/>
            <div class="panel panel-success">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
                    mauris
                    condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                    euismod. Donec sed odio dui. </p>
                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
        </div>
        <div>
            <img src="assets/images/slider/ccc.jpg"/>
            <div class="panel panel-success">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
                    mauris
                    condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                    euismod. Donec sed odio dui. </p>
                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
        </div>
        <div>
            <img src="assets/images/slider/ddd.jpg"/>
            <div class="panel panel-success">
                <h2>Heading</h2>
                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula
                    porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
                    ut
                    fermentum massa justo sit amet risus.</p>
                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
        </div>
        <div><img src="assets/images/slider/eee.jpg"/>
            <div class="panel panel-success">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
                    mauris
                    condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                    euismod. Donec sed odio dui. </p>
                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
        </div>
        <div><img src="assets/images/slider/sss.jpg"/>
            <div class="panel panel-success">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
                    mauris
                    condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                    euismod. Donec sed odio dui. </p>
                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
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
</div>
</#macro>

<@display_page/>