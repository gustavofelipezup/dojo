package br.com.zup.nossositedeviagens.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { UniqueValueValidator.class })
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
public @interface UniqueValue {
	String message() default "já existe.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	Class<?> domaiClass() ;
	
	String attribute();
}
