<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update schoolchild</title>
    <link rel="stylesheet" href="https://snipp.ru/cdn/select2/4.0.13/dist/css/select2.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/select2-bootstrap-theme/0.1.0-beta.10/select2-bootstrap.min.css"
          integrity="sha512-kq3FES+RuuGoBW3a9R2ELYKRywUEQv0wvPTItv3DSGqjpbNtGWVdvT8qwdKkqvPzT93jp8tSF4+oN4IeTEIlQA=="
          crossorigin="anonymous"/>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>

<body>
<div style="width: 25%; margin: 0 auto">
    <h2>Edit schoolchild</h2>

    <form name="schoolchildForm" action="" method="POST" class="row g-3">

        <div class="form-group">
            <label for="membership" class="form-label">Membership: </label>
            <select class="form-control" name="membership" id="membership" required>
                <option value="${schoolchild.membership.id}" name="${schoolchild.membership.id}"
                        selected>${schoolchild.membership.name}</option>
            </select>
        </div>

        <div class="form-group">
            <label for="school" class="form-label">School: </label>
            <input type="text" name="school" id="school" class="form-control" placeholder="Гімназія №5" required
                   value="${schoolchild.school}">
        </div>

        <div class="form-group">
            <label for="grade" class="form-label">Grade: </label>
            <input type="number" name="grade" id="grade" class="form-control" placeholder="6" min="0" required
                   value="${schoolchild.grade}">
        </div>

        <div class="form-group">
            <label for="age" class="form-label">Age: </label>
            <input type="number" name="age" id="age" class="form-control" placeholder="12" min="1" max="12" required
                   value="${schoolchild.age}">
        </div>

        <button class="btn btn-primary" type="submit">Update</button>
    </form>
</div>


<script src="https://snipp.ru/cdn/jquery/2.1.1/jquery.min.js"></script>
<script src="https://snipp.ru/cdn/select2/4.0.13/dist/js/select2.min.js"></script>
<script src="https://snipp.ru/cdn/select2/4.0.13/dist/js/i18n/ru.js"></script>
<script>
    $(document).ready(function () {
        $('select').select2({
            theme: "bootstrap"
        });
    });
</script>

</body>
</html>