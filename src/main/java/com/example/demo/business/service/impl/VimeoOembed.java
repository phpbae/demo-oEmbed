package com.example.demo.business.service.impl;

import com.example.demo.business.component.OembedAPIComponent;
import com.example.demo.business.service.Oembed;
import com.example.demo.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VimeoOembed implements Oembed {

    private final static String VIMEO_OEMBED_API = "https://vimeo.com/api/oembed.json?url=";

    @Autowired
    private OembedAPIComponent oembedAPIComponent;

    @Override
    public Object getOembedResponse(String url) throws CustomException {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = oembedAPIComponent.getOembedResponse(url, VIMEO_OEMBED_API);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new CustomException("900");
        }

        if (responseEntity.getStatusCode().value() != 200) {
            throw new CustomException("800");
        }

        return responseEntity.getBody();
    }
}
