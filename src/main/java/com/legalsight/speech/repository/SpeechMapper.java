package com.legalsight.speech.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.legalsight.speech.dto.SearchSpeechRequestDto;
import com.legalsight.speech.dto.SpeechResponseItemDto;

/**
 * @author kristian.j.s.siador
 */

@Mapper
public interface SpeechMapper{
	
	List<SpeechResponseItemDto> viewAll();
	
	List<SpeechResponseItemDto> search(@Param("request") SearchSpeechRequestDto request);
	

}
