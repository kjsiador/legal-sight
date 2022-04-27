package com.legalsight.speech.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.legalsight.speech.dto.SearchSpeechRequestDto;

/**
 * @author kristian.j.s.siador
 */
public class SearchRequiredValidator implements ConstraintValidator<SearchRequired, SearchSpeechRequestDto>{
	
	@Override
	public boolean isValid(SearchSpeechRequestDto value, ConstraintValidatorContext context) {
		boolean isValid = true;
		
		if(StringUtils.isNotBlank(value.getSpeechContent()) && StringUtils.isNotBlank(value.getAuthor()) &&
				StringUtils.isNotBlank(value.getSubject()) && StringUtils.isNotBlank(value.getStartDate()) && 
				StringUtils.isNotBlank(value.getEndDate())) {
			
			context.buildConstraintViolationWithTemplate( "search parameter is required" )
			.addPropertyNode("startDate").addConstraintViolation();
			
			isValid = false;
		} 
		
		return isValid;
		
	}

}
