<#include "layout/default.ftl">

<#macro content>
    <div class="search-container">

        <div class="row">
            <div class="col-md-3">
                <div class="filter-container">
                    <h2>Filters</h2>
                    <div class="panel panel-search-primary">
                        <div class="panel-heading">Δραστηριοτητες</div>
                        <div class="panel-body">
                            <div class="activity-checkbox-filter">
                                <input type="checkbox" /> This is checkbox <br />
                                <input type="checkbox" /> This is checkbox <br />
                                <input type="checkbox" /> This is checkbox <br />
                                <input type="checkbox" /> This is checkbox <br />
                                <input type="checkbox" /> This is checkbox <br />
                                <input type="checkbox" /> This is checkbox <br />
                                <input type="checkbox" /> This is checkbox <br />
                                <input type="checkbox" /> This is checkbox <br />
                                <input type="checkbox" /> This is checkbox <br />
                                <input type="checkbox" /> This is checkbox <br />
                            </div>
                        </div>
                        <div class="panel-heading">Ημερομηνια & Ωρα</div>
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
                        <div class="panel-heading">Αξιολογησεις</div>
                        <div class="panel-body">
                            <div class="rating-radio-filter">
                                <form>
                                    <input type="radio" name="rating" value="4"> τουλάχιστον 4 αστέρια <br>
                                    <input type="radio" name="rating" value="3"> τουλάχιστον 3 αστέρια <br>
                                    <input type="radio" name="rating" value="2"> τουλάχιστον 2 αστέρια <br>
                                </form>
                            </div>
                        </div>
                        <div class="panel-heading">Ευρος Τιμής</div>
                        <div class="panel-body">
                            <form class="form-inline">
                                <div class="Price-filter-form-group">
                                    <input type="text" class="form-control" id="price-min" placeholder="Από" name="price-min">
                                </div>
                                <div class="Price-filter-form-group">
                                    <input type="text" class="form-control" id="price-max" placeholder="Εως" name="price-max">
                                </div>
                                <button type="submit" class="btn btn-default-Price-filter"> > </button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

            <div class="sortby-container">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort By
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Price(Lower First)</a></li>
                        <li><a href="#">Price(Higher First)</a></li>
                        <li><a href="#">Rating</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-9">
                <div class="results-search-container1">
                    <div class="items-in-list">
                        <div class="thumbnail">
                            <img src="assets/images/www.jpg">
                            <div class="caption">
                                <h4 class="pull-right">$24.99</h4>
                                <h4><a href="#">First Product</a>
                                </h4>
                                <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit ,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua .</p>
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

            <div class="col-md-9">
                <div class="results-search-container2">
                    <div class="items-in-list">
                        <div class="thumbnail">
                            <img src="assets/images/www.jpg">
                            <div class="caption">
                                <h4 class="pull-right">$24.99</h4>
                                <h4><a href="#">First Product</a>
                                </h4>
                                <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit ,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua .</p>
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

            <div class="col-md-9">
                <div class="results-search-container3">
                    <div class="items-in-list">
                        <div class="thumbnail">
                            <img src="assets/images/www.jpg">
                            <div class="caption">
                                <h4 class="pull-right">$24.99</h4>
                                <h4><a href="#">First Product</a>
                                </h4>
                                <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit ,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua .</p>
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

        </div>
    </div>

</#macro>

<@display_page/>
