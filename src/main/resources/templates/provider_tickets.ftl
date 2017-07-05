<#ftl output_format="HTML">
<#assign pageName = "info">
<#include "layout/default.ftl">

<#macro content>
<body xmlns="http://www.w3.org/1999/html">
<div class="form-group">

    <#if tickets??>
        <#if tickets?has_content>
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
            <h2>Δεν υπάρχουν εισιτήρια</h2>
        </#if>
    <#else>
        <h2>Δεν επιτρέπεται αυτή η δραστηριότητα.</h2>
    </#if>
</div>
</#macro>

<@display_page/>