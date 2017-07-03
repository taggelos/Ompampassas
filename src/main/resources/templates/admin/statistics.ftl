<#ftl output_format="HTML">
<#assign pageName = "statistics">
<#include "../layout/default.ftl">
<#macro content>
<div style="width: 100%; height: auto;">
    <canvas id="myChart"></canvas>
</div>
<script>
        <#if providerList??>
        var arr = [<#list providerList as provider>'${provider.getCompanyName()}',</#list>];
        var ratings = [<#list providerList as provider>${provider.getRating()?c}/${provider.getNumberOfRatings()?c},</#list>];
        </#if>
    var ctx = document.getElementById("myChart");
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: arr,
            datasets: [{
                label: 'Stars per Provider',
                data: ratings,
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
</script>
    <#if currentUser.getRole()=="ROLE_PROVIDER">
    <a class="btn btn-primary" href="/profile">
        <i class="fa fa-chevron-left"></i> Επιστροφή
    </a>
    </#if>
    <#if currentUser.getRole()=="ROLE_ADMIN">
    <table class="table">
        <thead>
        <tr class="warning">
            <th class="warning">Πλήθος χρηστών</th>
            <th class="warning">Πλήθος γονέων</th>
            <th class="warning">Πλήθος παρόχων</th>
            <th class="warning">Πλήθος διαχειριστών</th>
        </tr>
        <tbody>
        <tr class="success">
            <td>${num_all}</td>
            <td>${num_parents}</td>
            <td>${num_providers}</td>
            <td>${num_admins}</td>
        </tr>
        </tbody>
    </table>
    </#if>
</#macro>

<@display_page/>