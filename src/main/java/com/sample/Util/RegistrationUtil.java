package com.sample.Util;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.MyWebApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.model.Partner;

public class RegistrationUtil {

	public static String getProperties1Value(String head, String keyName) {
		Map<String, Map<String, String>> propMap = new HashMap<String, Map<String, String>>();
		String value = null;
		propMap = MyWebApplication.getProperties1();
		for (Map.Entry<String, Map<String, String>> item : propMap.entrySet()) {
			String key = item.getKey();
			if (key.equals(head)) {
				Map<String, String> map1 = item.getValue();
				if (head.equalsIgnoreCase(key)) {
					for (Map.Entry<String, String> mp : map1.entrySet()) {
						String key1 = mp.getKey();
						if (keyName.equals(key1)) {
							value = mp.getValue();
						}
					}
				}
			}

		}
		return value;
	}

	public static String getProperties2Value(String head, String keyName) {
		Map<String, Map<String, String>> propMap = new HashMap<String, Map<String, String>>();
		String value = null;
		propMap = MyWebApplication.getProperties2();
		for (Map.Entry<String, Map<String, String>> item : propMap.entrySet()) {
			String key = item.getKey();
			if (key.equals(head)) {
				Map<String, String> map1 = item.getValue();
				if (head.equalsIgnoreCase(key)) {
					for (Map.Entry<String, String> mp : map1.entrySet()) {
						String key1 = mp.getKey();
						if (keyName.equals(key1)) {
							value = mp.getValue();
						}
					}
				}
			}

		}
		return value;
	}
	
	
	public static void loadPartnerTemplateIntoMap(HashMap<String, Partner> partnerMap) {
		String supportedPartners = RegistrationUtil.getProperties1Value("registration", "supportedPartners");
		String pathPartners = RegistrationUtil.getProperties1Value("registration", "rootPartnerPath");
		List<String> supportedPartnerList = Stream.of(supportedPartners.split(",", -1)).collect(Collectors.toList());
		for (String str : supportedPartnerList) {
			String fileName = str + ".json";
			String filepath = pathPartners + fileName;
			ObjectMapper objectMapper = new ObjectMapper();
			// Resource resource = new ClassPathResource("partners/150.json");
			Resource resource = new ClassPathResource(filepath);
			InputStream input = null;
			File file = null;
			Partner partner = new Partner();
			try {
				input = resource.getInputStream();
				file = resource.getFile();
				partner = objectMapper.readValue(file, Partner.class);
				partnerMap.put(fileName, partner);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
