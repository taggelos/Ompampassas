<#assign pageName = "profile">
<#include "layout/default.ftl">

<#macro content>
    <#if user?? && currentUser?? && (currentUser.getEmail() == user.getEmail() || currentUser.getRole() == "ROLE_ADMIN")>
    <div class="container">
        <h1>Προφίλ</h1>
        <hr>
        <div class="row">
            <div class="col-md-4">
                <div class="text-center">
                    <#if avatar??>
                        <img class="profile-img" src="/assets/imagedir/${user.getEmail()}/${avatar}"/>
                    <#else>
                        <img class="profile-img" src="/assets/images/defaultprof.png"/>
                    </#if>
                    <h6>Ανεβάστε διαφορετική φωτογραφία...</h6>
                    <h6>Πατήστε Shift+f5 για επαναφόρτωση</h6>
                    <form class="form-horizontal" method="POST" enctype="multipart/form-data"
                          action="/uploadpic/${user.getEmail()}">
                        <#include "partials/csrf_token.ftl">
                        <div class="form-group">
                            <input class="btn btn-warning btn-block" id="fileInput" type="file" name="uploadingImgs"
                                   multiple>
                        </div>

                        <div class="form-group">
                            <input class="btn btn-warning btn-block" type="submit" value="Ανέβασμα Εικόνας">
                        </div>
                    </form>
                    <#if avatar??>
                        <form class="form-horizontal" method="POST" enctype="multipart/form-data"
                              action="/deletepic/${user.getEmail()}">
                            <#include "partials/csrf_token.ftl">
                            <div class="form-group">
                                <input class="btn btn-danger btn-block" type="submit" value="Διαγραφή Εικόνας">
                            </div>
                        </form>
                    </#if>
                </div>
            </div>

            <div class="col-md-8">
                <div class="row">
                    <div class="col-sm-12">
                        <a class="btn btn-primary" href="/editprofile/${user.getEmail()}">
                            <i class="fa fa-pencil"></i> Αλλαγή Στοιχείων
                        </a>

                        <#if currentUser.getRole()=="ROLE_PROVIDER">
                            <a class="btn btn-primary" href="/create_event">
                                <i class="fa fa-plus"></i> Δημιουργία Εκδήλωσης
                            </a>
                            <a class="btn btn-primary" href="/statistics">
                                <i class="fa fa-bar-chart"></i> Στατιστικά Παρόχων
                            </a>
                        </#if>
                    </div>
                </div>

                <h3>Στοιχεία Χρήστη</h3>

                <div class="form-horizontal">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="col-md-4">
                                    <label class="control-label">Όνομα:</label>
                                </div>
                                <div class="col-md-8">
                                    <div class="form-control-static">${user.getName()}</div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-4">
                                    <label class="control-label">Επώνυμο:</label>
                                </div>
                                <div class="col-md-8">
                                    <div class="form-control-static">${user.getSurname()}</div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-4">
                                    <label class="control-label">Email:</label>
                                </div>
                                <div class="col-md-8">
                                    <div class="form-control-static">${user.getEmail()}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </#if>
</#macro>
<@display_page/>