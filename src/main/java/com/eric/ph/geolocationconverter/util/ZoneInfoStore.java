package com.eric.ph.geolocationconverter.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.eric.ph.geolocationconverter.model.ZoneInfo;

/**
 * Acts as the storage for the zone data
 * 
 * @author davidericjohn
 */
public class ZoneInfoStore {

	private static final Logger LOGGER = Logger.getLogger(ZoneInfoStore.class);

	private static final int TIMEZONE_ID_INDEX = 0;
	private static final int LATITUDE_INDEX = 1;
	private static final int LONGITUDE_INDEX = 2;

	private static final String SEPARATOR = ",";
	private static final String DATA_FILE_NAME = "/zone-info.csv";

	private List<ZoneInfo> zoneInfos;

	/**
	 * Prevents creating instance of this class
	 */
	private ZoneInfoStore() {
		this.zoneInfos = new ArrayList<ZoneInfo>();
		this.loadData();
	}

	/**
	 * Loads and store the zone data to the memory
	 */
	private void loadData() {
		final BufferedReader br = new BufferedReader(
				new InputStreamReader(ZoneInfoStore.class.getResourceAsStream(DATA_FILE_NAME)));

		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				final String[] location = line.split(SEPARATOR);
				this.zoneInfos.add(new ZoneInfo(location[TIMEZONE_ID_INDEX], Double.valueOf(location[LATITUDE_INDEX]),
						Double.valueOf(location[LONGITUDE_INDEX])));
			}
		} catch (IOException e) {
			LOGGER.error("Error reading data file.", e);
		}
	}

	/**
	 * Helper class to get instance of this class.
	 */
	private static class ZoneInfoStoreHelper {
		private static final ZoneInfoStore INSTANCE = new ZoneInfoStore();
	}

	/**
	 * @return the instance of this class
	 */
	public static ZoneInfoStore getInstance() {
		return ZoneInfoStoreHelper.INSTANCE;
	}

	/**
	 * @return the zoneInfos
	 */
	public List<ZoneInfo> getZoneInfos() {
		return this.zoneInfos;
	}

}
