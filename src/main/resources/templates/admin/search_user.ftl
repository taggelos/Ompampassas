<#ftl output_format="HTML">
<#assign pageName = "index">
<#include "../layout/default.ftl">
<#macro content>
<div class="form-group">
    <form class="form-horizontal" method="POST">
        <#include "../partials/csrf_token.ftl">
        <label class="sr-only" for="keyword">Διεύθυνση ηλεκτρονικής επικοινωνίας:</label>
        <input style="width:200px" class="form-control" id="keyword" name="keyword">
        <button type="submit" class="btn btn-default"> Αναζήτηση</button>
        <br>
        <#if result??>
            <h2> ${result}</h2>
            <hr>
        <#else>
            <h2> Πληκτρολογείστε μια λέξη κλειδί </h2>
        </#if>
        <#if userList??>
            <table class="table">
                <thead>
                <tr class="warning">
                    <th>Email</th>
                    <th>Όνομα</th>
                    <th>Επώνυμο</th>
                </tr>
                <tbody>
                    <#list userList as user>
                    <tr class="success">
                        <td><a href="/profile/${user.getEmail()}">${user.getEmail()}</a></td>
                        <#if user.getRole() == "ROLE_PARENT">
                            <td>${user.getParentMetadataById().getFirstName()}</td>
                            <td>${user.getParentMetadataById().getLastName()}</td>
                        <#elseif user.getRole() == "ROLE_PROVIDER">
                            <td>${user.getProviderMetadataById().getTitle()}</td>
                            <td>${user.getProviderMetadataById().getCompanyName()}</td>
                        <#else>
                            <td></td>
                            <td></td>
                        </#if>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </#if>
    </form>
</div>

</#macro>

<@display_page/>