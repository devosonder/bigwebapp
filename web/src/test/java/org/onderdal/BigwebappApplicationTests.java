package org.onderdal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BigwebappApplication.class)
@WebAppConfiguration
@PropertySource({"classpath:application.properties"})
public class BigwebappApplicationTests {

	@Test
	public void contextLoads() {
	}

}
