<#assign pageName = "index">
<#include "layout/default.ftl">

<#macro content>
<!-- Main jumbotron for search area -->
<div class="jumbotron">
    <div class="search_bar_container">
        <form method="GET" action="/search">
            <div class="panel panel-success">
                <div class="panel-heading">Find an Event near you</div>
                <div class="panel-body">
                    <div class="form-inline">
                        <div class="form-group has-feedback">
                            <label for="areasearch">Area Search:</label>
                            <input type="text" class="form-control" name="area" id="areasearch"
                                   placeholder="ie Zografou"/>
                            <!--i class="form-control-feedback glyphicon glyphicon-map-marker "></i-->
                        </div>
                        <div class="form-group has-feedback">
                            <label for="keywordsearch">Keywords:</label>
                            <input type="text" class="form-control" name="keyword" id="keywordsearch"
                                   placeholder="ie Playground"/>
                            <!--i class="glyphicon glyphicon-search  form-control-feedback"></i-->
                        </div>
                        <div class="form-group has-feedback ">
                            <label for="datetimepicker">Datetime:</label>
                            <input type="datetime-local" class="form-control" name="datetimepick" id="datetimepicker"/>
                            <!--i class="glyphicon glyphicon-calendar form-control-feedback"></i-->
                        </div>
                        <!--div class="form-group has-feedback">
                            <label for="timesearch">Time:</label>
                            <input type="time" name="time" id="timesearch" class="form-control" title="Event time">
                            <!--i class="glyphicon glyphicon-hourglass form-control-feedback"></i>
                        </div-->
                        <div class="form-group has-feedback ">
                            <label for="kiattendeessearch">Kid Attendees:</label>
                            <input type="number" min="1" max="100" name="nofk" id="kiattendeessearch"
                                   class="form-control"/>
                            <!--i class="glyphicon glyphicon-sunglasses form-control-feedback"></i-->
                        </div>
                        <div class="form-group has-feedback">
                            <label for="attendeessearch">Adult Attendees:</label>
                            <input type="number" min="1" max="100" name="nofa" id="attendeessearch"
                                   class="form-control"/>
                            <!--i class="glyphicon glyphicon-sunglasses form-control-feedback"></i-->
                        </div>
                        <!--div class="form-group has-feedback">
                            <label for="radiussearch">Area Search Radius:</label>
                            <input type="range" name="rangeInput" min="0" max="100" id="radiussearch"
                                   onchange="updateTextInput(this.value);"/>
                            <input type="text" id="rangeArea" value="50" title="Area radius"/>
                        </div-->
                    </div>
                    <input type="submit" class="btn btn-success btn-lg pull-right" value="Search Now &raquo"/>
                </div>
            </div>
        </form>
        <!-- fix href -->
        <!--p><a class="btn btn-primary btn-lg" href="" role="button">See Eventents &raquo;</a></p-->
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <h2>Δημοφιλεστεροι πάροχοι:</h2>
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