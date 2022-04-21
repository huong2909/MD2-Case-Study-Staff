package com.company.service;

import java.io.IOException;
import java.util.List;

public interface IServiceGeneric<T> {
    List<T> findAll() ;
    void save(T t) ;
    void delete(int id);

}
