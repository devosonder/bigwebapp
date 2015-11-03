package org.onderdal.config;

import ch.rasc.wampspring.config.AbstractWampConfigurer;
import ch.rasc.wampspring.config.EnableWamp;
import ch.rasc.wampspring.config.WampEndpointRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWamp
public class WampConfig extends AbstractWampConfigurer {

	@Override
	public void registerWampEndpoints(WampEndpointRegistry registry) {
		registry.addEndpoint("/wamp").withSockJS();
	}

}