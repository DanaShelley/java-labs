<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Editions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>

<div style="width: 100%; margin: 0 auto;">
    <table class="table table-dark table-striped ">
        <tr style="word-wrap: break-word">
            <th class="text-center">ID</th>
            <th class="text-center">Назва</th>
            <th class="text-center">Рік публікації</th>
            <th class="text-center">Категорія</th>
            <th class="text-center">Кількість сторінок</th>
            <th class="text-center">Номенклатурний номер</th>
            <th class="text-center">Твори</th>
            <th colspan="2"><a class="btn btn-light" href="/ui/editions/create" style="width: 100%;">Додати</a></th>
        </tr>
        <#list editions as edition>
            <tr>
                <td class="text-center">${edition.id}</td>
                <td class="text-center">${edition.name}</td>
                <td class="text-center">${edition.year}</td>
                <td class="text-center">${edition.category}</td>
                <td class="text-center">${edition.numberOfPages}</td>
                <td class="text-center">${edition.stockNumber}</td>
                <td class="text-center">
                    <ul>
                        <#list edition.writings as writing>
                            <li>${writing.name}</li>
                        </#list>
                    </ul>
                </td>
                <td><a href="/ui/editions/delete/${edition.id}">
                        <button type="button" class="btn btn-light">Видалити</button>
                    </a></td>
                <td><a href="/ui/editions/update/${edition.id}">
                        <button type="button" class="btn btn-light">Редагувати</button>
                    </a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/editions/create">Додати</a>
</div>

</body>
</html>