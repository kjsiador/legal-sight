package com.legalsight.speech.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legalsight.speech.dto.EditSpeechRequestDto;
import com.legalsight.speech.dto.RegisterSpeechRequestDto;
import com.legalsight.speech.dto.SearchSpeechRequestDto;
import com.legalsight.speech.dto.SpeechResponseDto;
import com.legalsight.speech.dto.SpeechResponseItemDto;
import com.legalsight.speech.exception.SpeechException;
import com.legalsight.speech.service.SpeechService;

/**
 * @author kristian.j.s.siador
 */
@RestController
@RequestMapping("/speech")
@Validated
public class SpeechController {
	
	@Autowired
	private SpeechService service;
	
    @GetMapping(value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpeechResponseDto> viewSpeech() throws SpeechException {
        return new ResponseEntity<>(service.viewAll(), HttpStatus.OK);
    }
    
    @PostMapping(value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpeechResponseItemDto> registerSpeech(@Valid @RequestBody RegisterSpeechRequestDto request) throws SpeechException {
        return new ResponseEntity<>(service.register(request), HttpStatus.OK);
    }
    
    @PutMapping(value = "/edit",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> editSpeech(@Valid @RequestBody EditSpeechRequestDto request)
            throws SpeechException {
    	service.edit(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/delete/{speechId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteSpeech(@Valid @PathVariable Integer speechId)
            throws SpeechException {
    	service.delete(speechId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping(value = "/search",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpeechResponseDto> searchSpeech(@Valid @RequestBody SearchSpeechRequestDto request) throws SpeechException {
        return new ResponseEntity<>(service.search(request), HttpStatus.OK);
    }


}
