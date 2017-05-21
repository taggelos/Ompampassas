<#include "layout/default.ftl">

<#macro content>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="panel panel-primary">
            <div class="panel-heading">
                Εγγραφή
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method="POST">
                    <#include "partials/message_container.ftl">

                    <#include "partials/csrf_token.ftl">

                    <div class="form-group">
                        <label for="email" class="col-sm-4 control-label">Email</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <input type="email" class="form-control" id="email" name="email" placeholder="Email"
                                       maxlength="255" value="${signupForm.getEmail()!""}">
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
                        <label for="passwordConfirmation" class="col-sm-4 control-label">Επιβεβαίωση Κωδικού
                            Πρόσβασης</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <input type="password" class="form-control" id="passwordConfirmation"
                                       name="passwordConfirmation"
                                       placeholder="Επιβεβαίωση Κωδικού Πρόσβασης">
                                <div class="input-group-addon">
                                    <i class="fa fa-lock"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="name" class="col-sm-4 control-label">Όνομα</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Όνομα"
                                   maxlength="255" value="${signupForm.getName()!""}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="surname" class="col-sm-4 control-label">Επώνυμο</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="surname" name="surname" placeholder="Επώνυμο"
                                   maxlength="255" value="${signupForm.getSurname()!""}">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-8">
                            <button type="submit" class="btn btn-primary">Εγγραφή</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="col-md-2"></div>
</div>
</#macro>

<@display_page/>