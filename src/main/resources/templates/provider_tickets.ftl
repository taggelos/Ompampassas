<#ftl output_format="HTML">
<#assign pageName = "info">
<#include "layout/default.ftl">

<#macro content>
<body xmlns="http://www.w3.org/1999/html">

    <#if tickets??>
        <#list tickets as ticket>
        <form action="/provider_tickets" method="post">
            <#include "partials/csrf_token.ftl">
            <input type="submit" name="ticketid" value="${ticket.id}"/>
        </form>
        </#list>
    <#else>
    You sneaky sneaky
    </#if>

</#macro>

<@display_page/>