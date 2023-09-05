package com.peisia.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.peisia.spring.dto.TestDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TestMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private TestMapper mapper;
	
	@Test
	public void testGetList() {
		TestDto sData1 = mapper.getData1();
		TestDto sData2 = mapper.getData2();
		TestDto sData3 = mapper.getData3();
		TestDto sData4 = mapper.getData4();
		log.info(sData1);
		log.info(sData2);
		log.info(sData3);
		log.info(sData4);
		String s1 = sData1.getStr_data();
		String s2 = sData2.getStr_data();
		int n1 = Integer.parseInt(s1);
		int n2 = Integer.parseInt(s2);
		int sum = n1 + n2;
		log.info("1+2 는 ==============:" + sum);
	}
	
}


	

