<#ftl output_format="HTML">
<#assign pageName = "create_event">
<#include "layout/default.ftl">

<#macro content>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
            <legend><i class="glyphicon glyphicon-globe"></i> Εκδήλωση</legend>
            <form method="POST">
                <#include "partials/csrf_token.ftl">
                <input type="text" class="form-control" name="area" placeholder="Περιοχή" id="gautofill"
                       onchange="AdressInfo();" required/>
                <input class="form-control" name="place_title" placeholder="Place Title" type="text" required/>
                <input class="form-control" name="title" placeholder="Όνομα Εκδήλωσης" type="text" required/>
                <input class="form-control" name="category" placeholder="Κατηγορία Εκδήλωσης" type="text" required/>
                <input class="form-control" id="longitude" name="longitude" value="" type="hidden"/>
                <input class="form-control" id="latitude" name="latitude" value="" type="hidden"/>
                <textarea name="description" id="Description" class="form-control" rows="9" cols="25"
                          required="required" placeholder="Περιγραφή Εκδήλωσης"></textarea>

                <label for="">Έναρξη Εκδήλωσης </label>
                <div class="form-group has-feedback">
                    <input type="datetime-local" name="start" class="form-control" required>
                    <i class="glyphicon glyphicon-hourglass form-control-feedback"></i>
                </div>
                <label for="">Λήξη Εκδήλωσης </label>
                <div class="form-group has-feedback">
                    <input type="datetime-local" name="end" class="form-control" required>
                    <i class="glyphicon glyphicon-hourglass form-control-feedback"></i>
                </div>
                <label for="">Τιμή Εισιτηρίου </label>
                <div class="form-group has-feedback">
                    <input name="price" type="number" min="1" max="500" class="form-control" data-toggle="tooltip"
                           title="Τιμή Εισιτηρίου" required>
                    <i class="glyphicon glyphicon-euro form-control-feedback"></i>
                </div>
                <label for="">Αριθμός Εισιτηρίων </label>
                <div class="form-group has-feedback">
                    <input name="notickets" type="number" min="1" max="10000" class="form-control" data-toggle="tooltip"
                           title="Αριθμός Εισιτηρίων" required>
                    <i class="glyphicon glyphicon-tags form-control-feedback " aria-hidden="true"></i>
                </div>
                <button class="btn btn-large btn-primary btn-block" type="submit">
                    Δημιουργία Εκδήλωσης
                </button>
            </form>
        </div>
    </div>
</div>
</#macro>

<#macro end_of_body>
<script src="assets/js/google-maps-autocomplete.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA3WqcVF0nlc5jIAw7iAXuNT7K45wA8RVs&libraries=places&callback=initAutocomplete"
        async defer></script>
</#macro>

<@display_page/>