<#macro content>

</#macro>

<#macro end_of_body>

</#macro>

<#macro display_page>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Ompampassas</title>

    <link rel="icon" href="assets/images/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="assets/css/awesome-bootstrap-checkbox.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/ie10-viewport-bug-workaround.css">
    <link rel="stylesheet" type="text/css" href="assets/vendor/slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="assets/vendor/slick/slick-theme.css"/>

    <link rel="stylesheet" href="assets/css/style.css">

    <script src="assets/js/google-maps-autocomplete.js"></script>
    <script src="assets/js/Chart.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top" style="background-color: white;">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">
                <span class="glyphicon glyphicon-home"></span> Ompampassas
            </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <div class="navbar-form  navbar-nav navbar-right">
                <a class="btn btn-success" href="/signup">
                    <span class="fa fa-user"></span> Εγγραφή
                </a>
                <a class="btn btn-success" href="/signin">
                    <span class="fa fa-sign-in"></span> Σύνδεση
                </a>
            <#--<button type="button" class="btn btn-success" data-toggle="modal" data-target="#loginModal">-->
            <#--<span class="glyphicon glyphicon-log-in"></span> Login-->
            <#--</button>-->
            </div>
        </div><!--/.navbar-collapse -->
    </div>
</nav>

<!-- Freemarker if logged in admin-->
<div id="main-content" class="container">
    <nav class="navbar navbar-default row" role="navigation">
        <div class="side-menu-container">
            <ul class="nav navbar-nav">
                <li><a href="/admin"><span class="fa fa-address-book"></span>Dashboard</a></li>
                <li><a href="/signup"><span class="fa fa-android"></span> Yolo </a></li>
                <li><a href="/statistics"><span class="fa fa-cloud"></span> Statistics</a></li>

                <li><a href="/"><span class="fa fa-signal"></span> View Site</a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </nav>
</div>

<div id="main-content" class="container">
    <@content/>
</div>


<footer class="navbar-fixed-bottom">
    <hr>
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <p>&copy; 2017 Ompampassas, Inc.</p>
            </div>
        </div>
    </div>
</footer>

<script src="assets/js/jquery-3.2.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/ie10-viewport-bug-workaround.js"></script>
<script type="text/javascript" src="assets/vendor/slick/slick.js"></script>


<script src="assets/js/scripts.js"></script>

<#--<#include "../partials/signin_modal.ftl">-->
<#--<#include "../partials/signin_modal_js.ftl">-->

    <@end_of_body/>
</body>
</html>
</#macro>