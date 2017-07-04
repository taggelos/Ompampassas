<#ftl output_format="HTML">
<#assign pageName = "info">
<#include "layout/default.ftl">

<#macro content>
<body xmlns="http://www.w3.org/1999/html">
<div class="form-group">

    <#if tickets??>
        <table class="table">
            <tr class="warning">
                <th>Ticket Id</th>
                <th>Price</th>
                <th></th>
            </tr>
            <#list tickets as ticket>
                <tr class="success">
                    <td>
                        #ID_${ticket.id}
                    </td>
                    <td>
                    ${ticket.numOfTickets * ticket.eventByEventId.price} €
                    </td>
                    <td>
                        <form action="/provider_tickets" method="post">
                            <#include "partials/csrf_token.ftl">
                            <input type="hidden" name="ticketid" value="${ticket.id}">
                            <input type="submit" value="View"/>
                        </form>
                    </td>
                </tr>
            </#list>
        </table>
    <#else>
        You sneaky sneaky
    </#if>
</div>
</#macro>

<@display_page/>