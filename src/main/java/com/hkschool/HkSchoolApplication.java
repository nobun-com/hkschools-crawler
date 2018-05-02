package com.hkschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hkschool.service.HKSKGService;
import com.hkschool.service.HKSPSService;
import com.hkschool.service.HKSSSService;
import com.hkschool.service.KGService;
import com.hkschool.service.LocationService;
import com.hkschool.service.MSKGService;
import com.hkschool.service.PSService;
import com.hkschool.service.SSService;

@SpringBootApplication
public class HkSchoolApplication {

	@Autowired
	KGService kGService;

	@Autowired
	PSService pSService;

	@Autowired
	SSService sSService;
	
	@Autowired
	HKSKGService hKSKGService;
	
	@Autowired
	HKSPSService hKSPSService;
	
	@Autowired
	HKSSSService hKSSSService; 
	
	@Autowired
	MSKGService mSKGService;

	@Autowired
	public HkSchoolApplication(KGService schoolService1, PSService schoolService2, SSService schoolService3 , HKSKGService schoolservice4 , HKSPSService schoolservice6, HKSSSService schoolservice7, MSKGService schoolservice5, LocationService locationService) {
		this.kGService = schoolService1;
		this.pSService = schoolService2;
		this.sSService = schoolService3;
		this.hKSKGService = schoolservice4;
		this.mSKGService = schoolservice5;
		this.hKSPSService = schoolservice6;
		this.hKSSSService = schoolservice7;
		loadDataFromGovermentSites();
		loadDataFromSchoolandSites();
		loadDataFromMyschoolhkSites();
		locationService.synk();
	}

	private void loadDataFromMyschoolhkSites() {
		//mSKGService.pull();
	}

	private void loadDataFromGovermentSites() {
		try {
			kGService.pull();
			pSService.pull();
			sSService.pull();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadDataFromSchoolandSites() {
		try {
			hKSKGService.pull();
			hKSPSService.pull();
			hKSSSService.pull();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(HkSchoolApplication.class, args);
	}
}
