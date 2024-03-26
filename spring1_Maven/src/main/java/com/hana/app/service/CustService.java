package com.hana.service;

import com.hana.data.CustDto;
import com.hana.exception.DuplicatedIDException;
import com.hana.exception.IdNotFoundException;
import com.hana.exception.NotFoundException;
import com.hana.frame.Dao;
import com.hana.frame.Service;
import com.hana.repository.CustDao;

import java.util.List;

public class CustService implements Service<String, CustDto> {

    Dao<String, CustDto> dao;

    public CustService(){
        dao = new CustDao();
    }


    @Override
    public int add(CustDto custDto) throws DuplicatedIDException {
        System.out.println("Start TR ....");
        // Insert ...
        try {
            dao.insert(custDto);
            dao.insert(custDto);
            System.out.println("COMMIT ...");
        } catch (DuplicatedIDException e) {
            System.out.println("ROLLBACK ...");
            throw e;
        } finally {
            System.out.println("End TR ...");
        }
        System.out.println("End TR ...");
        // SMS ..
        System.out.println("Send SMS ....");
        return 0;
    }

    @Override
    public int del(String s) throws IdNotFoundException {
        dao.delete(s);
        return 0;
    }

    @Override
    public int modify(CustDto custDto) throws Exception {
        dao.update(custDto);
        return 0;
    }

    @Override
    public CustDto get(String s) throws Exception {
        return dao.select(s);
    }

    @Override
    public List<CustDto> get() throws Exception {
        return dao.select();
    }


}
