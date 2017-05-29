<#if errors??>
<div class="row">
    <div class="col-sm-12">
        <div class="alert alert-danger alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <ul>
                <#list errors as error>
                    <li>${error.getMessage()}</li>
                </#list>
            </ul>
        </div>
    </div>
</div>
</#if>