package com.curso.spring.api.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ValidateService {

	@Autowired
	private Validator validator;


	public void validate(Object validateObject) {
		Set<ConstraintViolation<Object>> violations = validator.validate(validateObject);

		String result = violations.stream()
				.map(ConstraintViolation::getMessage)
				.reduce("",(initial, element) -> initial + element + "\n");

		if (!violations.isEmpty()) {
			throw new IllegalArgumentException(result);
		}
	}

}