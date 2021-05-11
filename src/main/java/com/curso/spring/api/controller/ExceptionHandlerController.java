package com.curso.spring.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.curso.spring.api.dto.ServiceResponse;
import com.curso.spring.api.dto.ServiceResponseFactory;
import com.curso.spring.api.exception.NotFoundException;


@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

	private ResponseEntity<ServiceResponse> handleException(Exception ex, HttpStatus status, String code,
			boolean printTrack) {
		logger.error("ERROR:", ex);
		logger.error(Marker.ANY_MARKER, "MENSAJE DE ERROR: {0}", ex.getMessage());

		if (printTrack) {
			ex.printStackTrace();
		}

		return ServiceResponseFactory.createResponse(code, ex.getMessage(), status);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ServiceResponse> exceptionHandler(Exception ex) {
		return handleException("Operacion Fallida: " + ex.getMessage(), HttpStatus.OK, "99", true);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ServiceResponse> exceptionHandler(NotFoundException ex) {
		return handleException(ex, HttpStatus.OK, "44", false);
	}

	private ResponseEntity<ServiceResponse> handleException(String string, HttpStatus ok, String code,
			boolean printTrack) {
		if (printTrack)
			logger.error(Marker.ANY_MARKER, "MENSAJE DE ERROR: {0}", string);
		return ServiceResponseFactory.createResponse(code, string, ok);
	}

}
