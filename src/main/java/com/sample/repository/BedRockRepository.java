package com.sample.repository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.sample.model.User;

@Component
public class BedRockRepository {

	public void saveUserInBedRock(User user) {

		String bedRockId = null;
		if (!StringUtils.isBlank(user.getIdxId())) {

			// make a call to BedRock backend and get the BedRockId
			Boolean bedRockSuccess = true;

			if (bedRockSuccess) {
				bedRockId = "BedRock-ID-789";
				user.setBedRockId(bedRockId);
			}

		}

	}
}
