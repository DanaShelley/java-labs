package edu.hav.labs.service.membership.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IMembershipService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Membership;
import org.bson.Document;

import java.time.LocalDate;
import java.util.List;

public interface IMembershipService {
    Membership getById(String id);
    Membership create(Membership membership);
    Membership update(Membership membership);
    Membership delete(String id);
    List<Membership> getAll();
    List<Document> getMembershipsServiceByStaff(String staffId, LocalDate date1, LocalDate date2);
    List<Membership> getMembershipsWhoOverdueDeadLine();
}
