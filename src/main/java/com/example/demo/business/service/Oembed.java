package com.example.demo.business.service;

import com.example.demo.exception.CustomException;

public interface Oembed {

    public Object getOembedResponse(String url) throws CustomException;
}
