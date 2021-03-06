package com.debashish.programs.testprograms.springboottest.service;

import java.util.List;

import com.debashish.programs.testprograms.springboottest.domain.Actor;

/**
 * @author Raju
 *
 */
public interface ActorService {

	Actor getActorById(Long id);
	
	List<Actor> getAllActors();
	
	List<Actor> getActorByFirstName(String firstName);
	
	List<Actor> getPagedActors(Integer pageNumber, Integer pageSize);
	
	Long countByFirstName(String firstName);

	Long countByLastName(String lastName);
}
