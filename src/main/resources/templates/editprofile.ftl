<#ftl output_format="HTML">
<#assign pageName = "profile">
<#include "layout/default.ftl">

<#macro content>
    <#if user?? && currentUser?? && (currentUser.getEmail() == user.getEmail() || currentUser.getRole() == "ROLE_ADMIN")>
<div class="container" style="background-color:lightskyblue;">
    <h1>Αλλαγή Στοιχείων</h1>
    <hr>
    <div class="row">
        <#if currentUser.getRole()=="ROLE_ADMIN">
            <div class="col-md-8">
                <a class="btn btn-primary" href="/editroles/${user.getEmail()}">Επιπλέον Τροποποιήσεις...</a>
            </div>
        </#if>
        <form class="form-horizontal" method="POST">
            <#include "partials/csrf_token.ftl">
            <div class="col-md-9 personal-info">
                <h3>Στοιχεία Προφίλ</h3>
            <#--
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Όνομα: </label>
                                <div class="col-lg-8">
                                    <input class="form-control" type="text" name="name" value="${user.getName()}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Επώνυμο: </label>
                                <div class="col-lg-8">
                                    <input class="form-control" type="text" name="surname" value="${user.getSurname()}">
                                </div>
                            </div>
            -->
                <div class="form-group">
                    <label class="col-lg-3 control-label">Email: </label>
                    <div class="col-lg-8">
                        <input class="form-control" type="text" name="email" value="${user.getEmail()}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Κωδικός Πρόσβασης: </label>
                    <div class="col-md-8">
                        <input class="form-control" type="password" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Επιβεβαίωση Κωδικού: </label>
                    <div class="col-md-8">
                        <input class="form-control" type="password" name="conf_password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        <input type="submit" class="btn btn-primary" value="Αποθήκευση Αλλαγών">
                        <span></span>
                        <input type="reset" class="btn btn-default" value="Ακύρωση">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<hr>
    </#if>
</#macro>

<@display_page/>