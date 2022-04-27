package com.legalsight.speech.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.legalsight.speech.dto.SearchSpeechRequestDto;

/**
 * @author kristian.j.s.siador
 */
public class DateRangeRequiredValidator implements ConstraintValidator<DateRangeRequired, SearchSpeechRequestDto>{
	
	@Override
	public boolean isValid(SearchSpeechRequestDto value, ConstraintValidatorContext context) {
		boolean isValid = true;
		
		if(StringUtils.isNotBlank(value.getStartDate()) && 
				!StringUtils.isNotBlank(value.getEndDate())) {
			
			context.buildConstraintViolationWithTemplate( "startDate and endDate is required" )
			.addPropertyNode("startDate").addConstraintViolation();
			
			return false;
		} else {
			isValid = true;
		}
		
		if(!StringUtils.isNotBlank(value.getStartDate()) && 
				StringUtils.isNotBlank(value.getEndDate())) {
			
			context.buildConstraintViolationWithTemplate( "startDate and endDate is required" )
			.addPropertyNode("startDate").addConstraintViolation();
			
			return false;
		} else {
			isValid = true;
		}
		
		return isValid;
		
	}

}
