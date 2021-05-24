<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Працівники</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style="width: 100%; margin: 0 auto;">
    <table class="table table-dark table-striped ">
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Ім'я</th>
            <th class="text-center">Мобільний номер</th>
            <th class="text-center">Бібліотека</th>
            <th class="text-center">Посада</th>
            <th class="text-center">Дата найму</th>
            <th colspan="2"><a class="btn btn-light" href="/ui/staffs/create" style="width: 100%;">Додати</a></th>
        </tr>
        <#list staffs as staff>
            <tr>
                <td class="text-center">${staff.id}</td>
                <td class="text-center">${staff.name}</td>
                <td class="text-center">${staff.phone}</td>
                <td class="text-center">${staff.library.name}</td>
                <td class="text-center">${staff.position.position}</td>
                <td class="text-center">${staff.employmentDate}</td>
                <td><a href="/ui/staffs/delete/${staff.id}">
                        <button type="button" class="btn btn-light">Видалити</button>
                    </a></td>
                <td><a href="/ui/staffs/update/${staff.id}">
                        <button type="button" class="btn btn-light">Редагувати</button>
                    </a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/staffs/create" style="margin-bottom: 20px;">Create</a>
</div>

</body>
</html>