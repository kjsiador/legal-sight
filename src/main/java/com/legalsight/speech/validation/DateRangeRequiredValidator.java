package com.legalsight.speech.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.h2.util.StringUtils;

import com.legalsight.speech.dto.SearchSpeechRequestDto;

/**
 * @author kristian.j.s.siador
 */
public class DateRangeRequiredValidator implements ConstraintValidator<DateRangeRequired, SearchSpeechRequestDto>{
	
	@Override
	public boolean isValid(SearchSpeechRequestDto value, ConstraintValidatorContext context) {
		boolean isValid = true;
		
		if(StringUtils.isNullOrEmpty(value.getStartDate()) && 
				!StringUtils.isNullOrEmpty(value.getEndDate())) {
			
			context.buildConstraintViolationWithTemplate( "startDate and endDate is required" )
			.addPropertyNode("startDate").addConstraintViolation();
			
			return false;
		} else {
			isValid = true;
		}
		
		if(!StringUtils.isNullOrEmpty(value.getStartDate()) && 
				StringUtils.isNullOrEmpty(value.getEndDate())) {
			
			context.buildConstraintViolationWithTemplate( "startDate and endDate is required" )
			.addPropertyNode("startDate").addConstraintViolation();
			
			return false;
		} else {
			isValid = true;
		}
		
		return isValid;
		
	}

}
