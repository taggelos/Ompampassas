<#include "layout/default.ftl">

<#macro content>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
            <legend><i class="glyphicon glyphicon-globe"></i> Event</legend>
            <form action="#" method="post" class="form" role="form">
                <input class="form-control" name="eventTitle" placeholder="Title" type="text"/>
                <textarea name="Description" id="Description" class="form-control" rows="9" cols="25"
                          required="required" placeholder="Description"></textarea>
                <label for="">Date</label>
                <div class="form-group has-feedback">
                    <input type="date" class="form-control" name="event_date" min="2016-12-31">
                    <i class="glyphicon glyphicon-calendar form-control-feedback"></i>
                </div>
                <label for="">Starting Hour</label>
                <div class="form-group has-feedback">
                    <input type="time" name="time" class="form-control" min="2016-12-31">
                    <i class="glyphicon glyphicon-hourglass form-control-feedback"></i>
                </div>
                <label for="">Ending Hour</label>
                <div class="form-group has-feedback">
                    <input type="time" name="time" class="form-control" min="2016-12-31">
                    <i class="glyphicon glyphicon-hourglass form-control-feedback"></i>
                </div>
                <label for="">Price</label>
                <div class="form-group has-feedback">
                    <input type="number" min="1" max="500" class="form-control" data-toggle="tooltip"
                           title="Price">
                    <i class="glyphicon glyphicon-star form-control-feedback"></i>
                </div>
                <button class="btn btn-large btn-primary btn-block" type="submit">
                    Create Event
                </button>
            </form>
        </div>
    </div>
</div>
</#macro>

<@display_page/>