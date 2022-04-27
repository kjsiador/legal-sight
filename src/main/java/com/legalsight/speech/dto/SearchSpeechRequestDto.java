package com.legalsight.speech.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.legalsight.speech.validation.DateRangeRequired;
import com.legalsight.speech.validation.SearchRequired;

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
@SearchRequired
@DateRangeRequired
public class SearchSpeechRequestDto {
	
    @JsonProperty("speechContent")
    private String speechContent;

    @JsonProperty("author")
    private String author;

    @JsonProperty("subject")
    private String subject;
    
    @JsonProperty("startDate")
    private String startDate;
    
    @JsonProperty("endDate")
    private String endDate;

}
