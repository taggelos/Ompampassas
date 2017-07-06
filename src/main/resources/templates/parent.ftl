<#ftl output_format="HTML">
<#assign pageName = "parent">
<#include "layout/default.ftl">

<#macro content>

    <#if (currentUser?? && currentUser.getId()==parent.getUserId()) ||  currentUser.getRole()=="ROLE_ADMIN">

    <div class="panel panel-success">
        <h1>${parent.getFirstName()}  ${parent.getLastName()}</h1>
    </div>

    <h2>Εκδηλώσεις</h2>
    <div class="container">
        <#if message??>
            <div class="row">
                <div class="col-sm-12">
                    <div class="alert alert-info alert-dismissible">${message}</div>
                </div>
            </div>
        </#if>
        <#list tickets as ticket>
            <div class="col-md-9">
                <div class="results-search-container">
                    <div class="items-in-list">
                        <div class="thumbnail">
                            <div class="caption">
                                <#assign event = ticket.getEventByEventId()>
                                <h4><a href="info/${event.getId()}">${event.getTitle()}</a></h4>
                                <p>Εισιτήρια : ${ticket.getNumOfTickets()}</p>
                                <p>Ώρα Έναρξης : ${event.getStartTime()}</p>
                                <form method="POST" action="#">
                                    <#include "partials/csrf_token.ftl">
                                    <input type="hidden" id="event_id" name="event_id" value="${event.getId()}">
                                    <input type="hidden" id="ticket_id" name="ticket_id" value="${ticket.getId()}">
                                    <input type="submit" class="btn btn-primary" value="Ακύρωση Εισητηρίου">
                                </form>
                                <br>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
    </#if>
</#macro>

<@display_page/>