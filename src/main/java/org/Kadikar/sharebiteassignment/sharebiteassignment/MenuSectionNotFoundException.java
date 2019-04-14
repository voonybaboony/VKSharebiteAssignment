package org.Kadikar.sharebiteassignment.sharebiteassignment;

public class MenuSectionNotFoundException extends RuntimeException {
	MenuSectionNotFoundException(Long id) {
		super("Could not find menu section " + id);
	}
}
