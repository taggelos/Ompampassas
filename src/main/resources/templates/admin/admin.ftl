<#include "../layout/default.ftl">

<#macro content>
<div id="content">
    <table class="table">
        <thead>
        <tr class="warning">
            <th>Firstname</th>
            <th>Lastname</th>
        </tr>
        <tbody>
            <#list model["userList"] as user>
            <tr class="success">
                <td>${user.getName()}</td>
                <td>${user.getSurname()}</td>
                <td>
                    <form class="form-horizontal" method="POST"><input type="submit" class="deletebtn"></form>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
    <img src="assets/images/deletebtn.png">
</div>
</#macro>
<@display_page/>