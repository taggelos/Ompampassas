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
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</#macro>
<@display_page/>