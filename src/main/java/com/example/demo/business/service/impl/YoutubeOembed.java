package com.example.demo.business.service.impl;

import com.example.demo.business.component.OembedAPIComponent;
import com.example.demo.business.service.Oembed;
import com.example.demo.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class YoutubeOembed implements Oembed {

    private final static String YOUTUBE_OEMBED_API = "http://www.youtube.com/oembed?url=";

    @Autowired
    private OembedAPIComponent oembedAPIComponent;

    @Override
    public Object getOembedResponse(String url) throws CustomException {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = oembedAPIComponent.getOembedResponse(url, YOUTUBE_OEMBED_API);
        } catch (RuntimeException e){
            e.printStackTrace();
            throw new CustomException("900");
        }

        if(responseEntity.getStatusCode().value() != 200){
            throw new CustomException("800");
        }

        return responseEntity.getBody();
    }
}
