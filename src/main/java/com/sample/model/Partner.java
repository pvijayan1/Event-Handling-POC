package com.sample.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Partner {

	public int pid;
	public String name;
	public List<RestEndPoint> restEndPoints;

	public static class RestEndPoint {
		public String request;
		public Attributes attributes;
	}

	public static class Attributes {
		@JsonProperty("SESSION_VAL_REQ")
		public boolean sESSION_VAL_REQ;
		@JsonProperty("SESSION_FACTORY")
		public String sESSION_FACTORY;
		@JsonProperty("REMEMBER_ME_TTL_MILLIS")
		public int rEMEMBER_ME_TTL_MILLIS;
		@JsonProperty("DEFAULT_TTL_MILLIS")
		public int dEFAULT_TTL_MILLIS;
		@JsonProperty("PLATFORM_NAME")
		public String pLATFORM_NAME;
		@JsonProperty("CAPTCHA_VAL_REQ")
		public String cAPTCHA_VAL_REQ;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(this);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "PartnerConfigDTO = " + json;
	}

}
