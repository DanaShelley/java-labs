<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Writings</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style="width: 1200px; margin: 0 auto;">
<div style="width: 1200px; margin: 0 auto;">
    <table class="table table-dark table-striped ">
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Назва</th>
            <th class="text-center">Автори</th>
            <th class="text-center">Рік написання</th>
            <th class="text-center">Кількість сторінок</th>
            <th class="text-center">Жанр</th>
            <th class="text-center">Категорія</th>
            <th colspan="2"><a class="btn btn-light" href="/ui/writings/create" style="width: 100%;">Додати</a></th>

        </tr>
        <#list writings as writing>
            <tr>
                <td class="text-center">${writing.id}</td>
                <td class="text-center">${writing.name}</td>
                <td class="text-center">
                    <ul>
                        <#list writing.authors as author>
                            <li>${author}</li>
                        </#list>
                    </ul>
                </td>
                <td class="text-center">${writing.yearOfWriting}</td>
                <td class="text-center">${writing.numberOfPages}</td>
                <td class="text-center">${writing.genre}</td>
                <td class="text-center">${writing.category}</td>
                <td><a href="/ui/writings/delete/${writing.id}">
                        <button type="button" class="btn btn-light">Видалити</button>
                    </a></td>
                <td><a href="/ui/writings/update/${writing.id}">
                        <button type="button" class="btn btn-light">Редагувати</button>
                    </a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/writings/create">Додати</a>
</div>
</body>
</html>