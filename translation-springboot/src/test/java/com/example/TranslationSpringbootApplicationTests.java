package com.example;

import static org.mockito.Matchers.contains;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import org.junit.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TranslationSpringbootApplication.class)
@WebAppConfiguration
public class TranslationSpringbootApplicationTests {
	
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	RestTemplate restTemplate = new RestTemplate();
	
	MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();
	
	@Test
	public void testRequest() {
		server.expect(requestTo("/api/translate")).andExpect(method(HttpMethod.POST)).andExpect(content().string("input=abhinav")).andRespond(withSuccess("abhinavyay",MediaType.APPLICATION_JSON));
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		parts.add("input", "abhinav");
		String result = restTemplate.postForObject("/api/translate", parts,String.class);
		Assert.assertEquals("abhinavyay",result);

	}

}