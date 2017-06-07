package com.debashish.programs.testprograms.springboottest.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.debashish.programs.testprograms.springboottest.domain.Actor;
import com.debashish.programs.testprograms.springboottest.repository.ActorRepository;
import com.debashish.programs.testprograms.springboottest.service.ActorService;

/**
 * @author Raju
 *
 */
@RestController
@RequestMapping("/actors")
public class ActorResource {

	@Autowired
	private ActorService actorService;

	@Autowired
	private ActorRepository actorRepository;
	
	@GetMapping(path = "/{id}")
	public Actor getActorById(@PathVariable("id") Long id) {
		Actor actor = actorService.getActorById(id);
		return actor;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Actor> getAllActors(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "pageNumber", required = false) Integer pageNumber, @RequestParam(name = "pageSize", required = false) Integer pageSize) {
		List<Actor> actors;
		if (pageNumber == null && pageSize == null) {
			actors = actorService.getAllActors().stream().filter(a -> id == null ? true : a.getId() == id).collect(Collectors.toList());
		} else {
			actors = actorService.getPagedActors(pageNumber, pageSize);
		}
		return actors;
	}

	@RequestMapping(path = "/firstName/{firstName}", method = RequestMethod.GET)
	public List<Actor> getActorByFirstName(@PathVariable(name = "firstName") String firstName) {
		List<Actor> actors = actorService.getActorByFirstName(firstName);
		return actors;
	}

	@RequestMapping(path = "/filter", method = RequestMethod.GET)
	public List<Actor> getActorByFilter(@RequestParam(name = "firstName") String firstName) {
		List<Actor> actors = actorService.getActorByFirstName(firstName);
		return actors;
	}
	
	@GetMapping("/fullName")
	public Actor getByFullName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		Actor a = actorRepository.findByFirstNameAndLastName(firstName, lastName);
		//		Actor a = actorRepository.findByName(firstName, lastName);
		return a;
	}
	
}
