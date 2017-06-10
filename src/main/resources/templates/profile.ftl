<#include "layout/default.ftl">

<#macro content>
<body class="mybody">
<div class="container">
    <h1>My Profile</h1>
    <hr>
    <div class="row">
        <div class="col-md-3">
            <div class="text-center">
            <#--img src="//placehold.it/100" class="avatar img-circle" alt="avatar"-->
            <#-- <#if imagedir??> -->
                <img src="assets/imagedir/myimg.jpg"/>
            <#--/#if-->
                <h6>Upload a different photo...</h6>

                <form method="POST" enctype="multipart/form-data" action="/uploadpic">
                    <#include "partials/csrf_token.ftl">
                    <table>
                        <tr>
                            <td></td>
                            <td>
                                <p>
                                    <input id="fileInput" type="file" name="uploadingImgs" multiple>
                                </p>
                                <p>
                                    <input type="submit" value="Upload NOW">
                                </p>
                            </td>
                        </tr>
                    </table>
                </form>

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
    </div>
</div>
</body>
<hr>
</#macro>

<@display_page/>