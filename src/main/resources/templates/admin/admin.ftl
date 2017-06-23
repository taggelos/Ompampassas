<#include "../layout/default.ftl">

<#macro content>
<div id="content">
    <table>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
        </tr>
        <#list model["userList"] as user>
            <tr>
                <td>${user.getName()}</td>
                <td>${user.getSurname()}</td>
            </tr>
        </#list>
    </table>
</div>
</#macro>
<@display_page/>