package com.zipdoc.dev;

import com.zipdoc.dev.service.PasteService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class DevApplicationTests {

	private final Logger LOGGER = LoggerFactory.getLogger(DevApplicationTests.class);

	@Test
	void contextLoads() {
		String pasteUrl;
		//pasteURL UUID 생성
		pasteUrl = UUID.randomUUID().toString();
		LOGGER.info("UUID Value : " + pasteUrl);
	}

}
