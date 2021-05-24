<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Staff Logs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style="width: 1200px; margin: 0 auto;">
    <table class="table table-dark table-striped ">
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Staff name</th>
            <th class="text-center">Library</th>
            <th class="text-center">Reading room</th>
            <th class="text-center">Start date</th>
            <th class="text-center">End date</th>
            <th></th>
            <th></th>
        </tr>
        <#list staffLogs as staffLog>
            <tr>
                <td class="text-center">${staffLog.id}</td>
                <td class="text-center">${staffLog.staff.name}</td>
                <td class="text-center">${staffLog.readingRoom.library.name}</td>
                <td class="text-center">${staffLog.readingRoom.number}</td>
                <td class="text-center">${staffLog.startDate}</td>
                <td class="text-center"><#if staffLog.endDate??>
                        ${staffLog.endDate}
                    </#if></td>

                <td><a href="/ui/staff-log/delete/${staffLog.id}">
                        <button type="button" class="btn btn-light">Delete</button>
                    </a></td>
                <td><a href="/ui/staff-log/update/${staffLog.id}">
                        <button type="button" class="btn btn-light">Update</button>
                    </a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/staff-log/create">Create</a>
</div>

</body>
</html>