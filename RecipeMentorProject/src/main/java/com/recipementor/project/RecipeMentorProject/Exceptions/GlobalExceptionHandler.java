package com.recipementor.project.RecipeMentorProject.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.recipementor.project.RecipeMentor.Exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	} 
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public Map<String,String> validErrorHandling(MethodArgumentNotValidException ex)
	{
		HashMap<String,String> errormap = new HashMap<>();
		errormap.put("Validation failed", "Recipe Name cannot be empty");
		return errormap;
	}
}
