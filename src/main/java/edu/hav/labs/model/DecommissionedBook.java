package edu.hav.labs.model;
/*
  @author   Bohdana Havaleshko
  @project   coursework
  @class  DecommissionedBook
  @version  1.0.0 
  @since 20.04.2021
*/

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Decommissioned book Document")
@Document(collection = "decommissionedBook")
public class DecommissionedBook {
    @Id
    private String id;
    private Book book;
    private LocalDate dateOfDecommission;
    @Schema(description = "the reason the book was decommissioned")
    private String reason;
}
