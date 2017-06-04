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

	@GetMapping(path="/{id}")
	public Actor getActor(@PathVariable("id") Long id) {
		Actor actor = actorService.getActorById(id);
		return actor;
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Actor> getActors(@RequestParam(name="id", required=false) Integer id) {
		List<Actor> actors = actorService.getAllActors();
		if(id != null) {
			actors = actors.stream().filter(a -> a.getId() == id).collect(Collectors.toList());
		}
		return actors;
	}
	
	@RequestMapping(path="/filter", method=RequestMethod.GET)
	public List<Actor> getActorByFirstName(@RequestParam(name="firstName") String firstName) {
		List<Actor> actors = actorService.getActorByFirstName(firstName);
		return actors;
	}
}
