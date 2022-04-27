package com.legalsight.speech.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class EditSpeechRequestDto {
	
	@JsonProperty("speechId")
	@NotNull(message = "speechId is required")
	private Integer speechId;
	
    @JsonProperty("speechContent")
    @NotBlank(message = "speechContent is required.")
    private String speechContent;


}
