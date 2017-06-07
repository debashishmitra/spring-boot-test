package com.debashish.programs.testprograms.springboottest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.debashish.programs.testprograms.springboottest.domain.Actor;

/**
 * @author Raju
 *
 */
public interface ActorRepository extends PagingAndSortingRepository<Actor, Long> {

	List<Actor> findByFirstName(String firstName);

	List<Actor> findByFirstNameOrderByLastName(String firstName);
	
	Actor findByFirstNameAndLastName(String firstName, String lastName);

	List<Actor> findAllByOrderByFirstNameAscLastNameAsc();

	Long countByFirstName(String firstName);

	Long countByLastName(String lastName);

	@Query("select a from Actor a where a.firstName=:firstName and a.lastName=:lastName")
	Actor findByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
