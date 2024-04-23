package com.example.university2.service;

import java.util.List;

public interface Service<T> {
    List<T> getAll();
    public void add(T t);
    public void delete(Long id);
    T get(Long id);
}
