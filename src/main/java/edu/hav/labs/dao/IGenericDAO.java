package edu.hav.labs.dao;

import java.util.List;

public interface IGenericDAO<E> {
    E getById(String id);
    E create(E item);
    E update(E item);
    E delete(String id);
    List<E> getAll();
}
