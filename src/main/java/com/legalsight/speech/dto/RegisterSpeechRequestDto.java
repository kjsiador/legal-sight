package com.legalsight.speech.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class RegisterSpeechRequestDto {
	
    @JsonProperty("speechContent")
    @NotBlank(message = "speechContent is required.")
    private String speechContent;

    @JsonProperty("author")
    @NotBlank(message = "author is required.")
    private String author;

    @JsonProperty("subject")
    @NotBlank(message = "subject is required.")
    private String subject;
    
    @JsonProperty("createdAt")
    @NotBlank(message = "createdAt is required.")
    private String createdAt;

}
