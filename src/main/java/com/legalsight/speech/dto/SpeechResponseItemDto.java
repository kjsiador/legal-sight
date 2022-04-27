package com.legalsight.speech.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kristian.j.s.siador
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpeechResponseItemDto {
	
	private Integer speechId;
	
    private String speechContent;

    private String author;

    private String subject;
    
    private String createdAt;

}
