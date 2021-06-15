package com.komeya.jpa.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The Class JwtEntryPoint esta clase se encarga de autorizar o no las peticiones
 * 
 * @author Dani Kuradchyk
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    /** The Constant logger. */
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    /**
     * Commence.
     *
     * @param req the req
     * @param res the res
     * @param e the e
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws ServletException the servlet exception
     */
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        logger.error("fail en el método commence");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");
    }
}