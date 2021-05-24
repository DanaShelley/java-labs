<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Редагувати посаду</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>

<div style="width: 500px; margin: 0 auto">
    <h2>Редагувати посаду</h2>
    <form name="position" action="" method="POST" class="row g-3">
        <div class="form-group">
            <label for="position" class="form-label">Посада: </label>
            <input type="text" name="position" id="position" class="form-control" placeholder="Бібліотекар" required
                   value="${position.position}">
        </div>

        <div class="form-group">
            <label for="salary" class="form-label">Заробітна плата: </label>
            <input type="number" name="salary" id="salary" class="form-control" placeholder="8000" min="3000" step="100"
                   required value="${salary}">
        </div>

        <button class="btn btn-primary" type="submit">Редагувати</button>
    </form>
</div>
</body>
</html>