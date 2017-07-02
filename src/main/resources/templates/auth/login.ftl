<#assign pageName = "login">
<#include "../layout/default.ftl">

<#macro content>
<div class="container">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    Σύνδεση
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" method="POST">
                        <#include "../partials/csrf_token.ftl">

                        <#if error??>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="alert alert-danger alert-dismissible">${error}</div>
                                </div>
                            </div>
                        </#if>

                        <#if message??>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="alert alert-info alert-dismissible">${message}</div>
                                </div>
                            </div>
                        </#if>

                        <div class="form-group">
                            <label for="email" class="col-sm-4 control-label">Email</label>
                            <div class="col-sm-8">
                                <div class="input-group">
                                    <input type="email" class="form-control" id="email" name="email"
                                           placeholder="Email">
                                    <div class="input-group-addon">
                                        <i class="fa fa-envelope"></i>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" class="col-sm-4 control-label">Κωδικός Πρόσβασης</label>
                            <div class="col-sm-8">
                                <div class="input-group">
                                    <input type="password" class="form-control" id="password" name="password"
                                           placeholder="Κωδικός Πρόσβασης">
                                    <div class="input-group-addon">
                                        <i class="fa fa-lock"></i>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <div class="checkbox">
                                    <input type="checkbox" id="remember" name="remember" value="1">
                                    <label for="remember">
                                        Απομνημόνευση
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <button type="submit" class="btn btn-primary">Σύνδεση</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="panel-footer">
                    <p class="form-control-static">
                        Δεν έχετε λογαριασμό; <a href="/register">Εγγραφείτε εδώ.</a>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
</#macro>

<@display_page/>