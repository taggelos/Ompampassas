<#include "../layout/default.ftl">

<#macro content>
<div class="container" xmlns="http://www.w3.org/1999/html">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">

                <ul class="nav nav-tabs form-tabs">
                    <li id="basic-list" class="active"><a data-toggle="tab" href="#form1">Parent</a>

                    </li>
                    <li class="" id="team_details-list"><a data-toggle="tab" href="#form2">Provider</a>

                    </li>
                </ul>

                <div class="panel-body">
                    <div class="tab-content">
                        <fieldset id="form1" class="tab-pane active">
                            <form class="form-signin" id="form-signin-parent" method="POST">
                                <#include "../partials/message_container.ftl">
                                <#include "../partials/csrf_token.ftl">
                                <div class="input-group">
                                    <label for="email" class="sr-only">Email</label>
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email"
                                           maxlength="255" value="${registerForm.getEmail()!""}">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="password" class="sr-only">Κωδικός Πρόσβασης</label>
                                    <input type="password" class="form-control" id="password" name="password"
                                           placeholder="Κωδικός Πρόσβασης" value="${registerForm.getPassword()!""}">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                </div>

                                <div class="input-group">
                                    <label for="passwordConfirmation" class="sr-only">Επιβεβαίωση Κωδικού
                                        Πρόσβασης</label>
                                    <input type="password" class="form-control" id="passwordConfirmation"
                                           name="passwordConfirmation"
                                           placeholder="Επιβεβαίωση Κωδικού Πρόσβασης"
                                           value="${registerForm.getPasswordConfirmation()!""}">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="name" class="sr-only">Όνομα</label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="Όνομα"
                                           maxlength="255" value="${registerForm.getName()!""}">
                                </div>
                                <div class="input-group">
                                    <label for="surname" class="sr-only">Επώνυμο</label>
                                    <input type="text" class="form-control" id="surname" name="surname"
                                           placeholder="Επώνυμο"
                                           maxlength="255" value="${registerForm.getSurname()!""}">
                                </div>
                                </br>
                                <div class="alert alert-warning alert-dismissable fade in">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Warning!</strong> This alert box could indicate a warning that might need
                                    attention.
                                </div>
                                <button id="signin_button" class="btn btn-md btn-warning" type="submit">Εγγραφή</button>
                            </form>
                            </br>
                            <div class="panel-footer">
                                <p class="form-control-static">
                                    Έχετε ήδη λογαριασμό; <a href="/login">Συνδεθείτε εδώ.</a>
                                </p>
                            </div>
                        </fieldset>
                        <fieldset id="form2" class="tab-pane ">
                            <form class="form-signin" id="form-signin-provider" method="POST">
                                <#include "../partials/message_container.ftl">
                                <#include "../partials/csrf_token.ftl">
                                <div class="input-group">
                                    <label for="email" class="sr-only">Email</label>
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email"
                                           maxlength="255" value="${registerForm.getEmail()!""}">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="password" class="sr-only">Κωδικός Πρόσβασης</label>
                                    <input type="password" class="form-control" id="password" name="password"
                                           placeholder="Κωδικός Πρόσβασης" value="${registerForm.getPassword()!""}">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                </div>

                                <div class="input-group">
                                    <label for="passwordConfirmation" class="sr-only">Επιβεβαίωση Κωδικού
                                        Πρόσβασης</label>
                                    <input type="password" class="form-control" id="passwordConfirmation"
                                           name="passwordConfirmation"
                                           placeholder="Επιβεβαίωση Κωδικού Πρόσβασης"
                                           value="${registerForm.getPasswordConfirmation()!""}">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="name" class="sr-only">Όνομα</label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="Όνομα"
                                           maxlength="255" value="${registerForm.getName()!""}">
                                </div>
                                <div class="input-group">
                                    <label for="surname" class="sr-only">Επώνυμο</label>
                                    <input type="text" class="form-control" id="surname" name="surname"
                                           placeholder="Επώνυμο"
                                           maxlength="255" value="${registerForm.getSurname()!""}">
                                </div>
                                </br>
                                <div class="alert alert-warning alert-dismissable fade in">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Warning!</strong> This alert box could indicate a warning that might need
                                    attention.
                                </div>
                                <button id="signin_button" class="btn btn-md btn-warning" type="submit">Εγγραφή</button>
                            </form>
                            </br>
                            <div class="panel-footer">
                                <p class="form-control-static">
                                    Έχετε ήδη λογαριασμό; <a href="/login">Συνδεθείτε εδώ.</a>
                                </p>
                            </div>
                        </fieldset>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>

<@display_page/>