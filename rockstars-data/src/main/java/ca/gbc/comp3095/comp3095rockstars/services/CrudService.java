package ca.gbc.comp3095.comp3095rockstars.services;

import java.util.Set;

public interface CrudService<T, ID>{

    Set<T> findAll();

    T findById(ID id);

    void delete(T object);

    void deleteById(ID id);
}
