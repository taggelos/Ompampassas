<#macro layout>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Jumbotron Template for Bootstrap</title>

    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">

    <link href="assets/css/modal.css" rel="stylesheet">

    <!-- Extra Libs for Modal -->
    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/scripts.js"></script>

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
                <span class="glyphicon glyphicon-home"></span> Ompampassas</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <div class="navbar-form  navbar-nav navbar-right">
                <a class="btn btn-success" href="/signup">
                    <span class="glyphicon glyphicon-user"></span> Sign Up</a>
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#loginModal">
                    <span class="glyphicon glyphicon-log-in"></span> Login</button>
            </div>
        </div><!--/.navbar-collapse -->
    </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header modal-header-success">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h2 class="modal-title">Please sign in</h2>
            </div>
            <div class="modal-body">
                <!-- Modal Body-->
                <form class="form-signin" id="form-signin">
                    <div class="input-group">
                    <label for="inputEmail" class="sr-only">Email address</label>
                    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    </div>
                    <div class="input-group">
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Remember me
                        </label>
                    </div>
                    <div class="alert alert-warning alert-dismissable fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Warning!</strong> This alert box could indicate a warning that might need attention.
                    </div>
                    <button id="signin_button" class="btn btn-md btn-warning" type="submit">Sign in</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<!-- use the pages -->
<div class="container">
    <#nested>
</div>


</body>
</html>
</#macro>