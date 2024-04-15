package com.hana.weather;

import com.hana.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
class Test {

    @org.junit.jupiter.api.Test
    void contextLoads() throws IOException, ParseException {
        String key = "Mpd6Rvm3BMLZFpbl%2FJdLLpW83sfGhRtP2CTabpRjSzuBHHqSUCDfJYt7BxoozPt7lrLZ9iTDITtVLDvh%2F1ei9Q%3D%3D";
        String loc = "109";
        JSONObject jsonObject = (JSONObject) WeatherUtil.getWeather(loc, key);

        String key2 = "5ae7c11283db62206e0b6552195f7bce";
        String loc2 = "1835848";
        JSONObject jsonObject2 = (JSONObject) WeatherUtil.getWeather2(loc2, key2);

        log.info("----------LOG2----------------"+jsonObject2.toJSONString());
    }
}
