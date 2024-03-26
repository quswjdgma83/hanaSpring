package com.hana.frame;

import com.hana.exception.DuplicatedIDException;
import com.hana.exception.IdNotFoundException;
import com.hana.exception.NotFoundException;

import java.util.List;

public interface Service<K, V> {
    int add(V v) throws DuplicatedIDException;
    int del(K k) throws IdNotFoundException;
    int modify(V v) throws Exception;
    V get(K k) throws NotFoundException, Exception;
    List<V> get() throws NotFoundException, Exception;
}
