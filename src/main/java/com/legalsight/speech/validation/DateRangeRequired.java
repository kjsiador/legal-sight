package com.legalsight.speech.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author kristian.j.s.siador
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { DateRangeRequiredValidator.class })
public @interface DateRangeRequired {
	
	public String message() default "startDate and endDate is required";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};

}
