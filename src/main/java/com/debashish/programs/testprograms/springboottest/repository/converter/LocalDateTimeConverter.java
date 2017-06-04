package com.debashish.programs.testprograms.springboottest.repository.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;

/**
 * @author Raju
 *
 */
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		if (attribute == null) {
			return null;
		} else {
			return Timestamp.valueOf(attribute);
		}
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
		if (dbData == null) {
			return null;
		} else {
			return dbData.toLocalDateTime();
		}
	}

}
