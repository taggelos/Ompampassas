<#assign pageName = "index">
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

</#macro>

<@display_page/>