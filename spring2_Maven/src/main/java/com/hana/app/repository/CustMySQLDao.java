package com.hana.app.repository;

import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIDException;
import com.hana.app.exception.IdNotFoundException;
import com.hana.app.frame.Dao;

import java.util.List;

public class CustMySQLDao implements Dao<String, CustDto> {

    @Override
    public int insert(CustDto custDto) throws DuplicatedIDException {
        System.out.println("Inserted MySQL");
        return 0;
    }

    @Override
    public int delete(String s) throws IdNotFoundException {
        return 0;
    }

    @Override
    public int update(CustDto custDto) throws IdNotFoundException {
        return 0;
    }

    @Override
    public CustDto select(String s) throws Exception {
        return null;
    }

    @Override
    public List<CustDto> select() throws Exception {
        return null;
    }
}
