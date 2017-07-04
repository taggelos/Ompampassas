<#ftl output_format="HTML">
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

    <link rel="icon" href="/assets/images/favicon.ico">

    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/assets/css/awesome-bootstrap-checkbox.css">
    <link rel="stylesheet" href="/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/css/ie10-viewport-bug-workaround.css">
    <link rel="stylesheet" href="/assets/vendor/slick/slick.css"/>
    <link rel="stylesheet" href="/assets/vendor/slick/slick-theme.css"/>
    <link rel="stylesheet" href="/assets/css/chosen.css"/>

    <link rel="stylesheet" href="/assets/css/style.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!--Invisible reCAPTCHA-->
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script>
        function onSubmit(token) {
            document.getElementById("secure-form").submit();
        }
    </script>
    <script src="/assets/js/Chart.js"></script>
</head>

<body>
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <#if currentUser?? && currentUser.getRole() == "ROLE_ADMIN">
                    <li class="${(pageName == "index")?then("active","")}"><a href="/"><span
                            class="fa fa-signal"></span> Πλοήγηση </a></li>
                    <li class="${(pageName == "admin")?then("active","")}"><a href="/admin"><span
                            class="fa fa-address-book"></span> Πίνακες </a></li>
                    <li class="${(pageName == "search_user")?then("active","")}"><a href="/search_user"><span
                            class="fa fa-search"></span> Αναζήτηση Χρήστη </a></li>
                    <li class="${(pageName == "statistics")?then("active","")}"><a href="/statistics"><span
                            class="fa fa-cloud"></span> Στατιστικά </a></li>
                <#else>
                    <li class="${(pageName == "index")?then("active","")}"><a class="navbar-brand" href="/"><span
                            class="fa fa-home"></span> Ompampassas</a></li>
                </#if>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <#if currentUser??>
                    <#if  currentUser.getRole() == "ROLE_PARENT">
                        <li class="${(pageName == "points")?then("active","")}"><a href="/points"><span
                                class="fa fa-trophy"></span>
                        ${currentUser.getParentMetadataById().getPoints()} Πόντοι </a></li>
                    </#if>
                    <li class="dropdown ${(pageName == "profile")?then("active","")}">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">${currentUser.getEmail()} <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/profile">Προφίλ</a></li>
                            <li role="separator" class="divider ${(pageName == "points")?then("active","")}"></li>
                            <li><a href=/logout>Αποσύνδεση</a></li>
                        </ul>
                    </li>
                <#else>
                    <li class="${(pageName == "login")?then("active","")}"><a href="/login">Σύνδεση</a></li>
                    <li class="${(pageName == "register")?then("active","")}"><a href="/register/parent">Εγγραφή</a>
                    </li>
                </#if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div>
</nav>

<div id="main-content" class="container">
    <@content/>
</div>

<footer>
    <hr>
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <p>&copy; 2017 Ompampassas, Inc.</p>
                <#if contactus??>
                    <p>Contact us @ ${contactus}</p>
                </#if>
            </div>

        </div>
    </div>
</footer>

<script src="/assets/js/jquery-3.2.1.min.js"></script>
<script src="/assets/js/ie10-viewport-bug-workaround.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/vendor/slick/slick.js"></script>
<script src="/assets/js/google-maps-autocomplete.js"></script>
<script src="/assets/js/chosen.jquery.min.js"></script>

<script src="/assets/js/scripts.js"></script>
    <@end_of_body/>
</body>
</html>
</#macro>