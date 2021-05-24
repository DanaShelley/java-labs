<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Books Held By Membership</title>
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
            <th class="text-center">Date of lending</th>
            <th class="text-center">Delivery date</th>
            <th></th>
            <th></th>
        </tr>
        <#list booksHeldByMembership as bookHeldByMembership>
            <tr>
                <td class="text-center">${bookHeldByMembership.id}</td>
                <td class="text-center">${bookHeldByMembership.book.edition.name}</td>
                <td class="text-center">${bookHeldByMembership.membership.name}</td>
                <td class="text-center">${bookHeldByMembership.dateOfLending}</td>
                <td class="text-center">${bookHeldByMembership.deliveryDate}</td>

                <td><a href="/ui/books-held-by-membership/delete/${bookHeldByMembership.id}">
                        <button type="button" class="btn btn-light">Delete</button>
                    </a></td>
                <td><a href="/ui/books-held-by-membership/update/${bookHeldByMembership.id}">
                        <button type="button" class="btn btn-light">Update</button>
                    </a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-success" href="/ui/books-held-by-membership/create">Create</a>
</div>

</body>
</html>