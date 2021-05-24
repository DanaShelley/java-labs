<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Memberships</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style="width: 100%; margin: 0 auto;">
    <table class="table table-dark table-striped ">
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Видання</th>
            <th class="text-center">Користувач</th>
            <th class="text-center">Правило</th>
            <th class="text-center">Бібліотека</th>
            <th class="text-center">Сховище</th>
            <th class="text-center">Стелаж</th>
            <th class="text-center">Полиця</th>
            <th class="text-center">Дата надходження</th>
            <th class="text-center">Списання</th>
            <th colspan="11"><a class="btn btn-light" href="/ui/books/create" style="width: 100%;">Додати</a></th>

        </tr>
        <#list books as book>
            <tr>
                <td class="text-center">${book.id}</td>
                <td class="text-center">${book.edition.name}</td>
                <td class="text-center"><#if book.membership??>
                        ${book.membership.name}
                    </#if></td>
                <td class="text-center">${book.rule.rule}</td>
                <td class="text-center">${book.storageRoom.library.name}</td>
                <td class="text-center">${book.storageRoom.number}</td>
                <td class="text-center">${book.stellageNumber}</td>
                <td class="text-center">${book.shelveNumber}</td>
                <td class="text-center">${book.dateOdReceipt}</td>
                <td class="text-center"><#if book.decommissioned == true>так<#else>ні</#if></td>
                <td><a href="/ui/books/delete/${book.id}">
                        <button type="button" class="btn btn-light">Видалити</button>
                    </a></td>
                <td><a href="/ui/books/update/${book.id}">
                        <button type="button" class="btn btn-light">Редагувати</button>
                    </a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/books/create">Додати</a>
</div>

</body>
</html>