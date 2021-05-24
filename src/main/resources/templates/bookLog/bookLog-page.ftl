<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Logs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style="width: 1200px; margin: 0 auto;">
    <table class="table table-dark table-striped ">
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Book</th>
            <th class="text-center">Membership</th>
            <th class="text-center">Staff</th>
            <th class="text-center">Date</th>
            <th></th>
            <th></th>
        </tr>
        <#list bookLogs as bookLog>
            <tr>
                <td class="text-center">${bookLog.id}</td>
                <td class="text-center">${bookLog.book.edition.name}</td>
                <td class="text-center">${bookLog.membership.name}</td>
                <td class="text-center">${bookLog.staff.name}</td>
                <td class="text-center">${bookLog.date}</td>

                <td><a href="/ui/book-log/delete/${bookLog.id}">
                        <button type="button" class="btn btn-light">Delete</button>
                    </a></td>
                <td><a href="/ui/book-log/update/${bookLog.id}">
                        <button type="button" class="btn btn-light">Update</button>
                    </a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/book-logs/create">Create</a>
</div>

</body>
</html>