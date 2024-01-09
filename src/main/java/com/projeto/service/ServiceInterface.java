package com.projeto.service;

import java.util.List;

import com.projeto.model.Acessorio;

public interface ServiceInterface<T> {
    T create(T obj);
    T findById(Long id); 
    List<T> findAll(Long idEmpresa);
    boolean update(T obj);
    boolean delete(Long id);
}
