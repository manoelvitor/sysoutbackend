package com.projeto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ControllerInterface<T> {
    ResponseEntity<List<T>> getAll(Long idEmpresa);

    ResponseEntity<?> get(Long id);

    ResponseEntity<T> post(T obj);

    ResponseEntity<?> put(T obj);

    ResponseEntity<?> delete(Long id);
}
