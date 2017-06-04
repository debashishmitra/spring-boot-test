package com.debashish.programs.testprograms.springboottest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.debashish.programs.testprograms.springboottest.domain.Actor;
import com.debashish.programs.testprograms.springboottest.repository.ActorRepository;

/**
 * @author Raju
 *
 */
@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository actorRepository;

	@Override
	public Actor getActorById(Long id) {
		Actor a = actorRepository.findOne(id);
		return a;
	}

	@Override
	public List<Actor> getAllActors() {
		List<Actor> allActors = new ArrayList<Actor>();
		Iterable<Actor> actors = actorRepository.findAll();
		actors.forEach(allActors::add);
		return allActors;
	}

	@Override
	public List<Actor> getActorByFirstName(String firstName) {
		List<Actor> actors = actorRepository.getByFirstName(firstName);
		return actors;
	}

	@Override
	public List<Actor> getPagedActors(Integer pageNumber, Integer pageSize) {
		pageNumber = pageNumber != null && pageNumber >= 0 ? pageNumber : 0;
		pageSize = pageSize != null && pageSize > 0 ? pageSize : 10;
		Page<Actor> page = actorRepository.findAll(new PageRequest(pageNumber, pageSize));
		return page.getContent();
	}
}
