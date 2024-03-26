package com.hana.app.frame;

import com.hana.app.exception.DuplicatedIDException;
import com.hana.app.exception.IdNotFoundException;

import java.util.List;

public interface Dao<K,V> {
    /**
     * 2024.3.13
     * JMLEE
     * @param v: CustDto
     * @return int
     */
    int insert(V v) throws DuplicatedIDException;
    int delete(K k) throws IdNotFoundException;
    int update(V v) throws IdNotFoundException;
    V select(K k) throws Exception;
    List<V> select() throws Exception;
}
