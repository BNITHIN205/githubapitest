package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GITHubController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/git/treedetails")
	public void getTreeDetails() {

		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
		ResponseEntity<String> responseObj = restTemplate.exchange(
				"https://api.github.com/repos/BNITHIN205/second-repository/git/refs/heads/master", HttpMethod.GET,
				httpEntity, String.class);

		System.out.println("======= Response Received ====" + responseObj);

	}
}
