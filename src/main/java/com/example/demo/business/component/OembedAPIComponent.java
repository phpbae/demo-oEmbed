package com.example.demo.business.component;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OembedAPIComponent {

    private RestTemplate restTemplate;

    public ResponseEntity<String> getOembedResponse(String url, String apiUrl) {
        restTemplate = new RestTemplate();
        StringBuilder builder = new StringBuilder(apiUrl);
        builder.append(url);
        if (url.contains("youtube")) {
            builder.append("&format=json");
        }
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.toString(), String.class);
        return responseEntity;
    }


}
