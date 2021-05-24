<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Schoolchildren</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style="width: 1200px; margin: 0 auto;">
    <table class="table table-dark table-striped ">
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Name</th>
            <th class="text-center">School</th>
            <th class="text-center">Grade</th>
            <th class="text-center">Age</th>
            <th></th>
            <th></th>
        </tr>
        <#list schoolchildren as schoolchild>
            <tr>
                <td class="text-center">${schoolchild.id}</td>
                <td class="text-center">${schoolchild.membership.name}</td>
                <td class="text-center">${schoolchild.school}</td>
                <td class="text-center">${schoolchild.grade}</td>
                <td class="text-center">${schoolchild.age}</td>

                <td><a href="/ui/schoolchildren/delete/${schoolchild.id}">
                        <button type="button" class="btn btn-light">Delete</button>
                    </a></td>
                <td><a href="/ui/schoolchildren/update/${schoolchild.id}">
                        <button type="button" class="btn btn-light">Update</button>
                    </a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/schoolchildren/create">Create</a>
</div>

</body>
</html>