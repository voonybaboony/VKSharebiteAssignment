package org.Kadikar.sharebiteassignment.sharebiteassignment;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
public class MenuSection {
	private @GeneratedValue @Id long id;
	private String name;
	
	public MenuSection(String n) {
		name = n;
	}
	
	public MenuSection() {}
}
