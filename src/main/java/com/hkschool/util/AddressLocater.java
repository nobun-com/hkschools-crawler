package com.hkschool.util;

import java.util.HashMap;
import java.util.Map;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class AddressLocater {

	public static Map<String, String> locate(String address) {

		Map<String, String> result = new HashMap<String, String>();
		try {
			GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyDxXS0BIb9k38Wwug3k0fR3cL54El-D5qM").build();
			GeocodingResult[] results = null;
			results = GeocodingApi.geocode(context, address).await();
			if (results.length != 0) {
				Double latitude = 0d;
				Double longitude = 0d;
				latitude = results[0].geometry.location.lat;
				longitude = results[0].geometry.location.lng;
				result.put("lat", latitude.toString());
				result.put("long", longitude.toString());
			}
		} catch (Exception e) {
			System.out.println("Failed to get Lat Long of " + address);
		}
		return result;
	}

}
