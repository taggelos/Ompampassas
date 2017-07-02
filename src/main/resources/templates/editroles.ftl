<#assign pageName = "index">
<#include "layout/default.ftl">

<#macro content>
<div class="container" style="background-color:lightskyblue;">
    <h1>Edit Profile</h1>
    <hr>
    <div class="row">
        <form name="form1" class="form-horizontal" method="POST">
            <input type="hidden" name="ftype" value="admin"/>
            <#include "partials/csrf_token.ftl">

            <div class="col-md-3">
                <div class="alert alert-info alert-dismissable">
                    <p>Ο ρόλος του χρήστη είναι:
                        <strong><#if user.isEnabled()> Ενεργός
                        <#else> Ανενεργός </#if>-<#if user.getRole()=="ROLE_PARENT"> Γονέας
                        <#elseif user.getRole()=="ROLE_PROVIDER"> Πάροχος <#else>
                            Διαχειριστής </#if></strong>
                    </p>
                </div>
                    <button type="submit" class="btn btn-warning" name="enable" value="<#if user.isEnabled()>disable">
                Απενεργοποίηση
                Χρήστη
            </button>
            <#else>enable"> Ενεργοποίηση Χρήστη</button>

            </#if>
                <select class="btn btn-success" name="roles" onchange="this.form.submit()">
                    <option class="btn btn-warning" selected disabled>Διαθέσιμοι Ρόλοι:</option>
                    <#if user.getRole()=="ROLE_PARENT" || user.getRole()=="ROLE_PROVIDER">
                        <option class="btn btn-success" type="submit" name="button2" value="admin"> Εναλλαγή σε
                            Διαχειριστή
                        </option>
                    <#else>
                        <option class="btn btn-success" type="submit" name="button1" value="parent"> Εναλλαγή σε Γονέα
                        </option>
                        <option class="btn btn-success" type="submit" name="button2" value="provider"> Εναλλαγή σε
                            Πάροχο
                        </option>

                    </#if>
                </select>
            </div>
        </form>
    </div>
</div>
<hr>
</#macro>

<@display_page/>