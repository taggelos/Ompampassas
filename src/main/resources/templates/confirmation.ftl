<#assign pageName = "confirmation">
<#include "layout/default.ftl">

<#macro content>
<div class='container'>
    <div class='row' style='padding-top:25px; padding-bottom:25px;'>
        <div class='col-md-12'>
            <div id='mainContentWrapper'>
                <div class="col-md-8 col-md-offset-2">
                    <h2 style="text-align: center;">
                        Σύνοψη Πληρωμής
                    </h2>
                    <div class="shopping_cart">
                        <form class="form-horizontal" role="form" action="#" method="post" id="payment-form">
                            <#include "partials/csrf_token.ftl">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Ανασκόπηση
                                                Αγοράς</a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <div class="items">
                                                <div class="col-md-9">
                                                    <table class="table table-striped">
                                                        <tr>
                                                            <td>
                                                                <ul>
                                                                    <li>Κόστος Εισιτηρίου</li>
                                                                    <li>Πλήθος Εισιτηρίων</li>
                                                                </ul>
                                                            </td>
                                                            <td>
                                                                <li>15 Πόντοι</li>
                                                                <li>3</li>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="col-md-3">
                                                    <div style="text-align: center;">
                                                        <h3>Συνολίκο Κόστος</h3>
                                                        <h3><span style="color:green;">45 Πόντοι</span></h3>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-success btn-lg"
                                            style="width:100%;">Αγορά
                                    </button>
                                    <br/>
                                    <div style="text-align: left;"><br/>
                                        Υποβάλλοντας αυτήν την παραγγελία συμφωνείτε με την καθολική μας
                                         συμφωνία χρέωσης και τους όρους παροχής υπηρεσιών.
                                         Αν έχετε ερωτήσεις σχετικά με τα προϊόντα ή τις υπηρεσίες μας, επικοινωνήστε
                                        μαζί μας στο ompampassas [at] ompampassas.com πριν προχωρήσετε σε αυτήν την
                                        παραγγελία.
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</#macro>

<@display_page/>
