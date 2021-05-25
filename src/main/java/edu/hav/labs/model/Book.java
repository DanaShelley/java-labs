package edu.hav.labs.model;
/*
  @author   Bohdana Havaleshko
  @project   coursework
  @class  Book
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
@Schema(description = "Book Document")
@Document(collection = "book")
public class Book {
    @Id
    private String id;
    private Edition edition;
    private Membership membership;
    private Rule rule;
    private StorageRoom storageRoom;
    private int stellageNumber;
    private int shelveNumber;
    private String inventoryNumber;
    private LocalDate dateOdReceipt;
    private boolean isDecommissioned;
}
