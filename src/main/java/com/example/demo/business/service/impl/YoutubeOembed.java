package com.example.demo.business.service.impl;

import com.example.demo.business.component.OembedAPIComponent;
import com.example.demo.business.service.Oembed;
import com.example.demo.business.util.CustomStatus;
import com.example.demo.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class YoutubeOembed implements Oembed {

    @Autowired
    private OembedAPIComponent oembedAPIComponent;

    @Override
    public Object getOembedResponse(String url) throws CustomException {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = oembedAPIComponent.getOembedResponseJSON(url);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new CustomException(String.valueOf(CustomStatus.API_CALL_FAIL.getCode()));
        }

        if (responseEntity.getStatusCode().value() != 200) {
            throw new CustomException(String.valueOf(CustomStatus.INVALID_URL.getCode()));
        }

        return responseEntity.getBody();
    }
}
