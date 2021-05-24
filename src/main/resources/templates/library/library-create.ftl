<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Додати бібліотеку</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style="width: 500px; margin: 0 auto">
    <h2>Додати бібліотеку</h2>

    <form name="libraryForm" action="" method="POST" class="row g-3">
        <div class="form-group">
            <label for="name" class="form-label">Ім'я: </label>
            <input type="text" name="name" id="name" class="form-control" placeholder="Наукова бібліотека Чернівецького національного університета ім. Юрія Федьковича" required>
        </div>

        <div class="form-group">
            <label for="address" class="form-label">Адреса: </label>
            <input type="text" name="address" id="address" class="form-control" placeholder="вулиця Лесі Українки, 23" required>
        </div>

        <div class="form-group">
            <label for="numberOfBooks" class="form-label">Кількість книг: </label>
            <input type="number" name="numberOfBooks" id="numberOfBooks" class="form-control" placeholder="18000"
                   required
                   min="0">
        </div>

        <div class="form-group">
            <label for="numberOfMembership" class="form-label">Кількість користувачів: </label>
            <input type="number" name="numberOfMembership" id="numberOfMembership" class="form-control"
                   placeholder="4500" required
                   min="0">
        </div>

        <button class="btn btn-primary" type="submit">Додати</button>
    </form>
</div>
</body>
</html>
