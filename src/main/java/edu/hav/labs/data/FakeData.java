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

                    new Library("1", "Library 1", "Address 1", 2000, 3000),
                    new Library("2", "Library 2", "Address 2", 2500, 1000),
                    new Library("3", "Library 3", "Address 3", 6000, 1200),
                    new Library("4", "Library 4", "Address 4", 7000, 2000)
            )
    );

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }
}