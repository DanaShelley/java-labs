<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Workers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style="width: 1200px; margin: 0 auto;">
    <table class="table table-dark table-striped ">
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Name</th>
            <th class="text-center">Library</th>
            <th class="text-center">WorkerID</th>
            <th></th>
            <th></th>
        </tr>
        <#list workers as worker>
            <tr>
                <td class="text-center">${worker.id}</td>
                <td class="text-center">${worker.membership.name}</td>
                <td class="text-center">${worker.library.name}</td>
                <td class="text-center">${worker.workerId}</td>

                <td><a href="/ui/workers/delete/${worker.id}">
                        <button type="button" class="btn btn-light">Delete</button>
                    </a></td>
                <td><a href="/ui/workers/update/${worker.id}">
                        <button type="button" class="btn btn-light">Update</button>
                    </a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/workers/create">Create</a>
</div>

</body>
</html>