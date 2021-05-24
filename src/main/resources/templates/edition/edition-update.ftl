<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Редагувати видання</title>
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
    <h2>Редагувати видання</h2>
    <form name="editionForm" action="" method="POST" class="row g-3">
        <div class="form-group">
            <label for="name" class="form-label">Назва: </label>
            <input type="text" name="name" id="name" class="form-control" placeholder="Герой нашого часу" required
                   value="${edition.name}">
        </div>

        <div class="form-group">
            <label for="year" class="form-label">Рік публікації: </label>
            <input type="number" name="year" id="year" class="form-control" placeholder="1998" required max="2021"
                   value="${year}">
        </div>

        <div class="form-group">
            <label for="numberOfPages" class="form-label">Кількість сторінок: </label>
            <input type="number" name="numberOfPages" id="numberOfPages" class="form-control" placeholder="320" required
                   min="0" value="${edition.numberOfPages}">
        </div>

        <div class="form-group">
            <label for="genre" class="form-label">Жанр: </label>
            <input type="text" name="genre" id="genre" class="form-control" placeholder="фентезі" required
                   value="${edition.genre}">
        </div>

        <div class="form-group">
            <label for="category" class="form-label">Категорія: </label>
            <input type="text" name="category" id="category" class="form-control" placeholder="роман" required
                   value="${edition.category}">
        </div>

        <div class="form-group">
            <label for="stockNumber" class="form-label">Номенклатурний номер: </label>
            <input type="text" name="stockNumber" id="stockNumber" class="form-control" placeholder="15561" required
                   value="${edition.stockNumber}">
        </div>

        <#function selected list1 item2>
            <#list list1 as item1>
                <#if item1.id==item2.id>
                    <#return "selected">
                </#if>
            </#list>
            <#return "">
        </#function>

        <div class="form-group">
            <label for="writings" class="form-label">Твори: </label>
            <select class="form-control" name="writings" id="writings" multiple>
                <#list writings as writing>
                    <option value="${writing.id}"
                            name="${writing.name}" ${selected(editionWritings, writing)}>${writing.name}</option>
                </#list>
            </select>
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