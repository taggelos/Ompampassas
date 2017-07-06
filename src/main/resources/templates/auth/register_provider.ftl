<#ftl output_format="HTML">
<#assign pageName = "register">
<#include "../layout/default.ftl">

<#macro content>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    Εγγραφή Παρόχου
                </div>
                <div class="panel-body">
                    <#assign registerType = "provider">
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

                                <div class="form-group">
                                    <label for="companyName" class="col-sm-4 control-label">Επωνυμία Εταιρείας</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="companyName" name="companyName"
                                               placeholder="Επωνυμία Εταιρείας"
                                               maxlength="255" value="${registerForm.getCompanyName()!""}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="vatNumber" class="col-sm-4 control-label">ΑΦΜ</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="vatNumber" name="vatNumber"
                                               placeholder="ΑΦΜ"
                                               maxlength="20" value="${registerForm.getVatNumber()!""}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="taxOfficeId" class="col-sm-4 control-label">ΔΟΥ</label>
                                    <div class="col-sm-8">
                                        <select name="taxOfficeId" id="taxOfficeId" class="form-control chosen-select">
                                            <option value=""></option>
                                            <#list taxOffices as taxOffice>
                                                <option value="${taxOffice.getId()?c}" ${(registerForm.getTaxOfficeId() == taxOffice.getId())?then("selected","")}>
                                                ${taxOffice.getName()}
                                                </option>
                                            </#list>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <legend>Στοιχεία Επικοινωνίας</legend>

                                <div class="form-group">
                                    <label for="phone" class="col-sm-4 control-label">Τηλέφωνο</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="phone" name="phone"
                                               placeholder="Τηλέφωνο"
                                               maxlength="255" value="${registerForm.getPhone()!""}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="fax" class="col-sm-4 control-label">Fax</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="fax" name="fax"
                                               placeholder="Fax"
                                               maxlength="255" value="${registerForm.getFax()!""}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="address" class="col-sm-4 control-label">Διεύθυνση</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="address" name="address"
                                               placeholder="Διεύθυνση"
                                               maxlength="255" value="${registerForm.getAddress()!""}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="zipCode" class="col-sm-4 control-label">Ταχυδρομικός Κώδικας</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="zipCode" name="zipCode"
                                               placeholder="Ταχυδρομικός Κώδικας"
                                               maxlength="20" value="${registerForm.getZipCode()!""}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="region" class="col-sm-4 control-label">Περιοχή</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="region" name="region"
                                               placeholder="Περιοχή"
                                               maxlength="255" value="${registerForm.getRegion()!""}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="city" class="col-sm-4 control-label">Πόλη</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="city" name="city"
                                               placeholder="Πόλη"
                                               maxlength="255" value="${registerForm.getCity()!""}">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <div class="pull-right">
                                    <button type="submit" class="g-recaptcha btn btn-primary"
                                            data-sitekey="6LccsCcUAAAAAM6rPRzEQShJxJOVd5GqQYFV8XvK"
                                            data-callback='onSubmit'>Εγγραφή
                                    </button>
                                </div>
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