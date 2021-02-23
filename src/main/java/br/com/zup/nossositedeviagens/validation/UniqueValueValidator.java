package br.com.zup.nossositedeviagens.validation;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

	private Class<?> domainClass;
	private String attribute;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(UniqueValue constraintAnnotation) {
		this.domainClass = constraintAnnotation.domaiClass();
		this.attribute = constraintAnnotation.attribute();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from "+ domainClass.getName() + " where "+ attribute + " = :value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.size() <= 1, "Foi encontrado mais de um "+ domainClass + " com o atríbuto "+ attribute +" = " + value);
		return list.isEmpty();
	}

}
