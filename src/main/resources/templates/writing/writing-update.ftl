<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Редагувати твір</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style="width: 500px; margin: 0 auto">
    <h2>Редагувати твір</h2>
    <form name="writingForm" action="" method="POST" class="row g-3">
        <div class="form-group">
            <label for="name" class="form-label">Назва: </label>
            <input type="text" name="name" id="name" class="form-control" placeholder="Гаррі Поттер і філософський камінь" required value="${writing.name}">
        </div>

        <div class="form-group">
            <label for="authors" class="form-label">Автори: </label>
            <input type="text" name="authors" id="authors" class="form-control" placeholder="Джоан Роулінг" required value="${authors}">
        </div>

        <div class="form-group">
            <label for="yearOfWriting" class="form-label">Рік написання: </label>
            <input type="number" name="yearOfWriting" id="yearOfWriting" class="form-control" placeholder="320" required min="0" value="${yearOfWriting}">
        </div>

        <div class="form-group">
            <label for="numberOfPages" class="form-label">Кількість сторінок: </label>
            <input type="number" name="numberOfPages" id="numberOfPages" class="form-control" placeholder="320" required min="0" value="${numberOfPages}">
        </div>

        <div class="form-group">
            <label for="genre" class="form-label">Жанр: </label>
            <input type="text" name="genre" id="genre" class="form-control" placeholder="фентезі" required value="${writing.genre}">
        </div>

        <div class="form-group">
            <label for="category" class="form-label">Категорія: </label>
            <input type="text" name="category" id="category" class="form-control" placeholder="роман" required value="${writing.category}">
        </div>

        <button class="btn btn-primary" type="submit">Редагувати</button>
    </form>
</div>
</body>
</html>