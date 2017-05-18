<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="icon" href="assets/favicon.ico">
    <link rel="stylesheet" type="text/css" href="assets/css/signup.css"/>
    <title>Ompampassas</title>
</head>

<body>
<#include "layout/defaultHeader.ftl">
<@layout>
</@layout>

<div class="container">
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
                            <form class="form-signin" id="form-signin" method="POST">
                                <div class="input-group">
                                    <label for="inputEmail" class="sr-only">Email address</label>
                                    <input type="email" id="inputEmail" class="form-control" placeholder="Email address"
                                           name="email" required autofocus>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="inputPassword" class="sr-only">Password</label>
                                    <input type="password" id="inputPassword" class="form-control" name="password"
                                           placeholder="Password" required>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="remember-me"> Remember me
                                    </label>
                                </div>
                                <div class="alert alert-warning alert-dismissable fade in">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Warning!</strong> This alert box could indicate a warning that might need
                                    attention.
                                </div>
                                <label class="custom-file">
                                    <input type="file" id="file" class="custom-file-input">
                                    <span class="custom-file-control"></span>
                                </label>
                                <button id="signin_button" class="btn btn-md btn-warning" type="submit">Sign in</button>
                            </form>
                        </fieldset>
                        <fieldset id="form2" class="tab-pane ">

                            provider
                        </fieldset>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
