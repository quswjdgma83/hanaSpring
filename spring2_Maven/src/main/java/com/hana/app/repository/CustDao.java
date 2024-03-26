package com.hana.app.repository;

import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIDException;
import com.hana.app.exception.IdNotFoundException;
import com.hana.app.frame.Dao;

import java.util.ArrayList;
import java.util.List;

public class CustDao implements Dao<String, CustDto> {
    @Override
    public int insert(CustDto custDto) throws DuplicatedIDException {
        //System.out.println("Duplicated ID Exception ");
        if(custDto.getId().equals("id01")){
//            System.out.println("Duplicated ID Exception");
            throw new DuplicatedIDException("");
        }
        System.out.println("Oracle DB:Inserted ... "+custDto);
        return 0;
    }

    @Override
    public int delete(String s) throws IdNotFoundException {
        System.out.println("Oracle DB:Deleted ... "+s);
        return 0;
    }

    @Override
    public int update(CustDto custDto) throws IdNotFoundException{
        System.out.println("Oracle DB:Updated ... "+custDto);
        return 0;
    }

    @Override
    public CustDto select(String s) throws Exception{
        return CustDto.builder().id(s).pwd("pwd01").name("james").build();
    }

    @Override
    public List<CustDto> select() throws Exception{
        List<CustDto> list = new ArrayList<>();
        list.add(CustDto.builder().id("id01").pwd("pwd01").name("james").build());
        list.add(CustDto.builder().id("id02").pwd("pwd02").name("james").build());
        list.add(CustDto.builder().id("id03").pwd("pwd03").name("james").build());
        return list;
    }
}
