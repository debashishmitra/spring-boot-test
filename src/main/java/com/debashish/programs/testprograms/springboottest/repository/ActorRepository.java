package com.debashish.programs.testprograms.springboottest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.debashish.programs.testprograms.springboottest.domain.Actor;

/**
 * @author Raju
 *
 */
public interface ActorRepository extends CrudRepository<Actor, Long> {

	List<Actor> getByFirstName(String firstName);
	
}