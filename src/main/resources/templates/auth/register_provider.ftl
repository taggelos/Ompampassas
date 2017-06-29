<#include "../layout/default.ftl">

<#macro content>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-primary">
            <div class="panel-heading">
                Εγγραφή Παρόχου
            </div>
            <div class="panel-body">
                <#assign registerType = "provider">
                <#include "../partials/register_picker.ftl">

                <form class="form-horizontal" method="POST">
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

                    <div class="row">
                        <div class="col-sm-6">
                            <legend>Στοιχεία Επιχείρησης</legend>

                            <div class="form-group">
                                <label for="title" class="col-sm-4 control-label">Εμφανιζόμενο Όνομα</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="title" name="title"
                                           placeholder="Εμφανιζόμενο Όνομα"
                                           maxlength="255" value="${registerForm.getTitle()!""}">
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <legend>Στοιχεία Επικοινωνίας</legend>

                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-8">
                            <button type="submit" class="btn btn-primary">Εγγραφή</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="panel-footer">
                <p class="form-control-static">
                    Έχετε ήδη λογαριασμό; <a href="/login">Συνδεθείτε εδώ.</a>
                </p>
            </div>
        </div>
    </div>
</div>
</#macro>

<@display_page/>