package edu.hav.labs.repository.membership;
/*
  @author   Bohdana Havaleshko
  @project   coursework
  @interface  MembershipRepository
  @version  1.0.0 
  @since 20.04.2021
*/


import edu.hav.labs.model.Membership;
import org.springframework.data.repository.CrudRepository;

public interface MembershipRepository extends CrudRepository<Membership, String> {
}
