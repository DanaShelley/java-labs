package edu.hav.labs.model;
/*
  @author   Bohdana Havaleshko
  @project   coursework
  @class  BookHeldByMembership
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
@Schema(description = "Book held by membership Document")
@Document(collection = "bookHeldByMembership")
public class BookHeldByMembership {
    @Id
    private String id;
    private Book book;
    private Membership membership;
    private LocalDate dateOfLending;
    private LocalDate deliveryDate;

}
