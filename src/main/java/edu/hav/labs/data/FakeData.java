package edu.hav.labs.data;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import edu.hav.labs.model.Library;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FakeData {

    private List<Library> libraries = new ArrayList<>(

            Arrays.asList(

                    new Library("1", "Бібліотека Чернівецького училища мистецтв імені Сидора Воробкевича", "м.Чернівці, вул. Братів Руснаків, 11", 2000, 3000),
                    new Library("2", "Муніципальна бібліотека імені Анатолія Добрянського", "м.Чернівці, вул. Українська, 22", 2500, 1000),
                    new Library("3", "Наукова бібліотека Чернівецького національного університету імені Юрія Федьковича", "м.Чернівці, вул. Лесі Українки, 23", 6000, 1200),
                    new Library("4", "Центральна міська бібліотека міста Чернівці", "м.Чернівці, вул. Головна, 162", 7000, 2000)
            )
    );

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }
}
