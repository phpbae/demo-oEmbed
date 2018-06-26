package com.example.demo.presentation.rest;

import com.example.demo.business.service.Oembed;
import com.example.demo.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestAPIController {

    @Autowired
    @Qualifier("youtubeOembed")
    private Oembed youtube;

    @Autowired
    @Qualifier("vimeoOembed")
    private Oembed vimeo;

    @GetMapping(value = "/oembed/youtube", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getOembedYoutube(@RequestParam(name = "url", value = "") String url) throws CustomException {

        return new ResponseEntity(youtube.getOembedResponse(url), HttpStatus.OK);
    }

    @GetMapping(value = "/oembed/vimeo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getOembedVimeo(@RequestParam(name = "url", value = "") String url) throws CustomException {

        return new ResponseEntity(vimeo.getOembedResponse(url), HttpStatus.OK);
    }
}
