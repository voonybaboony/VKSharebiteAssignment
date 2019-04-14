package org.Kadikar.sharebiteassignment.sharebiteassignment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MenuSectionNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(MenuSectionNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String menuSectionNotFoundHandler(MenuSectionNotFoundException ex) {
		return ex.getMessage();
	}
}