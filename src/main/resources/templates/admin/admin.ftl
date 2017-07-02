<#include "../layout/default.ftl">

<#macro content>
<div id="content" xmlns="http://www.w3.org/1999/html">
    <form method="POST">
        <#include "../partials/csrf_token.ftl">
        <select class="btn btn-success" name="tables" onchange="this.form.submit()">
            <option class="btn btn-warning" selected disabled>Πίνακες:</option>
            <option class="btn btn-info" value="all">Όλοι οι χρήστες</option>
            <option class="btn btn-info" value="admins">Διαχειριστές</option>
            <option class="btn btn-info" value="providers">Πάροχοι</option>
            <option class="btn btn-info" value="parents">Γονείς</option>
        </select>
    </form>
    <br>
    <#if resTable?? || model["userList"]?? >
        <#if resTable??>
            <h2> ${resTable}</h2>
            <hr>
        </#if>
        <#if model["userList"]??>
            <table class="table">
                <thead>
                <tr class="warning">
                    <th>Email</th>
                    <th>Firstname</th>
                    <th>Lastname</th>
                </tr>
                <tbody>
                    <#list model["userList"] as user>
                    <tr class="success">
                        <td><a href="/profile/${user.getEmail()}">${user.getEmail()}</a></td>
                        <td>${user.getName()}</td>
                        <td>${user.getSurname()}</td>
                    <#--td>
                        <form class="form-horizontal" method="POST"><#include "partials/csrf_token.ftl"><input type="submit" class="deletebtn"></form>
                    </td-->
                    </tr>
                    </#list>
                </tbody>
            </table>
        </#if>
    <#else>
        <h2> Δεν έχει επιλεχθεί πίνακας! </h2>
    </#if>
    <!--img src="assets/images/deletebtn.png"-->
</div>
</#macro>
<@display_page/>