<#include "layout/default.ftl">

<#macro content>
<body class="mybody">
<div class="container">
    <h1>My Profile</h1>
    <hr>
    <div class="row">
        <div class="col-md-3">
            <div class="text-center">
                <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">
                <h6>Upload a different photo...</h6>

                <input type="file" class="form-control">
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

            <form class="form-horizontal" action="editprofile" method="POST">
                <#include "partials/csrf_token.ftl">

                <div class="form-group">
                    <label class="col-lg-3 control-label">First name:</label>
                    <p class="col-lg-1 control-label">${getName(currentUser.getUsername())}</p>
                    <div class="col-lg-8 control-label">
                        <input class="form-control" name="name" type="hidden" value="AAAAAAAAAAAAAAA">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Last name:</label>
                    <p class="col-lg-1 control-label">AAAAAA</p>
                    <div class="col-lg-8">
                        <input class="control" name="surname" type="hidden" value="BBBBBBBBBBBBBBBBB">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Email:</label>
                    <p class="col-lg-1 control-label">AAAAAAAAAAAA</p>
                    <div class="col-lg-8">
                        <input class="form-control" name="email" type="hidden" value="CCCCCCCCCCCCCC">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Username:</label>
                    <p class="col-lg-1 control-label">${currentUser.getUsername()}</p>
                    <div class="col-md-8">
                        <input class="form-control" name="username" type="hidden" value="DDDDDDDDDDDDDDDDDD">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        <input type="submit" class="btn btn-primary" value="Edit Profile">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<hr>
</#macro>

<@display_page/>