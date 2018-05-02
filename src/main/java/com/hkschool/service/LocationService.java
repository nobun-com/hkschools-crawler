package com.hkschool.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.hkschool.models.KGEntity;
import com.hkschool.models.PSEntity;
import com.hkschool.models.SSEntity;
import com.hkschool.repository.KGJpaRepository;
import com.hkschool.repository.PSJpaRepository;
import com.hkschool.repository.SSJpaRepository;

@Component
public class LocationService {

	@Resource
	private KGJpaRepository kgSchoolJpaRepository;

	@Resource
	private PSJpaRepository psSchoolJpaRepository;

	@Resource
	private SSJpaRepository ssSchoolJpaRepository;

	public void synk() {
		synkKG();
		synkPS();
		synkSS();
	}
	
	private void synkSS() {
		Iterable<SSEntity> schools = ssSchoolJpaRepository.findAll();
		for(SSEntity school : schools) {
			if (school.getLattitude() == null) {
				Map<String, String> result = locate(school.getAddress());
				school.setLattitude(result.get("lat"));
				school.setLongitude(result.get("long"));
				ssSchoolJpaRepository.save(school);
				System.out.println("SS " + school.getSchoolName());
			}
		}
	}

	private void synkPS() {
		Iterable<PSEntity> schools = psSchoolJpaRepository.findAll();
		for(PSEntity school : schools) {
			if (school.getLattitude() == null) {
				Map<String, String> result = locate(school.getAddress());
				school.setLattitude(result.get("lat"));
				school.setLongitude(result.get("long"));
				psSchoolJpaRepository.save(school);
				System.out.println("PS " + school.getSchoolName());
			}
		}
	}

	private void synkKG() {
		Iterable<KGEntity> schools = kgSchoolJpaRepository.findAll();
		for(KGEntity school : schools) {
			if (school.getLattitude() == null) {
				Map<String, String> result = locate(school.getAddress());
				school.setLattitude(result.get("lat"));
				school.setLongitude(result.get("long"));
				kgSchoolJpaRepository.save(school);
				System.out.println("KG " + school.getSchoolName());
			}
		}
	}

	private Map<String, String> locate(String address) {
		address = address.replaceAll("[0-9A-Za-z '\\-_\\.\\(\\)&õ]+", "");
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
