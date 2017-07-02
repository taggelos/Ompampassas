<#include "layout/default.ftl">

<#macro content>

<div class="panel panel-success">
    <h1>${provider.getCompanyName()}</h1>
</div>

<div class="container">
    <#list events as ev>
        <div class="col-md-9">
            <div class="results-search-container2">
                <div class="items-in-list">
                    <div class="thumbnail">
                        <img src="/assets/images/www.jpg">
                        <div class="caption">
                            <h4 class="pull-right">${ev.getPrice()} euro</h4>
                            <h4><a href="#">${ev.getTitle()}</a></h4>
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

</div>


</#macro>

<@display_page/>