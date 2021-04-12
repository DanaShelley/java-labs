package edu.hav.labs.controller.rest;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class CommonController {

    @RequestMapping(value = "/titulka/{name}")
    public String ShowTitulka(@PathVariable String name) {
        return "<body\n" +
                "  style=\"display: flex; flex-direction: column; align-items: center; width: 840px; height: 1188px; padding: 30px; margin-right: auto; margin-left: auto; box-sizing: border-box; font-family: 'Times New Roman', sans-serif; font-size: 21px;\">\n" +
                "<header class=\"header\" style=\"text-align: center; margin-bottom: 90px;\">\n" +
                "  <h3 style=\" font-size: 21px;\">\n" +
                "    Міністерство освіти і науки України <br>\n" +
                "    Чернівецький національний університет імені Юрія Федьковича <br>\n" +
                "    Інститут фізико-технічних та комп’ютерних наук <br>\n" +
                "    Кафедра програмного забезпечення комп’ютерних систем\n" +
                "  </h3>\n" +
                "</header>\n" +
                "<main class=\"main\" style=\"text-align: center; width: 840px;\">\n" +
                "  <h1 style=\"font-size: 30px; margin-bottom: 10px;\">Робота з базами данних <br> (бібліотечний фонд)</h1>\n" +
                "  <h2 style=\"font-size: 21px;\">КУРСОВИЙ ПРОЕКТ (РОБОТА)</h2>\n" +
                "  <h3 style=\"font-size: 21px;\">Рівень вищої освіти – перший (бакалаврський)</h3>\n" +
                "  <div style=\"width: 50%; margin-left: auto; text-align:left; margin-top: 150px; margin-bottom: 60px;\">\n" +
                "    Виконав (ла): студент (ка) 2 курсу, групи 243 спеціальності <br>\n" +
                "    <u>121 – Інженерія програмного забезпечення</u> <br>\n" +
                "    <small style=\"display:block;text-align:center; font-size: 15px;\">(шифр – назва спеціальності)</small>\n" +
                "    <u style=\"display:block;\">&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;" + name + "</u>\n" +
                "    <span style=\"display:block; text-align: center;\">(прізвище, ім’я, по-батькові студента)</span>\n" +
                "    Керівник <u>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Прохоров Г. В.</u> <br>\n" +
                "    <small style=\"display:block;text-align:center; font-size: 15px;\">(підпис) (прізвище та ініціали)</small> <br>\n" +
                "  </div>\n" +
                "  <div style=\"width: 65%;text-align: left; margin-bottom: 40px;\">\n" +
                "    Нормоконтролер ________________________ <br>\n" +
                "    <small style=\"display:block;text-align:center; font-size: 15px;\">(підпис) (прізвище та ініціал)</small>\n" +
                "  </div>\n" +
                "  <div style=\"text-align: left;\">\n" +
                "    <b style=\"display:block; margin-bottom: 10px;\">До захисту допущено:</b>\n" +
                "    <b>Протокол засідання кафедри №___</b> <br>\n" +
                "    від „<u>&ensp;&ensp;</u>” 2020 р. <br>\n" +
                "    зав. кафедри <u>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</u> проф. Остапов С.Е.\n" +
                "  </div>\n" +
                "\n" +
                "</main>\n" +
                "<br>\n" +
                "<footer class=\"footer\" style=\"margin-top: auto;\">\n" +
                "  Чернівці – 2021\n" +
                "</footer>\n" +
                "</body>";
    }

    @RequestMapping("/titulka")
    public String ShowTitulka() {
        return "<body\n" +
                "  style=\"display: flex; flex-direction: column; align-items: center; width: 840px; height: 1188px; padding: 30px; margin-right: auto; margin-left: auto; box-sizing: border-box; font-family: 'Times New Roman', sans-serif; font-size: 21px;\">\n" +
                "<header class=\"header\" style=\"text-align: center; margin-bottom: 90px;\">\n" +
                "  <h3 style=\" font-size: 21px;\">\n" +
                "    Міністерство освіти і науки України <br>\n" +
                "    Чернівецький національний університет імені Юрія Федьковича <br>\n" +
                "    Інститут фізико-технічних та комп’ютерних наук <br>\n" +
                "    Кафедра програмного забезпечення комп’ютерних систем\n" +
                "  </h3>\n" +
                "</header>\n" +
                "<main class=\"main\" style=\"text-align: center; width: 840px;\">\n" +
                "  <h1 style=\"font-size: 30px; margin-bottom: 10px;\">Робота з базами данних <br> (бібліотечний фонд)</h1>\n" +
                "  <h2 style=\"font-size: 21px;\">КУРСОВИЙ ПРОЕКТ (РОБОТА)</h2>\n" +
                "  <h3 style=\"font-size: 21px;\">Рівень вищої освіти – перший (бакалаврський)</h3>\n" +
                "  <div style=\"width: 50%; margin-left: auto; text-align:left; margin-top: 150px; margin-bottom: 60px;\">\n" +
                "    Виконав (ла): студент (ка) 2 курсу, групи 243 спеціальності <br>\n" +
                "    <u>121 – Інженерія програмного забезпечення</u> <br>\n" +
                "    <small style=\"display:block;text-align:center; font-size: 15px;\">(шифр – назва спеціальності)</small>\n" +
                "    <u style=\"display:block;\">&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;" + "Ім'я, прізвище" + "</u>\n" +
                "    <span style=\"display:block; text-align: center;\">(прізвище, ім’я, по-батькові студента)</span>\n" +
                "    Керівник <u>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Прохоров Г. В.</u> <br>\n" +
                "    <small style=\"display:block;text-align:center; font-size: 15px;\">(підпис) (прізвище та ініціали)</small> <br>\n" +
                "  </div>\n" +
                "  <div style=\"width: 65%;text-align: left; margin-bottom: 40px;\">\n" +
                "    Нормоконтролер ________________________ <br>\n" +
                "    <small style=\"display:block;text-align:center; font-size: 15px;\">(підпис) (прізвище та ініціал)</small>\n" +
                "  </div>\n" +
                "  <div style=\"text-align: left;\">\n" +
                "    <b style=\"display:block; margin-bottom: 10px;\">До захисту допущено:</b>\n" +
                "    <b>Протокол засідання кафедри №___</b> <br>\n" +
                "    від „<u>&ensp;&ensp;</u>” 2020 р. <br>\n" +
                "    зав. кафедри <u>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</u> проф. Остапов С.Е.\n" +
                "  </div>\n" +
                "\n" +
                "</main>\n" +
                "<br>\n" +
                "<footer class=\"footer\" style=\"margin-top: auto;\">\n" +
                "  Чернівці – 2021\n" +
                "</footer>\n" +
                "</body>";
    }


}
