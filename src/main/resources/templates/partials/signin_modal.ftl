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
                    <div class="form-group">
                        <div class="input-group">
                            <label for="inputEmail" class="sr-only">Email address</label>
                            <input type="email" id="inputEmail" class="form-control" placeholder="Email address">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group">
                            <label for="inputPassword" class="sr-only">Password</label>
                            <input type="password" id="inputPassword" class="form-control" placeholder="Password">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="checkbox">
                            <input type="checkbox" id="remember" name="remember" value="1">
                            <label for="remember">
                                Remember me
                            </label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="signin_button" class="btn btn-warning">Sign in</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>