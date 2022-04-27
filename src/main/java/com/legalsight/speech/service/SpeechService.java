package com.legalsight.speech.service;


import com.legalsight.speech.dto.EditSpeechRequestDto;
import com.legalsight.speech.dto.RegisterSpeechRequestDto;
import com.legalsight.speech.dto.SearchSpeechRequestDto;
import com.legalsight.speech.dto.SpeechResponseDto;
import com.legalsight.speech.dto.SpeechResponseItemDto;
import com.legalsight.speech.exception.SpeechException;

/**
 * @author kristian.j.s.siador
 */
public interface SpeechService {
	
	SpeechResponseDto viewAll() throws SpeechException;
	
	SpeechResponseItemDto register(RegisterSpeechRequestDto request) throws SpeechException;
	
	void edit(EditSpeechRequestDto request) throws SpeechException;
	
	void delete(Integer speechId) throws SpeechException;
	
	SpeechResponseDto search(SearchSpeechRequestDto request) throws SpeechException;

}
