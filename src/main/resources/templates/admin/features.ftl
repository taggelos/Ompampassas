<#include "../layout/default.ftl">
<#macro content>

<div class="form-group">
    <form class="form-horizontal" method="POST">
        <#include "../partials/csrf_token.ftl">
        <label class="sr-only" for="email">Διεύθυνση ηλεκτρονικής επικοινωνίας:</label>
        <input style="width:200px" type="email" class="form-control" id="email" name="email">
        <button type="submit" class="btn btn-default"> Αλλαγή</button>
    </form>
</div>

</#macro>

<@display_page/>