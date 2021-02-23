package br.com.zup.nossositedeviagens.validation;

import br.com.zup.nossositedeviagens.rota.NovaRotaFormRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RotaUnicaValidator implements Validator {

    @PersistenceContext
    EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaRotaFormRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
