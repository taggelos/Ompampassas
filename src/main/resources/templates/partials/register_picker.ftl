<div class="row" id="register-picker">
    <div class="col-sm-12">
        <ul class="nav nav-tabs" role="tablist">
            <li class="${(registerType == "parent")?then("active", "")}">
                <a href="register/parent">Είμαι Γονέας</a>
            </li>
            <li class="${(registerType == "provider")?then("active", "")}">
                <a href="register/provider">Είμαι Πάροχος</a>
            </li>
        </ul>
    </div>
</div>