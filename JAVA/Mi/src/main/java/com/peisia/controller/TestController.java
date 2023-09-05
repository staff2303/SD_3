package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.peisia.service.TestService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/test/*")
@AllArgsConstructor
@Controller
public class TestController {

	@Setter(onMethod_ = @Autowired)
	private TestService service;

	@GetMapping("/getOnePlusTwo")
	public void getOnePlusTwo(Model model) {
//	public void getOnePlusTwo() {
		log.info("getOnePlusTwo ==========================================");
		String one = service.getOne();
		String two = service.getTwo();
		Integer sum = Integer.parseInt(one) + Integer.parseInt(two);

		log.info("(여기 컨트롤러임) 1 더하기 2는 = " + sum);

		model.addAttribute("sum", sum);
	}

	@RequestMapping("/w")
	public void w() {
		String API_KEY = "2sCP4h4ArgQh9smneemF0QEHUP5IGcUW%2FfPk7Exrn%2BUUVCw%2Ftb29R%2FdwHW4dmCj3qmjf%2BH4uglU1qaZu7hvFGw%3D%3D";
		String API_URL = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?numOfRows=10&pageNo=1&dateCd=DAY&startDt=20230816&endDt=20230816&stnIds=108&dataCd=ASOS&dataType=JSON&serviceKey="
				+ API_KEY;

		RestTemplate restTemplate = new RestTemplate();

		URI uri = null; // java.net.URI 임포트 하셈
		try {
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		String s = restTemplate.getForObject(uri, String.class); //
		log.info("====== 우리나라 날씨 잘 나오나? " + s);
	}
}