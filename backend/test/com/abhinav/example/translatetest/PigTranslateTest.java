package com.abhinav.example.translatetest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.abhinav.example.translate.PigTranslate;

public class PigTranslateTest {
	private PigTranslate pigTranslate= new PigTranslate();
	
	@Test
	public void testWordWithVowelStart(){
		String input = "Abhinav";
		Assert.assertEquals("Abhinavyay", pigTranslate.translate(input));
	}
	
	@Test
	public void testWordWithConsonantStart(){
		String input = "string";
		Assert.assertEquals("ingstray", pigTranslate.translate(input));
	}
	
	@Test
	public void testWordWithPeriod(){
		String input = "period.";
		Assert.assertEquals("eriodpay.", pigTranslate.translate(input));
	}
	
	@Test
	public void testSentence(){
		String input = "This is a really cool string.";
		Assert.assertEquals("isThay isyay ayay eallyray oolcay ingstray.",pigTranslate.translate(input));
	}
	
	@Test
	public void testWords(){
		Map<String,String> hm = new HashMap<>();
		hm.put("pig", "igpay");
		hm.put("banana", "ananabay");
		hm.put("trash", "ashtray");
		hm.put("happy", "appyhay");
		hm.put("duck", "uckday");
		hm.put("glove", "oveglay");
		hm.put("eat", "eatyay");
		hm.put("omelet", "omeletyay");
		hm.put("are", "areyay");
		hm.forEach((key,value)->{
			Assert.assertEquals(value,pigTranslate.translate(key));
		});
	}
}
