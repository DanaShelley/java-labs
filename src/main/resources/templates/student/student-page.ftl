<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style="width: 1200px; margin: 0 auto;">
    <table class="table table-dark table-striped ">
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Name</th>
            <th class="text-center">University</th>
            <th class="text-center">Faculty</th>
            <th class="text-center">StudentID</th>
            <th></th>
            <th></th>
        </tr>
        <#list students as student>
            <tr>
                <td class="text-center">${student.id}</td>
                <td class="text-center">${student.membership.name}</td>
                <td class="text-center">${student.university}</td>
                <td class="text-center">${student.faculty}</td>
                <td class="text-center">${student.studentId}</td>

                <td><a href="/ui/students/delete/${student.id}">
                        <button type="button" class="btn btn-light">Delete</button>
                    </a></td>
                <td><a href="/ui/students/update/${student.id}">
                        <button type="button" class="btn btn-light">Update</button>
                    </a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/students/create">Create</a>
</div>

</body>
</html>