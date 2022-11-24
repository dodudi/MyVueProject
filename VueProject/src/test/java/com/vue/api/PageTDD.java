package com.vue.api;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.vue.mapper.BoardMapperTDD;

@SpringBootTest
public class PageTDD {
	private static final Logger log = LoggerFactory.getLogger(PageTDD.class);
	
	@Test
	public void pageTest() {
		PageInfo pageInfo = new PageInfo();
		
		log.info(pageInfo.toString());
	}
}
