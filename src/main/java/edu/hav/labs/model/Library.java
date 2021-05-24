package edu.hav.labs.model;
/*
  @author   Bohdana Havaleshko
  @project   coursework
  @class  Library
  @version  1.0.0 
  @since 20.04.2021
*/

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Library Document")
@Document(collection = "library")
public class Library {
    @Id
    private String id;
    @Schema(description = "Name of library", defaultValue = "New Library")
    private String name;
    private String address;
    private int numberOfBooks;
    private int numberOfMembership;
}
