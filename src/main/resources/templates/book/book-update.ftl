<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update book</title>
    <link rel="stylesheet" href="https://snipp.ru/cdn/select2/4.0.13/dist/css/select2.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/select2-bootstrap-theme/0.1.0-beta.10/select2-bootstrap.min.css"
          integrity="sha512-kq3FES+RuuGoBW3a9R2ELYKRywUEQv0wvPTItv3DSGqjpbNtGWVdvT8qwdKkqvPzT93jp8tSF4+oN4IeTEIlQA=="
          crossorigin="anonymous"/>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
</head>
<body>
<div style="width: 25%; margin: 0 auto">
    <h2>Edit book</h2>
    <form name="bookForm" action="" method="POST" class="row g-3">

        <div class="form-group">
            <label for="edition" class="form-label">Видання: </label>
            <select class="form-control" name="edition" id="edition">
                <#list editions as edition>
                    <option value="${edition.id}" name="${edition.name}"
                            <#if book.edition==edition>selected</#if>>${edition.name}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label for="membership" class="form-label">Користувач: </label>
            <select class="form-control" name="membership" id="membership">
                <#if book.membership??>
                    <option value=null name="null">Null</option>
                    <#list memberships as membership>
                        <option value="${membership.id}" name="${membership.name}"
                                <#if book.membership==membership>selected</#if>>${membership.name}</option>
                    </#list>
                <#else >
                    <option value=null name="null">Null</option>
                    <#list memberships as membership>
                        <option value="${membership.id}" name="${membership.name}">${membership.name}</option>
                    </#list>
                </#if>

            </select>
        </div>

        <div class="form-group">
            <label for="rule" class="form-label">Правило: </label>
            <select class="form-control" name="rule" id="rule">
                <#list rules as rule>
                    <option value="${rule}" name="${rule}" <#if book.rule.rule==rule>selected</#if>>${rule}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label for="storageRoom" class="form-label">Сховище: </label>
            <select class="form-control" name="storageRoom" id="storageRoom">
                <#list storageRooms as storageRoom>
                    <option value="${storageRoom.id}" name="${storageRoom.number}"
                            <#if book.storageRoom==storageRoom>selected</#if>>${storageRoom.number}
                        - ${storageRoom.library.name}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label for="stellageNumber" class="form-label">Стелаж: </label>
            <input type="number" name="stellageNumber" id="stellageNumber" class="form-control" placeholder="11" min="0"
                   required value="${book.stellageNumber}">
        </div>

        <div class="form-group">
            <label for="shelveNumber" class="form-label">Полиця: </label>
            <input type="number" name="shelveNumber" id="shelveNumber" class="form-control" placeholder="21" min="0"
                   required value="${book.shelveNumber}">
        </div>

        <div class="form-group">
            <label for="dateOfReceipt" class="form-label">Дата надходження: </label>
            <input type="date" name="dateOfReceipt" id="dateOfReceipt" class="form-control" required
                   value="${book.dateOdReceipt}">
        </div>

        <div class="form-group">
            <label for="isDecommissioned" class="form-label">Списана?: </label>
            <input type="checkbox" name="isDecommissioned" id="isDecommissioned"
                   <#if book.decommissioned==true>checked</#if>>
        </div>

        <button class="btn btn-primary" type="submit">Редагувати</button>
    </form>
</div>

<script src="https://snipp.ru/cdn/jquery/2.1.1/jquery.min.js"></script>
<script src="https://snipp.ru/cdn/select2/4.0.13/dist/js/select2.min.js"></script>
<script src="https://snipp.ru/cdn/select2/4.0.13/dist/js/i18n/ru.js"></script>
<script>
    $(document).ready(function () {
        $('select').select2({
            theme: "bootstrap"
        });
    });
</script>

</body>
</html>