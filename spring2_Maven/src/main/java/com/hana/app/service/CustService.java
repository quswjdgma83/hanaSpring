package com.hana.app.service;

import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIDException;
import com.hana.app.exception.IdNotFoundException;
import com.hana.app.frame.Dao;
import com.hana.app.frame.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class CustService implements Service<String, CustDto> {
    @Autowired
    Dao<String, CustDto> dao;

    @Override
    public int add(CustDto custDto) throws DuplicatedIDException {
        System.out.println("Start TR ....");
        // Insert ...
        try {
//            dao.insert(custDto);
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
