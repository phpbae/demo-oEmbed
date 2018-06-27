package com.example.demo.business.component;

import com.example.demo.business.util.CustomStatus;
import com.example.demo.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OembedAPIComponent {

    private RestTemplate restTemplate;

    private final static String YOUTUBE_OEMBED_API_ENDPOINT = "http://www.youtube.com/oembed?url=";
    private final static String VIMEO_OEMBED_API_ENDPOINT = "https://vimeo.com/api/oembed.json?url=";


    public ResponseEntity<String> getOembedResponseJSON(String url) throws CustomException {
        restTemplate = new RestTemplate();
        String apiUrl = "";
        if(url.contains("youtube")){
            apiUrl = OembedAPIComponent.YOUTUBE_OEMBED_API_ENDPOINT;
        }else if(url.contains("vemeo")){
            apiUrl = OembedAPIComponent.VIMEO_OEMBED_API_ENDPOINT;
        }

        if(apiUrl.equals("")){
            throw new CustomException(String.valueOf(CustomStatus.FAILED_TO_SPECIFY_ENDPOINT));
        }

        StringBuilder builder = new StringBuilder(apiUrl);
        builder.append(url);
        if (url.contains("youtube")) {
            builder.append("&format=json");
        }
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.toString(), String.class);
        return responseEntity;
    }


}
