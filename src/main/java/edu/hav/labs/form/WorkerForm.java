package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  WorkerForm
  @version  1.0.0 
  @since 15.05.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkerForm {
    private String membership;
    private String library;
    private String workerId;

    public WorkerForm() {
        this.membership = "";
        this.library = "";
        this.workerId = "";
    }
}

