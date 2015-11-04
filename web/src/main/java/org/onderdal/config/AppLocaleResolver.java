package org.onderdal.config;

import org.onderdal.config.security.JpaUserDetails;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.i18n.AbstractLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * The type App locale resolver.
 * @author onder.dal
 */
public class AppLocaleResolver extends AbstractLocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		if (authentication == null
				|| authentication instanceof AnonymousAuthenticationToken) {
			return request.getLocale();
		}
		else if (authentication.getPrincipal() instanceof JpaUserDetails) {
			return ((JpaUserDetails) authentication.getPrincipal()).getLocale();
		}
		else if (getDefaultLocale() != null) {
			return getDefaultLocale();
		}
		else {
			return Locale.ENGLISH;
		}
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response,
			Locale locale) {
		throw new UnsupportedOperationException(
				"Cannot change locale - use a different locale resolution strategy");
	}

}
