<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Читальні зали</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>

<div style="width: 1200px; margin: 0 auto;">
    <table class="table table-dark table-striped ">
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Номер</th>
            <th class="text-center" style="width: 350px;">Бібліотека</th>
            <th class="text-center">Персонал</th>
            <th colspan="2"><a class="btn btn-light" href="/ui/reading-rooms/create" style="width: 100%;">Додати</a></th>
        </tr>
        <#list readingRooms as readingRoom>
            <tr>
                <td class="text-center">${readingRoom.id}</td>
                <td class="text-center">${readingRoom.number}</td>
                <td class="text-center">${readingRoom.library.name}</td>
                <td class="text-center">
                    <ul>
                        <#list readingRoom.staffs as staff>
                            <li>${staff.name}</li>
                        </#list>
                    </ul>
                </td>
                <td><a href="/ui/reading-rooms/delete/${readingRoom.id}">
                        <button type="button" class="btn btn-light">Видалити</button>
                    </a></td>
                <td><a href="/ui/reading-rooms/update/${readingRoom.id}">
                        <button type="button" class="btn btn-light">Редагувати</button>
                    </a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/reading-rooms/create">Додати</a>
</div>
</body>
</html>
