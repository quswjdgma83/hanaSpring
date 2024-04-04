package com.hana.addr;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.service.AddrService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

@SpringBootTest
@Slf4j
class InsertTests {

    @Autowired
    AddrService addrService;
    @Test
    void contextLoads() {
//        AddrDto addrDto = AddrDto.builder().addrId(1).addrName("정릉천동로36").addrDetail("101동 2005호").custId("id96").build();
        AddrDto addrDto = AddrDto.builder().addrName("정릉천동로36").addrDetail("101동 2006호").custId("id96").build();
//        AddrDto addrDto = AddrDto.builder().addrName("우리집2").addrDetail("서울").custId("id03").build();
        try {
            addrService.add(addrDto);
            log.info("----------OK----------------");
        } catch (Exception e) {
            if(e instanceof SQLException){
                log.info("-----------System Trouble EX0001----------");
            } else if (e instanceof DuplicateKeyException) {
                log.info("------ID Duplicated EX0002------");
            } else{
                log.info("----------------Sorry EX0003------------------");
            }
            e.printStackTrace();
        }
    }
}
