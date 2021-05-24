package edu.hav.labs.service.pensioner.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IPensionerService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Pensioner;

import java.util.List;

public interface IPensionerService {
    Pensioner getById(String id);
    Pensioner create(Pensioner pensioner);
    Pensioner update(Pensioner pensioner);
    Pensioner delete(String id);
    List<Pensioner> getAll();

}
