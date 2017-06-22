<#include "layout/default.ftl">

<#macro content>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
            <legend><i class="glyphicon glyphicon-globe"></i> Event</legend>
            <form action="#" method="POST">
                <#include "partials/csrf_token.ftl">

                <input class="form-control" name="title" placeholder="Title" type="text"/>
                <textarea name="description" id="Description" class="form-control" rows="9" cols="25"
                          required="required" placeholder="Description"></textarea>
                <input class="form-control" name="category" placeholder="Category" type="text"/>
                <label for="">Starting </label>
                <div class="form-group has-feedback">
                    <input type="datetime-local" name="start" class="form-control">
                    <i class="glyphicon glyphicon-hourglass form-control-feedback"></i>
                </div>
                <label for="">Ending </label>
                <div class="form-group has-feedback">
                    <input type="datetime-local" name="end" class="form-control">
                    <i class="glyphicon glyphicon-hourglass form-control-feedback"></i>
                </div>
                <label for="">Price</label>
                <div class="form-group has-feedback">
                    <input name="price" type="number" min="1" max="500" class="form-control" data-toggle="tooltip"
                           title="Price">
                    <i class="glyphicon glyphicon-star form-control-feedback"></i>
                </div>
                <div class="form-group has-feedback">
                    <input name="notickets" type="number" min="1" max="500" class="form-control" data-toggle="tooltip"
                           title="Number Of Tickets">
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