<#assign pageName = "provider">
<#include "layout/default.ftl">

<#macro content>

<div class="panel panel-success">
    <h1>${provider.getCompanyName()}</h1>
    <div class="container">
        <#if currentUser?? && currentUser.getRole()=="ROLE_PARENT">
            <form method="POST" action="#">
                <#include "partials/csrf_token.ftl">

                <div class="row">
                    <h2>Αξιολόγηση:</h2>
                </div>
                <input type="hidden" id="inputstars" name="stars" value="">
                <div class="row lead">
                    <div id="stars" class="starrr"></div>
                    Η Αξιολόγηση σας: <span id="count">0</span> αστέρια
                </div>

                <input type="submit" class="btn btn-primary" value="Υποβολή Αξιολόγησης">
            </form>
        </#if>
    </div>
</div>

<h2>Εκδηλώσεις</h2>
<div class="container">
    <#list events as ev>
        <div class="col-md-9">
            <div class="results-search-container2">
                <div class="items-in-list">
                    <div class="thumbnail">
                        <img src="/assets/images/www.jpg">
                        <div class="caption">
                            <h4 class="pull-right">${ev.getPrice()} Πόντοι</h4>
                            <h4><a href="/info/${ev.getTitle()}">${ev.getTitle()}</a></h4>
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