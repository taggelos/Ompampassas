<#include "layout/default.ftl">

<#macro content>
<div class="container" style="background-color:lightskyblue;">
    <h1>Edit Profile</h1>
    <hr>
    <div class="row">
        <#if currentUser.getRole()=="ROLE_ADMIN">
            <div class="col-md-8">
                <a class="btn btn-primary" href="/editroles/${user.getEmail()}">Επιπλέον Τροποποιήσεις...</a>
            </div>
        </#if>
        <form class="form-horizontal" method="POST">
            <div class="col-md-9 personal-info">
                <h3>Personal info</h3>
                <#include "partials/csrf_token.ftl">
                <div class="form-group">
                    <label class="col-lg-3 control-label">First name:</label>
                    <div class="col-lg-8">
                        <input class="form-control" type="text" name="name" value="${user.getName()}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Last name:</label>
                    <div class="col-lg-8">
                        <input class="form-control" type="text" name="surname" value="${user.getSurname()}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Email:</label>
                    <div class="col-lg-8">
                        <input class="form-control" type="text" name="email" value="${user.getEmail()}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Password:</label>
                    <div class="col-md-8">
                        <input class="form-control" type="password" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Confirm password:</label>
                    <div class="col-md-8">
                        <input class="form-control" type="password" name="conf_password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        <input type="submit" class="btn btn-primary" value="Save Changes">
                        <span></span>
                        <input type="reset" class="btn btn-default" value="Cancel">
                    </div>
                </div>
        </form>
    </div>
</div>
</div>
<hr>
</#macro>

<@display_page/>