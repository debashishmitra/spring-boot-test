package com.debashish.programs.testprograms.springboottest.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.debashish.programs.testprograms.springboottest.repository.converter.LocalDateTimeConverter;

import lombok.Data;

/**
 * @author Raju
 *
 */
@Entity
@Data
@Table(name="actor")
public class Actor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="actor_id")
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Convert(converter=LocalDateTimeConverter.class)
	@Column(name="last_update")
	private LocalDateTime lastUpdateTime;
	
	public String getLastUpdateTime() {
		return lastUpdateTime.toString();
	}

}
