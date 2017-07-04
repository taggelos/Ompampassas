<#ftl output_format="HTML">
<#assign pageName = "search">
<#include "layout/default.ftl">

<#macro content>
<div class="search-container">

<div class="row">
    <div class="col-md-3">
        <div class="filter-container">
            <h2>Φίλτρα</h2>
            <div class="panel panel-search-primary">
                <div class="panel-heading">Δραστηριότητες</div>
                <div class="panel-body">
                    <div class="activity-checkbox-filter">
                        <input type="checkbox"/> This is checkbox <br/>
                        <input type="checkbox"/> This is checkbox <br/>
                        <input type="checkbox"/> This is checkbox <br/>
                        <input type="checkbox"/> This is checkbox <br/>
                        <input type="checkbox"/> This is checkbox <br/>
                        <input type="checkbox"/> This is checkbox <br/>
                        <input type="checkbox"/> This is checkbox <br/>
                        <input type="checkbox"/> This is checkbox <br/>
                        <input type="checkbox"/> This is checkbox <br/>
                        <input type="checkbox"/> This is checkbox <br/>
                    </div>
                </div>
                <div class="panel-heading">Ημερομηνία & Ώρα</div>
                <div class="panel-body">
                    <div class="Date-filter">
                        <input type="date" class="form-control" name="event_date" min="2016-12-31">
                        <i class="glyphicon glyphicon-calendar form-control-feedback"></i>
                    </div>
                    <div class="Time-filter">
                        <input type="time" name="time" class="form-control" min="2016-12-31">
                        <i class="glyphicon glyphicon-hourglass form-control-feedback"></i>
                    </div>
                </div>
                <div class="panel-heading">Αξιολογήσεις</div>
                <div class="panel-body">
                    <div class="rating-radio-filter">
                        <form>
                            <input type="radio" name="rating" value="4"> τουλάχιστον 4 αστέρια <br>
                            <input type="radio" name="rating" value="3"> τουλάχιστον 3 αστέρια <br>
                            <input type="radio" name="rating" value="2"> τουλάχιστον 2 αστέρια <br>
                        </form>
                    </div>
                </div>
                <div class="panel-heading">Εύρος Τιμής</div>
                <div class="panel-body">
                    <form class="form-inline">
                        <div class="Price-filter-form-group">
                            <input type="text" class="form-control" id="price-min" placeholder="Από" name="price-min">
                        </div>
                        <div class="Price-filter-form-group">
                            <input type="text" class="form-control" id="price-max" placeholder="Έως" name="price-max">
                        </div>
                        <button type="submit" class="btn btn-default-Price-filter"> ></button>
                    </form>
                </div>

            </div>
        </div>
    </div>

    <div class="sortby-container">
        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Ταξινόμηση Κατά
                <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="#">Τιμή(Χαμηλότερα πρώτα)</a></li>
                <li><a href="#">Τιμή(Υψηλότερα πρώτα)</a></li>
                <li><a href="#">Αξιολόγηση</a></li>
            </ul>
        </div>
    </div>

    <#list events as ev>
        <div class="col-md-9">
            <div class="results-search-container2">
                <div class="items-in-list">
                    <div class="thumbnail">
                        <img src="/assets/images/www.jpg">
                        <div class="caption">
                            <a href="/provider/${ev.getProviderMetadataByProviderId().getUserByUserId().getEmail()}">${ev.getProviderMetadataByProviderId().getCompanyName()}</a>
                            <h4 class="pull-right">${ev.getPrice()} euro</h4>
                            <h4><a href="/info/${ev.getId()}">${ev.getTitle()}</a></h4>
                            <p>${ev.getDescription()}.</p>
                        </div>
                        <div class="ratings">
                            <p class="pull-right">15 reviews</p>
                            <p>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#list>

</#macro>

<@display_page/>
