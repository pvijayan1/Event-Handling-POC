package com.sample.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MyWebApplication;
import com.sample.Util.RegistrationUtil;
import com.sample.dto.UserRequest;
import com.sample.events.UserCreationEvent;
import com.sample.model.Partner;
import com.sample.model.User;
import com.sample.repository.BedRockRepository;
import com.sample.repository.IDXRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CreateUserService {

	@Autowired
	IDXRepository idxRepository;

	@Autowired
	BedRockRepository bedrockRepository;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	public String createUser(UserRequest userRequest) {
		String userSaved = null;
		User user = User.builder().email(userRequest.getEmail()).password(userRequest.getPassword()).build();
		testPropYml();
		//testFileLoading();
		updateIDXandBedRock(user);
		if (!StringUtils.isBlank(user.getIdxId()) && !StringUtils.isBlank(user.getBedRockId())) {
			userSaved = "User creation successful";
			log.debug("IDX ID from Service--->" + user.getIdxId());
			log.debug("BedRock from Service--->" + user.getBedRockId());
			// Publish the event
			eventPublisher.publishEvent(new UserCreationEvent(user));
			return userSaved;
		} else {
			userSaved = "User creation failed";
		}
		return userSaved;
	}

	private void testFileLoading() {
		Partner partner = MyWebApplication.getPartnerMap().get("153.json");
		log.debug("partner val--->" + partner.getPid());
	}

	@Transactional
	private void updateIDXandBedRock(User user) {
		try {
			idxRepository.saveUserInIdx(user);
			bedrockRepository.saveUserInBedRock(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void testPropYml() {
		String val1 = RegistrationUtil.getProperties1Value("topic1", "aaaa");
		String val2 = RegistrationUtil.getProperties1Value("topic3", "topic3A");
		String val3 = RegistrationUtil.getProperties1Value("topic4", "topic4F");
		String val9 = RegistrationUtil.getProperties1Value("topic4", "supportedPartners");

		String val4 = RegistrationUtil.getProperties2Value("topic5", "topic5A");
		String val5 = RegistrationUtil.getProperties2Value("topic5", "topic5D");
		String val6 = RegistrationUtil.getProperties2Value("topic5", "topic5G");
		String val7 = RegistrationUtil.getProperties2Value("topic6", "topic6C");
		String val8 = RegistrationUtil.getProperties2Value("topic7", "topic7G");

		log.debug("val1--->" + val1);
		log.debug("val2--->" + val2);
		log.debug("val3--->" + val3);

		log.debug("val4--->" + val4);
		log.debug("val5--->" + val5);
		log.debug("val6--->" + val6);
		log.debug("val7--->" + val7);
		log.debug("val8--->" + val8);
		log.debug("val9--->" + val9);

	}

	/*
	 * @Transactional public String createUserNew(UserRequest userRequest) { String
	 * val1 = registrationUtil.getProperties1Value("topic1", "aaaa"); String val2 =
	 * registrationUtil.getProperties1Value("topic3", "topic3A"); String val3 =
	 * registrationUtil.getProperties1Value("topic4", "topic4F");
	 * 
	 * String val4 = registrationUtil.getProperties2Value("topic5", "topic5A");
	 * String val5 = registrationUtil.getProperties2Value("topic5", "topic5D");
	 * String val6 = registrationUtil.getProperties2Value("topic5", "topic5G");
	 * String val7 = registrationUtil.getProperties2Value("topic6", "topic6C");
	 * String val8 = registrationUtil.getProperties2Value("topic7", "topic7G");
	 * 
	 * log.debug("val1--->"+val1); log.debug("val2--->"+val2);
	 * log.debug("val3--->"+val3);
	 * 
	 * log.debug("val4--->"+val4); log.debug("val5--->"+val5);
	 * log.debug("val6--->"+val6); log.debug("val7--->"+val7);
	 * log.debug("val8--->"+val8); String userSaved = null; User user =
	 * User.builder().email(userRequest.getEmail()).password(userRequest.getPassword
	 * ()).build(); idxRepository.saveUserInIdx(user);
	 * bedrockRepository.saveUserInBedRock(user);
	 * 
	 * if(!StringUtils.isBlank(user.getIdxId()) &&
	 * !StringUtils.isBlank(user.getBedRockId())) { userSaved =
	 * "User creation successful";
	 * log.debug("IDX ID from Service--->"+user.getIdxId());
	 * log.debug("BedRock from Service--->"+user.getBedRockId()); //Publish the
	 * event eventPublisher.publishEvent(new UserCreationEvent(user)); return
	 * userSaved; } else { userSaved = "User creation failed"; } return userSaved; }
	 */

}
