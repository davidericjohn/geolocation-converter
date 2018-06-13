package com.eric.ph.geolocationconverter.model;

/**
 * Represents a location in the map given x,y coordinates in degrees.
 * 
 * @author davidericjohn
 */
public class ZoneInfo {

	private String zoneId;

	private double latitude, longitude;

	/**
	 * Injects the TimeZone instance and coordinates
	 * 
	 * @param zoneId
	 *            zone ID
	 * @param latitude
	 *            latitude in degrees
	 * @param longitude
	 *            longitude in degrees
	 */
	public ZoneInfo(final String zoneId, double latitude, double longitude) {
		this.zoneId = zoneId;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Injects the coordinates
	 * 
	 * @param latitude
	 *            latitude in degrees
	 * @param longitude
	 *            longitude in degrees
	 */
	public ZoneInfo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * @return the zone ID
	 */
	public String zoneId() {
		return this.zoneId;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

}
