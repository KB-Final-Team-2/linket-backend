package com.spacebetween.linket.controller;

import com.spacebetween.linket.dto.EventJoinDto;
import com.spacebetween.linket.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/event")
public class EventController {
    static StringBuilder urlBuilder = new StringBuilder("https://www.kopis.or.kr/openApi/restful/prfplc");
    private static HttpHeaders header;
    static{
        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Autowired
    private EventService eventService;

    //openapi 부분
    @PostMapping("/{placeName}")
    public ResponseEntity<Map<String, Object>> getInfo(@PathVariable String placeName, @RequestBody EventJoinDto eventJoinDto) throws Exception {
        eventJoinDto.setPlace(placeName);
        String placeId = eventService.selectPlaceId(eventJoinDto);

        System.out.println(placeId);
        urlBuilder.append("/" + URLEncoder.encode(placeId, "UTF-8"));
        urlBuilder.append("?" + URLEncoder.encode("service", "UTF-8") + "="
                + URLEncoder.encode("11653933ac2447da843868e7cb625bdb", "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        String result = "";
        String line = "";

        Map<String,Object> answer = new HashMap<String,Object>();

        while ((line = br.readLine()) != null) {
            if (line.contains("<fcltynm>")) {
                line = line.replaceAll("<fcltynm>", "");
                line = line.replaceAll("</fcltynm>", "");
                line = line.trim();

                answer.put("placeName", line);
            } else if (line.contains("<adres>")) {
                line = line.replaceAll("<adres>", "");
                line = line.replaceAll("</adres>", "");
                line = line.trim();

                answer.put("address", line);
            } else if (line.contains("<la>")) {
                line = line.replaceAll("<la>", "");
                line = line.replaceAll("</la>", "");
                line = line.trim();

                double la = Double.parseDouble(line);
                answer.put("latitude", la);
            } else if (line.contains("<lo>")) {
                line = line.replaceAll("<lo>", "");
                line = line.replaceAll("</lo>", "");
                line = line.trim();

                double lo = Double.parseDouble(line);
                answer.put("longitude", lo);
            }
        }

        System.out.println(answer);
        return new ResponseEntity<>(answer, header, HttpStatus.OK);
    }
}

