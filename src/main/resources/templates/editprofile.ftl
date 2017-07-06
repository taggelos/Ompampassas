<#ftl output_format="HTML">
<#assign pageName = "profile">
<#include "layout/default.ftl">

<#macro content>
<div class="container">
    <h1>Αλλαγή Στοιχείων</h1>
    <hr>

    <#if message??>
        <div class="row">
            <div class="col-sm-12">
                <div class="alert alert-success alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert"
                            aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    ${message}
                </div>
            </div>
        </div>
    </#if>

    <#if currentUser.getRole()=="ROLE_ADMIN">
        <div class="row">
            <div class="col-md-12">
                <a class="btn btn-primary" href="editroles/${user.getEmail()}">Επιπλέον Τροποποιήσεις...</a>
            </div>
        </div>
    </#if>

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    Στοιχεία Προφίλ
                </div>
                <div class="panel-body">
                    <#include "partials/message_container.ftl">

                    <div class="row">
                        <div class="col-md-12">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label for="email" class="col-sm-4 control-label">Email</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <input type="email" class="form-control" id="email" name="email"
                                                   placeholder="Email"
                                                   maxlength="255" value="${user.getEmail()!""}" disabled>
                                            <div class="input-group-addon">
                                                <i class="fa fa-envelope"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <#if user.getRole() == "ROLE_PARENT">
                        <form class="form-horizontal" method="POST" action="editprofile/${user.getEmail()}/parent">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <button type="submit" class="btn btn-primary pull-right">
                                        <i class="fa fa-save"></i> Αποθήκευση
                                    </button>
                                </div>
                            </div>

                            <#include "partials/csrf_token.ftl">
                            <div class="row">
                                <div class="col-md-12">

                                    <legend>Στοιχεία Προφίλ</legend>

                                    <div class="form-group">
                                        <label for="name" class="col-sm-4 control-label">Όνομα</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="name" name="name"
                                                   placeholder="Όνομα"
                                                   maxlength="255" value="${form.getName()!""}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="surname" class="col-sm-4 control-label">Επώνυμο</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="surname" name="surname"
                                                   placeholder="Επώνυμο"
                                                   maxlength="255" value="${form.getSurname()!""}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="phone" class="col-sm-4 control-label">Τηλέφωνο
                                            Επικοινωνίας</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="phone" name="phone"
                                                   placeholder="Τηλέφωνο Επικοινωνίας"
                                                   maxlength="255" value="${form.getPhone()!""}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    <#elseif user.getRole() == "ROLE_PROVIDER">
                        <form class="form-horizontal" method="POST"
                              action="editprofile/${user.getEmail()}/provider">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <button type="submit" class="btn btn-primary pull-right">
                                        <i class="fa fa-save"></i> Αποθήκευση
                                    </button>
                                </div>
                            </div>

                            <#include "partials/csrf_token.ftl">
                            <div class="row">
                                <div class="col-md-12">
                                    <legend>Στοιχεία Επιχείρησης</legend>

                                    <div class="form-group">
                                        <label for="companyName" class="col-sm-4 control-label">Επωνυμία
                                            Εταιρείας</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="companyName"
                                                   value="${metadata.getCompanyName()!""}" disabled>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="vatNumber" class="col-sm-4 control-label">ΑΦΜ</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="vatNumber"
                                                   value="${metadata.getVatNumber()!""}" disabled>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="taxOfficeId" class="col-sm-4 control-label">ΔΟΥ</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="taxOfficeId"
                                                   value="${metadata.getTaxOfficeByTaxOfficeId().getName()!""}"
                                                   disabled>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="title" class="col-sm-4 control-label">Εμφανιζόμενο Όνομα</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="title" name="title"
                                                   placeholder="Εμφανιζόμενο Όνομα"
                                                   maxlength="255" value="${form.getTitle()!""}">
                                        </div>
                                    </div>

                                    <legend>Στοιχεία Επικοινωνίας</legend>

                                    <div class="form-group">
                                        <label for="phone" class="col-sm-4 control-label">Τηλέφωνο</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="phone" name="phone"
                                                   placeholder="Τηλέφωνο"
                                                   maxlength="255" value="${form.getPhone()!""}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="fax" class="col-sm-4 control-label">Fax</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="fax" name="fax"
                                                   placeholder="Fax"
                                                   maxlength="255" value="${form.getFax()!""}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="address" class="col-sm-4 control-label">Διεύθυνση</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="address" name="address"
                                                   placeholder="Διεύθυνση"
                                                   maxlength="255" value="${form.getAddress()!""}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="zipCode" class="col-sm-4 control-label">Ταχυδρομικός
                                            Κώδικας</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="zipCode" name="zipCode"
                                                   placeholder="Ταχυδρομικός Κώδικας"
                                                   maxlength="20" value="${form.getZipCode()!""}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="region" class="col-sm-4 control-label">Περιοχή</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="region" name="region"
                                                   placeholder="Περιοχή"
                                                   maxlength="255" value="${form.getRegion()!""}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="city" class="col-sm-4 control-label">Πόλη</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="city" name="city"
                                                   placeholder="Πόλη"
                                                   maxlength="255" value="${form.getCity()!""}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </#if>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    Αλλαγή Κωδικού Πρόσβασης
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" method="POST"
                          action="profile/change_password/${user.getEmail()}">
                        <#if passwordErrors??>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="alert alert-danger alert-dismissible" role="alert">
                                        <button type="button" class="close" data-dismiss="alert"
                                                aria-label="Close"><span
                                                aria-hidden="true">&times;</span></button>
                                        <ul>
                                            <#list passwordErrors as error>
                                                <li>${error}</li>
                                            </#list>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </#if>

                        <div class="form-group">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary pull-right">
                                    <i class="fa fa-save"></i> Αποθήκευση
                                </button>
                            </div>
                        </div>

                        <#include "partials/csrf_token.ftl">

                        <div class="row">
                            <div class="col-md-12">
                                <#if currentUser.getId() == user.getId()>
                                    <div class="form-group">
                                        <label for="oldPassword" class="col-sm-4 control-label">Παλαιός Κωδικός
                                            Πρόσβασης</label>
                                        <div class="col-sm-8">
                                            <div class="input-group">
                                                <input type="password" class="form-control" id="oldPassword"
                                                       name="oldPassword"
                                                       placeholder="Παλαιός Κωδικός Πρόσβασης">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-lock"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </#if>

                                <div class="form-group">
                                    <label for="newPassword" class="col-sm-4 control-label">Νέος Κωδικός
                                        Πρόσβασης</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <input type="password" class="form-control" id="newPassword"
                                                   name="newPassword"
                                                   placeholder="Νέος Κωδικός Πρόσβασης">
                                            <div class="input-group-addon">
                                                <i class="fa fa-lock"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="newPasswordConfirmation" class="col-sm-4 control-label">Επιβεβαίωση
                                        Νέου Κωδικού Πρόσβασης</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <input type="password" class="form-control" id="newPasswordConfirmation"
                                                   name="newPasswordConfirmation"
                                                   placeholder="Επιβεβαίωση Νέου Κωδικού Πρόσβασης">
                                            <div class="input-group-addon">
                                                <i class="fa fa-lock"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>

<@display_page/>