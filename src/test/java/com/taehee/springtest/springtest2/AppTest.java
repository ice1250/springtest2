package com.taehee.springtest.springtest2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")


/**
 * Unit test for simple App.
 */
public class AppTest

{
	@Autowired
	HelloWorld hello;

	@Test
	public void helloTest() {
		assert (hello.getName().equals("taehee"));
	}
}
