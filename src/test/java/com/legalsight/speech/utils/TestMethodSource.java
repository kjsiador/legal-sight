package com.legalsight.speech.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.legalsight.speech.dto.EditSpeechRequestDto;
import com.legalsight.speech.dto.RegisterSpeechRequestDto;
import com.legalsight.speech.dto.SearchSpeechRequestDto;
import com.legalsight.speech.dto.SpeechResponseItemDto;
import com.legalsight.speech.entity.SpeechEntity;

public class TestMethodSource {
	
	public static final String SEARCH_ERR = "Error during search";

	public static final String REGISTER_ERR = "Error during register";
    
	public static final String UPDATE_ERR = "Error during update";
    
	public static final String DELETE_ERR = "Error during delete";

	public static final String NOT_FOUND = "Data not found";
	
    public static SpeechResponseItemDto getResponseItem() {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return SpeechResponseItemDto.builder()
                .speechContent("This is about Docker")
                .author("Docker Guy")
                .subject("Docker 101")
                .createdAt(LocalDateTime.now().format(formatter))
                .build();

    }
    
    public static List<SpeechResponseItemDto> getResponseList(){
    	List<SpeechResponseItemDto> responseList = new ArrayList<>();
    	responseList.add(getResponseItem());
    	
    	return responseList;
    }
    
    public static SpeechEntity getSpeechEntity() {
    	
        return SpeechEntity.builder()
                .content("This is about Docker")
                .author("Docker Guy")
                .subject("Docker 101")
                .createdAt(LocalDateTime.now())
                .build();
    	
    }
    
    public static RegisterSpeechRequestDto getRegistDto() {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    	
        return RegisterSpeechRequestDto.builder()
                .speechContent("This is about Docker")
                .author("Docker Guy")
                .subject("Docker 101")
                .createdAt(LocalDateTime.now().format(formatter))
                .build();
    	
    }
    
    public static EditSpeechRequestDto getEditDto() {
    	
    	return EditSpeechRequestDto.builder().speechContent("This is an update").speechId(1).build();
    	
    }
    
    
    public static SearchSpeechRequestDto getSearchDto() {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    	
        return SearchSpeechRequestDto.builder()
                .speechContent("This is about Docker")
                .author("Docker Guy")
                .subject("Docker 101")
                .startDate(LocalDateTime.now().format(formatter))
                .endDate(LocalDateTime.now().format(formatter))
                .build();
    	
    }

}
