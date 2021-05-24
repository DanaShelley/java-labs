<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Редагувати працівника</title>
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
<body>
<div style="width: 500px; margin: 0 auto">
    <h2>Редагувати працівника</h2>
    <form name="staffForm" action="" method="POST" class="row g-3">
        <div class="form-group">
            <label for="name" class="form-label">Ім'я: </label>
            <input type="text" name="name" id="name" class="form-control" placeholder="Андрій Андрійович Крамарчук" required
                   value="${staff.name}">
        </div>

        <div class="form-group">
            <label for="phone" class="form-label">Мобільний номер: </label>
            <input type="text" name="phone" id="phone" class="form-control" placeholder="+380966308974" required
                   value="${staff.phone}">
        </div>

        <div class="form-group">
            <label for="library" class="form-label">Бібліотека: </label>
            <select class="form-control" name="library" id="library">
                <#list libraries as library>
                    <option value="${library.id}" name="${library.name}"
                            <#if staff.library==library>selected</#if>>${library.name}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label for="position" class="form-label">Посада: </label>
            <select class="form-control" name="position" id="position">
                <#list positions as position>
                    <option value="${position.id}" name="${position.position}"
                            <#if staff.position==position>selected</#if>>${position.position}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label for="employmentDate" class="form-label">Дата найму: </label>
            <input type="date" name="employmentDate" id="employmentDate" class="form-control"
                   value="${staff.employmentDate}" required>
        </div>

        <button class="btn btn-primary" type="submit">Update</button>
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
