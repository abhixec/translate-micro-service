package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "translate")
public class LanguageTranslationController {
	RestTemplate restTemplate = new RestTemplate();
	private String backendServiceHost;

	public String getBackendServiceHost() {
		return backendServiceHost;
	}

	public void setBackendServiceHost(String backendServiceHost) {
		this.backendServiceHost = backendServiceHost;
	}

	private int backendServicePort;

	public int getBackendServicePort() {
		return backendServicePort;
	}

	public void setBackendServicePort(int backendServicePort) {
		this.backendServicePort = backendServicePort;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/translate", produces = "text/plain")
	public @ResponseBody String translate(@RequestParam("data") String text) {
		String backendURL = String.format("http://%s:%d/backend/translate?input=%s", backendServiceHost,
				backendServicePort, text);
		System.out.println(text);
		System.out.println(backendServiceHost + ": " + backendServicePort);
		BackendDTO resp = restTemplate.getForObject(backendURL, BackendDTO.class);
		System.out.println(resp.getTranslateText());
		return resp.getTranslateText();
	}
}
