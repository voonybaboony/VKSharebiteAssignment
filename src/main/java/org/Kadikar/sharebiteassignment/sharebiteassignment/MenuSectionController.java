package org.Kadikar.sharebiteassignment.sharebiteassignment;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MenuSectionController {

	private final MenuSectionRepository repository;

	MenuSectionController(MenuSectionRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/menuSections")
	List<MenuSection> all() {
		return repository.findAll();
	}

	@PostMapping("/menuSections")
	MenuSection newMenuSection(@RequestBody MenuSection newMenuSection) {
		return repository.save(newMenuSection);
	}

	// Single item

	@GetMapping("/menuSections/{id}")
	MenuSection one(@PathVariable Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new MenuSectionNotFoundException(id));
		
		//return new Resource<>(menuSection,
		//		linkTo(methodOn(MenuSectionController.class).one(id)).withSelfRel(),
		//		linkTo(methodOn(MenuSectionController.class).all()).withRel("menuSections"));
	}

	@PutMapping("/menuSections/{id}")
	MenuSection replaceMenuSection(@RequestBody MenuSection newMenuSection, @PathVariable Long id) {

		return repository.findById(id)
			.map(menuSection -> {
				menuSection.setName(newMenuSection.getName());
				return repository.save(menuSection);
			})
			.orElseGet(() -> {
				newMenuSection.setId(id);
				return repository.save(newMenuSection);
			});
	}

	@DeleteMapping("/menuSections/{id}")
	void deleteMenuSection(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
