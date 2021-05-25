package edu.hav.labs.service.bookHeldByMembership.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IBookHeldByMembership
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.BookHeldByMembership;

import java.util.List;

public interface IBookHeldByMembershipService {
    BookHeldByMembership getById(String id);
    BookHeldByMembership create(BookHeldByMembership bookHeldByMembership);
    BookHeldByMembership update(BookHeldByMembership bookHeldByMembership);
    BookHeldByMembership delete(String id);
    List<BookHeldByMembership> getAll();
    List<BookHeldByMembership> findAllByBook_Edition_Id(String id);
}
