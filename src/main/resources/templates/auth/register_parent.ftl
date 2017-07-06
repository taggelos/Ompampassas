<#ftl output_format="HTML">
<#assign pageName = "register">
<#include "../layout/default.ftl">

<#macro content>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    Εγγραφή Γονέα
                </div>
                <div class="panel-body">
                    <#assign registerType = "parent">
                    <#include "../partials/register_picker.ftl">

                    <form id='secure-form' class="form-horizontal" method="POST">
                        <#include "../partials/message_container.ftl">

                        <#include "../partials/csrf_token.ftl">

                        <div class="form-group">
                            <label for="email" class="col-sm-4 control-label">Email</label>
                            <div class="col-sm-8">
                                <div class="input-group">
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email"
                                           maxlength="255" value="${registerForm.getEmail()!""}">
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
                                           placeholder="Κωδικός Πρόσβασης" value="${registerForm.getPassword()!""}">
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
                                           placeholder="Επιβεβαίωση Κωδικού Πρόσβασης"
                                           value="${registerForm.getPasswordConfirmation()!""}">
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
                                       maxlength="255" value="${registerForm.getName()!""}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="surname" class="col-sm-4 control-label">Επώνυμο</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="surname" name="surname" placeholder="Επώνυμο"
                                       maxlength="255" value="${registerForm.getSurname()!""}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="phone" class="col-sm-4 control-label">Τηλέφωνο Επικοινωνίας</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="phone" name="phone"
                                       placeholder="Τηλέφωνο Επικοινωνίας"
                                       maxlength="255" value="${registerForm.getPhone()!""}">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <button type="submit" class="g-recaptcha btn btn-primary"
                                        data-sitekey="6LccsCcUAAAAAM6rPRzEQShJxJOVd5GqQYFV8XvK"
                                        data-callback='onSubmit'>Εγγραφή
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="panel-footer">
                    <p class="form-control-static">
                        Έχετε ήδη λογαριασμό; <a href="login">Συνδεθείτε εδώ.</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>

<@display_page/>