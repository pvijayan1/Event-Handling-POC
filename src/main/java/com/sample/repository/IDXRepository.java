package com.sample.repository;

import org.springframework.stereotype.Component;

import com.sample.model.User;

@Component
public class IDXRepository {

	public void saveUserInIdx(User user) {
		String idxId = null;
		Boolean success = true;
		// make a rest/webclient call to IDX client
		// if the call is successful, IDXID will be returned
		if (success) {
			idxId = "IDX-ID-123";
			user.setFirstName("firstName");
			user.getLastName();
			user.setIdxId(idxId);

		}

	}

}
