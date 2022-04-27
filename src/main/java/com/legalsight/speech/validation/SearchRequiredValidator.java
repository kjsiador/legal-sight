package com.legalsight.speech.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.h2.util.StringUtils;

import com.legalsight.speech.dto.SearchSpeechRequestDto;

/**
 * @author kristian.j.s.siador
 */
public class SearchRequiredValidator implements ConstraintValidator<SearchRequired, SearchSpeechRequestDto>{
	
	@Override
	public boolean isValid(SearchSpeechRequestDto value, ConstraintValidatorContext context) {
		boolean isValid = true;
		
		if(StringUtils.isNullOrEmpty(value.getSpeechContent()) && StringUtils.isNullOrEmpty(value.getAuthor()) &&
				StringUtils.isNullOrEmpty(value.getSubject()) && StringUtils.isNullOrEmpty(value.getStartDate()) && 
				StringUtils.isNullOrEmpty(value.getEndDate())) {
			
			context.buildConstraintViolationWithTemplate( "search parameter is required" )
			.addPropertyNode("startDate").addConstraintViolation();
			
			isValid = false;
		} 
		
		return isValid;
		
	}

}
