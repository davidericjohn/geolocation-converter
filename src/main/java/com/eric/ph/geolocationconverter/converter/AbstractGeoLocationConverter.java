package com.eric.ph.geolocationconverter.converter;

import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import java.util.TimeZone;

import com.eric.ph.geolocationconverter.model.ZoneInfo;
import com.eric.ph.geolocationconverter.util.ZoneInfoStore;

/**
 * Interfaces with the Zone database to generate useful geographical
 * information.
 * 
 * @author davidericjohn
 */
public abstract class AbstractGeoLocationConverter {

	private static final String DEFAULT_TIMEZONE = "UTC";

	/**
	 * Returns the TimeZone of the given coordinates using the Zone database.
	 * 
	 * @param latitude
	 *            latitude in degrees
	 * @param longitude
	 *            longitude in degrees
	 * @return timeZone of the given coordinates
	 */
	public TimeZone getTimeZone(double latitude, double longitude) {
		final ZoneInfoStore store = ZoneInfoStore.getInstance();
		double leastDistant = Double.MAX_VALUE;
		TimeZone nearestZone = TimeZone.getTimeZone(DEFAULT_TIMEZONE);

		final ZoneInfo unknownZone = new ZoneInfo(latitude, longitude);
		// finds the shortest distance
		for (final ZoneInfo zoneInfo : store.getZoneInfos()) {
			final double distance = getDistanceBetweenTwoPoints(unknownZone, zoneInfo);
			// stores the shortest distance
			if (distance < leastDistant) {
				leastDistant = distance;
				nearestZone = TimeZone.getTimeZone(zoneInfo.zoneId());
			}
		}

		return nearestZone;
	}

	/**
	 * Calculating distance between two points on a sphere
	 * 
	 * {@link https://math.stackexchange.com/questions/2465153/distance-between-points-on-earth}
	 * {@link https://en.wikipedia.org/wiki/Haversine_formula}
	 * 
	 * @param pointA
	 *            first point with x,y coordinates
	 * @param pointB
	 *            second point with x,y coordinates
	 * @return distance between two points in kilometers
	 */
	private double getDistanceBetweenTwoPoints(final ZoneInfo pointA, final ZoneInfo pointB) {
		// earth's radius in kilometers
		final double radius = 6371;
		// degrees to radian conversion
		final double lat1Rad = toRadians(pointA.getLatitude()), lat2Rad = toRadians(pointB.getLatitude()),
				long1Rad = toRadians(pointA.getLongitude()), long2Rad = toRadians(pointB.getLongitude());

		// calculation
		final double dist = radius
				* acos(cos(lat1Rad) * cos(lat2Rad) * cos(long1Rad - long2Rad) + sin(lat1Rad) * sin(lat2Rad));
		return dist;
	}

}
