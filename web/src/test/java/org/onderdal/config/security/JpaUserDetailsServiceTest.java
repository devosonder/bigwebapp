package org.onderdal.config.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.onderdal.BigwebappApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

/**
 * Created by onder.dal on 03.11.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BigwebappApplication.class)
@WebAppConfiguration
public class JpaUserDetailsServiceTest {
    @Autowired
    JpaUserDetailsService jpaUserDetailsService;

    @Test
    public void testLoadUserByUsername() throws Exception {
        UserDetails deneme = jpaUserDetailsService.loadUserByUsername("deneme");
        Assert.notNull(deneme);
    }
}