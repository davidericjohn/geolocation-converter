package com.eric.ph.geolocationconverter.converter;

import java.time.ZonedDateTime;

/**
 * Contains some behaviors to convert geographical data into some useful
 * information by using the Zone information database.
 * 
 * @author davidericjohn
 */
public interface GeoLocationConverter {

	/**
	 * Returns an immutable representation of date-time with TimeZone.
	 * 
	 * @param utcDate,
	 *            UTC date, not null, not blank
	 * @param latitude,
	 *            latitude
	 * @param longitude,
	 *            longitude
	 * @return zonedDateTime
	 */
	ZonedDateTime getZonedDateTime(String utcDate, double latitude, double longitude);

}
