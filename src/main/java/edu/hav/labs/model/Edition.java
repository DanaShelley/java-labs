package edu.hav.labs.model;
/*
  @author   Bohdana Havaleshko
  @project   coursework
  @class  Edition
  @version  1.0.0 
  @since 20.04.2021
*/

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Edition Document")
@Document(collection = "edition")
public class Edition {
    @Id
    private String id;
    private String name;
    private int year;
    private String genre;
    private String category;
    private int numberOfPages;
    private String stockNumber;
    private List<Writing> writings;
}
