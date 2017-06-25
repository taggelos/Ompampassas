<#include "layout/default.ftl">

<#macro content>
    <#if user?? && (currentUser.getEmail() == user.getEmail() || currentUser.getRole() == "ROLE_ADMIN")>
<body class="mybody">
<div class="container">
    <h1>My Profile</h1>
    <hr>
    <div class="row">
        <div class="col-md-3">
            <div class="text-center">
            <#--img src="//placehold.it/100" class="avatar img-circle" alt="avatar"-->
                <#assign x = "avatar">
                <#if x??>
                    <img src="/assets/imagedir/${user.getEmail()}/${x}" style="width: 100%; height: auto;"/>
                <#else>
                    <img src="/assets/images/defaultprof.png" style="width: 100%; height: auto;"/>
                </#if>
                <h6>Upload a different photo...</h6>
                <h6>Press Shift+f5 to reload</h6>
                <form method="POST" enctype="multipart/form-data" action="/uploadpic/${user.getEmail()}">
                    <#include "partials/csrf_token.ftl">
                    <table>
                        <tr>
                            <td></td>
                            <td>
                                <p>
                                    <input class="btn btn-warning" id="fileInput" type="file" name="uploadingImgs"
                                           multiple>
                                </p>
                                <p>
                                    <input class="btn btn-warning" type="submit" value="Upload NOW">
                                </p>
                            </td>
                        </tr>
                    </table>
                </form>
                <#if x??>
                    <form method="POST" enctype="multipart/form-data" action="/deletepic">
                        <#include "partials/csrf_token.ftl">
                        <input class="btn btn-danger" type="submit" value="DELETE NOW">
                    </form>
                </#if>
            </div>
        </div>

        <!-- edit form column -->

        <div class="col-md-9 personal-info">
            <div class="alert alert-info alert-dismissable">
                <a class="panel-close close" data-dismiss="alert">×</a>
                <i class="fa fa-coffee"></i>
                Use this to <strong>Edit</strong> your account.
            </div>
            <h3>Personal info</h3>
            <div class="col-md-9">
                <label class="col-lg-3 control-label">First name:</label>
                <#if user.getName()??>
                    <p class="col-lg-1 control-label"> ${user.getName()}</p>
                </#if>
            </div>

            <div class="col-md-9">
                <label class="col-lg-3 control-label">Surname:</label>
                <#if user.getSurname()??>
                    <p class="col-lg-1 control-label"> ${user.getSurname()}</p>
                </#if>
            </div>
            <div class="col-md-9">
                <label class="col-lg-3 control-label">Email:</label>
                <#if user.getEmail()??>
                    <p class="col-lg-1 control-label"> ${user.getEmail()}</p>
                </#if>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label"></label>
                <div class="col-md-8">
                    <a class="btn btn-primary" href="editprofile">Edit Profile</a>
                </div>
            </div>
        </div>
        <#if currentUser.getRole()=="ROLE_ADMIN">
            <div class="form-group">
                <label class="col-md-3 control-label"></label>
                <div class="col-md-8">
                    <a class="btn btn-primary" href="create_event">Create Event</a>
                </div>
            </div>
        </#if>
    </div>
</div>
</body>
<hr>
    </#if>
</#macro>
<@display_page/>