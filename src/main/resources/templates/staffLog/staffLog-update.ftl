<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update staff log</title>
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
    <h2>Edit staff log</h2>

    <form name="staffLogForm" action="" method="POST" class="row g-3">

        <div class="form-group">
            <label for="staff" class="form-label">Staff: </label>
            <select class="form-control" name="staff" id="staff" required>
                <#list staffs as staff>
                    <option value="${staff.id}" name="${staff.id}"
                            <#if staff.id == staffLog.staff.id>selected</#if>>${staff.name}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label for="readingRoom" class="form-label">Reading room: </label>
            <select class="form-control" name="readingRoom" id="readingRoom" required>
                <#list readingRooms as readingRoom>
                    <option value="${readingRoom.id}" name="${readingRoom.id}"
                            <#if readingRoom.id == staffLog.readingRoom.id>selected</#if>>${readingRoom.number}
                        - ${readingRoom.library.name}</option>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <label for="startDate" class="form-label">Start date: </label>
            <input type="date" name="startDate" id="startDate" class="form-control" value="${staffLog.startDate}"
                   required>
        </div>

        <div class="form-group">
            <label for="endDate" class="form-label">End date: </label>
            <input type="date" name="endDate" id="endDate" class="form-control" <#if staffLog.endDate??>
                value="${staffLog.endDate}"
                    </#if>>
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
