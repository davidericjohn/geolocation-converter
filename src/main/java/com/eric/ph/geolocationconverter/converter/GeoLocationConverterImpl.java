package com.eric.ph.geolocationconverter.converter;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.TimeZone;

/**
 * Implementation class of {@code GeoLocationConverter}
 * 
 * @author davidericjohn
 */
public class GeoLocationConverterImpl extends AbstractGeoLocationConverter implements GeoLocationConverter {

	/**
	 * {@inheritDoc}
	 */
	public ZonedDateTime getZonedDateTime(final String utcDate, double latitude, double longitude) {
		final TimeZone timeZone = getTimeZone(latitude, longitude);
		return ZonedDateTime.ofInstant(Instant.parse(utcDate), timeZone.toZoneId());
	}

}
