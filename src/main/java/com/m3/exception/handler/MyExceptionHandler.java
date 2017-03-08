package com.m3.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(MyExceptionHandler.class);

	@ExceptionHandler(value = {ServletRequestBindingException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handlerMissingParameters(HttpServletRequest req, Exception e){
		LOG.warn("Requested URL = " + req.getRequestURL());
		LOG.warn("Exception Raised = " + e);
		return "error/missingParams";
	}
}
