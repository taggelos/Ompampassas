<#ftl output_format="HTML">
<#assign pageName = "points">
<#include "layout/default.ftl">
<#macro content>

<div class="container" xmlns="http://www.w3.org/1999/html">
    <form role="form" method="post">
        <div class="row">
            <div class="col-xs-12 col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            Πληρωμή
                        </h3>
                    </div>
                    <div class="panel-body">
                        <#include "partials/csrf_token.ftl">
                        <div class="form-group">
                            <label for="cardNumber">
                                Αριθμός Κάρτας</label>
                            <#if error??>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="alert alert-danger alert-dismissible">${error}</div>
                                    </div>
                                </div>
                            </#if>
                            <div class="input-group">
                                <input type="text" class="form-control" id="cardNumber" name="cardNumber"
                                       placeholder="Αριθμός Κάρτας"
                                       required autofocus/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-5 col-md-5 ">
                                <div class="form-group">
                                    <label for="cvCode">
                                        CV CODE</label>
                                    <#if error2??>
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="alert alert-danger alert-dismissible">${error2}</div>
                                            </div>
                                        </div>
                                    </#if>
                                    <input type="password" class="form-control" id="cvvCode" name="cvvCode"
                                           placeholder="CVV"
                                           required/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <input type="hidden" name="points" id="points" value="">
                    <ul class="nav nav-pills nav-stacked">
                        <p>Αριθμός Πόντων:
                            <input type="number" min="1" max="300" title="Αριθμός Εισιτηρίων"
                                   onchange="updateTextInput3(this.value,0.5);" required>
                        </p>
                        <li class="active">
                            <a>
                                <span id="money" class="badge pull-right">0€</span>
                                Ποσό Πληρωμής</a>
                        </li>
                    </ul>
                    <br/>
                    <input type="submit" class="btn btn-success btn-lg btn-block" role="button" value="Αγορά">
                </div>
            </div>
    </form>
</div>
</#macro>

<@display_page/>