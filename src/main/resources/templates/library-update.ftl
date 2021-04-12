<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Library</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<h1>Update</h1>

<div style="width: 25%">
    <legend>Update library</legend>
    <form name="library" action="" method="POST">
        <div class="form-group">
            <label for="library">Name:</label>
            <@spring.formInput "libraryForm.name" "class='form-control'" "text"/>
        </div>

        <div class="form-group">
            <label for="library">Address:</label>
            <@spring.formInput "libraryForm.address" "class='form-control'" "text"/>            </div>

        <div class="form-group">
            <label for="library">Number of books:</label>
            <@spring.formInput "libraryForm.numberOfBooks" "class='form-control'" "number"/>
        </div>

        <div class="form-group">
            <label for="library">Number of membership:</label>
            <@spring.formInput "libraryForm.numberOfMembership" "class='form-control'" "number"/>
        </div>

        <input type="submit" class="btn btn-primary" value="Update"/>
    </form>
</div>
</body>
</html>
