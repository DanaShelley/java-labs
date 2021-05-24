<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Memberships</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style="width: 1200px; margin: 0 auto;">
    <table class="table table-dark table-striped ">
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Ім'я</th>
            <th class="text-center">Мобільний номер</th>
            <th class="text-center">Бібліотека</th>
            <th class="text-center">Дата реєстрації</th>
            <th class="text-center">Реєстрація дійсна до</th>
            <th colspan="2"><a class="btn btn-light" href="/ui/memberships/create" style="width: 100%;">Додати</a></th>
        </tr>
        <#list memberships as membership>
            <tr>
                <td class="text-center">${membership.id}</td>
                <td class="text-center">${membership.name}</td>
                <td class="text-center">${membership.phone}</td>
                <td class="text-center">${membership.library.name}</td>
                <td class="text-center">${membership.dateOfRegistration}</td>
                <td class="text-center">${membership.isValidUntil}</td>
                <td><a href="/ui/memberships/delete/${membership.id}"><button type="button" class="btn btn-light">Delete</button></a></td>
                <td><a href="/ui/memberships/update/${membership.id}"><button type="button" class="btn btn-light">Update</button></a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/memberships/create">Додати</a>
</div>

</body>
</html>