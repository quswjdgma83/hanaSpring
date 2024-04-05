package com.hana.app.frame;

import com.hana.app.exception.DuplicatedIDException;
import com.hana.app.exception.IdNotFoundException;
import com.hana.app.exception.NotFoundException;

import java.util.List;

public interface Service<K, V> {
    int add(V v) throws DuplicatedIDException;
    int del(K k) throws IdNotFoundException;
    int modify(V v) throws Exception;
    V get(K k) throws NotFoundException, Exception;
    List<V> get() throws NotFoundException, Exception;
}
