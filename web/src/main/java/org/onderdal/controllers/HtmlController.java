package org.onderdal.controllers;

import org.onderdal.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by onder.dal on 29.10.2015.
 * package: org.onderdal.controllers
 * @author onder.dal
 */

@Controller
@ComponentScan
public class HtmlController {

    /**
     * The App properties.
     */
    @Autowired
    AppProperties appProperties;


    /**
     * Index model and view.
     * @author onder.dal *
     * @param response the response
     * @param locale the locale
     * @return the model and view
     */
    @RequestMapping(value = {"/", "/index.html"}, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ModelAndView index(HttpServletResponse response, Locale locale) {
        response.setContentType("text/html; charset=utf-8");
        Map<String, Object> m = new HashMap<>();
        m.put("applicationName", appProperties.getApplicationName());
        return new ModelAndView("index",m);
    }

    /**
     * Login model and view.
     * @author onder.dal *
     * @param response the response
     * @param locale the locale
     * @return the model and view
     */
    @RequestMapping(value = {"/login.html"})
    @ResponseBody
    public ModelAndView login(HttpServletResponse response, Locale locale) {
        Map<String, Object> m = new HashMap<>();
        m.put("applicationName", appProperties.getApplicationName());
        return new ModelAndView("login",m);
    }

    /**
     * Passwordreset model and view.
     * @author onder.dal *
     * @param response the response
     * @param locale the locale
     * @param token the token
     * @return the model and view
     * @throws IOException the iO exception
     */
    @RequestMapping(value = {"/passwordreset.html"},
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ModelAndView passwordreset(HttpServletResponse response, Locale locale, String token)
            throws IOException {
        if (!StringUtils.hasText(token)) {
            response.sendRedirect("/index.html");
        }

        response.setContentType("text/html; charset=utf-8");
        Map<String, Object> m = new HashMap<>();
        m.put("applicationName", appProperties.getApplicationName());
        return new ModelAndView("passwordreset",m);
    }

    private String createExtJSLocale(Environment environment, Locale locale) {
        String extjsLocale = "";
        if (locale != null && locale.getLanguage().toLowerCase().equals("de")) {
            String debug = "";
            if (environment.acceptsProfiles("development")) {
                debug = "-debug";
            }
            String extVersion = environment.getProperty("ext.version");
            extjsLocale = "<script src=\"resources/ext/" + extVersion
                    + "/locale/ext-locale-de" + debug + ".js\"></script>";
        }
        return extjsLocale;
    }

    private String createI18nScript(Environment environment, Locale locale) {
        String i18nScript;
        if (environment.acceptsProfiles("development")) {
            i18nScript = "<script src=\"i18n.js\"></script>";
        } else {
            i18nScript = "<script src=\"i18n-" + locale + "_"
                    + environment.getProperty("application.version") + ".js\"></script>";
        }
        return i18nScript;
    }

}

