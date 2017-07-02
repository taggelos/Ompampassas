<#ftl output_format="HTML">
<#include "../layout/default.ftl">
<#macro content>
<div class="form-group">
    <form class="form-horizontal" method="POST">
        <#include "../partials/csrf_token.ftl">
        <label class="sr-only" for="keyword">Διεύθυνση ηλεκτρονικής επικοινωνίας:</label>
        <input style="width:200px" type="keyword" class="form-control" id="keyword" name="keyword">
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
                        <td>${user.getName()}</td>
                        <td>${user.getSurname()}</td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </#if>
    </form>
</div>

</#macro>

<@display_page/>