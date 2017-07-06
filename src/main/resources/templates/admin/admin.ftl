<#ftl output_format="HTML">
<#assign pageName = "admin">
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
    <#if resTable?? || userList?? >
        <#if resTable??>
            <h2> ${resTable}</h2>
            <hr>
        </#if>
        <#if userList??>
            <table class="table">
                <thead>
                <tr class="warning">
                    <th>Email</th>
                    <th>Όνομα</th>
                    <th>Επώνυμο/Τίτλος</th>
                </tr>
                <tbody>
                    <#list userList as user>
                    <tr class="success">
                        <td><a href="profile/${user.getEmail()}">${user.getEmail()}</a></td>
                        <#if user.getRole() == "ROLE_PARENT">
                            <td>${user.getParentMetadataById().getFirstName()}</td>
                            <td>${user.getParentMetadataById().getLastName()}</td>
                        <#elseif user.getRole() == "ROLE_PROVIDER">
                            <td>${user.getProviderMetadataById().getTitle()}</td>
                            <td>${user.getProviderMetadataById().getCompanyName()}</td>
                        <#else>
                            <td>-</td>
                            <td>-</td>
                        </#if>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </#if>
    <#else>
        <h2> Δεν έχει επιλεχθεί πίνακας! </h2>
    </#if>
</div>
</#macro>
<@display_page/>