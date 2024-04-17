package com.hana.ncp;

import org.springframework.beans.factory.annotation.Value;

public class SummeryTests {
    @Value("${app.key.ncp-id}")
    String ncpId;
    @Value("${app.key.ncp-secret}")
    String ncpSecret;
}
