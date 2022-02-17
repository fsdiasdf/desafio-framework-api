/**
 *
 */
package br.com.desafioFramework.exceptions;

import java.util.Arrays;
import java.util.List;

/**
 * @author Felipe Dias
 *
 */
public class ApiErrors {

	private List<String> errors;
	
	public ApiErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public ApiErrors(String message) {
		this.errors = Arrays.asList(message);
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	
}
