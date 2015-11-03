package org.onderdal.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * The type Security config.
 * @author onder.dal
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * The Primary data source.
     */
    @Autowired
    DataSource primaryDataSource;

//	@Autowired

//	@Value("${spring.security.rememberme.cookie.key}")
//	private String rememberMeKey;
//	private RememberMeServices rememberMeServices;

    /**
     * Default roles prefix post processor.
     * @author onder.dal *
     * @return the default roles prefix post processor
     */
    @Bean
    public static DefaultRolesPrefixPostProcessor defaultRolesPrefixPostProcessor() {
        return new DefaultRolesPrefixPostProcessor();
    }

    /**
     * Password encoder.
     * @author onder.dal *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configure global.
     * @author onder.dal *
     * @param auth the auth
     * @param userDetailsService the user details service
     * @param passwordEncoder the password encoder
     * @throws Exception the exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity builder) throws Exception {
        builder.ignoring().antMatchers("/resources/**", "/loginresources/**", "/app*.css", "/**/favicon.ico",
                "/browserconfig.xml");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .headers()
                .frameOptions().sameOrigin()
                .cacheControl().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/login*.js", "/i18n*.js", "/passwordreset*.js", "/passwordresetEmail", "/passwordreset.html"
                        , "/passwordreset.action", "/loginresources/appOL.css", "/loginresources/ext-all.js", "/loginresources/ext-theme-crisp-touch.js"
                        , "/ext-theme-crisp-touch-all_01.css", "/ext-theme-crisp-touch-all_02.css", "/i18n-tr_1.0.0.js"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
//		  .rememberMe()
//            .rememberMeServices(this.rememberMeServices)
//            .key(this.rememberMeKey)
//		    .and()
                .formLogin()
                .loginPage("/login.html")
                .failureHandler(new JsonAuthenticationFailureHandler())
                .successHandler(new JsonSavedRequestAwareAuthenticationSuccessHandler())
                .permitAll()
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .csrf()
                .disable();
        // @formatter:on
    }

}