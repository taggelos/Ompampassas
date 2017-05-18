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
                                <input type="hidden" name="kind" value="Parent">
                                <div class="input-group">
                                    <label for="inputName" class="sr-only">First Name</label>
                                    <input type="text" id="inputName" class="form-control" placeholder="First Name"
                                           required autofocus>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="inputSurname" class="sr-only">Surname</label>
                                    <input type="text" id="inputSurname" class="form-control" placeholder="Surname"
                                           required autofocus>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="inputUsername" class="sr-only">Username</label>
                                    <input type="text" id="inputUsername" class="form-control" placeholder="Username"
                                           required autofocus>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                </div>
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
                                <div class="input-group">
                                    <label for="inputConfirmPassword" class="sr-only">Confirm Password</label>
                                    <input type="password" id="inputConfirmPassword" class="form-control"
                                           placeholder="Confirm Password" required>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="inputPhone" class="sr-only">Phone</label>
                                    <input type="text" id="inputPhone" class="form-control" placeholder="Phone"
                                           required autofocus>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                                </div>
                                <div class="input-group">
                                    <label>Date of Birth </label>
                                    <input type="date" class="form-control" id="Date" placeholder="Date of Birth">
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="gender" value="male" checked> Male
                                    </label>
                                    <label>
                                        <input type="radio" name="gender" value="female"> Female
                                    </label>
                                    <label>
                                        <input type="radio" name="gender" value="other"> Other
                                    </label>
                                </div>
                                <div class="alert alert-warning alert-dismissable fade in">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Warning!</strong> This alert box could indicate a warning that might need
                                    attention.
                                </div>
                                <button id="signin_button" class="btn btn-md btn-warning" type="submit">Sign Up</button>
                            </form>
                        </fieldset>
                        <fieldset id="form2" class="tab-pane ">
                            <form class="form2-signin" id="form2-signin" method="POST">
                                <input type="hidden" name="kind" value="Provider">
                                <div class="input-group">
                                    <label for="inputName" class="sr-only">First Name</label>
                                    <input type="text" id="inputName" class="form-control" placeholder="First Name"
                                           required autofocus>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="inputSurname" class="sr-only">Surname</label>
                                    <input type="text" id="inputSurname" class="form-control" placeholder="Surname"
                                           required autofocus>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="inputCompanyname" class="sr-only">Company Name</label>
                                    <input type="text" id="inputCompanyname" class="form-control" placeholder="Company Name"
                                           required autofocus>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="inputEmail" class="sr-only">Email address</label>
                                    <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address"
                                           required autofocus>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="inputPassword" class="sr-only">Password</label>
                                    <input type="password" id="inputPassword" class="form-control" name="password"
                                           placeholder="Password" required>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="inputConfirmPassword" class="sr-only">Confirm Password</label>
                                    <input type="password" id="inputConfirmPassword" class="form-control"
                                           placeholder="Confirm Password" required>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                </div>
                                <div class="input-group">
                                    <label for="inputContactPhone" class="sr-only">Contact Phone</label>
                                    <input type="text" id="inputContactPhone" class="form-control" placeholder="Contact Phone"
                                           required autofocus>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                                </div>
                                <div class="alert alert-warning alert-dismissable fade in">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Warning!</strong> This alert box could indicate a warning that might need
                                    attention.
                                </div>
                                <label class="custom-file">
                                    <label>Papers Required</label><br>
                                    <input type="file" id="file" class="custom-file-input">
                                    <span class="custom-file-control"></span>
                                </label>
                                <button id="signin_button" class="btn btn-md btn-warning" type="submit">Sign Up</button>
                            </form>
                        </fieldset>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
