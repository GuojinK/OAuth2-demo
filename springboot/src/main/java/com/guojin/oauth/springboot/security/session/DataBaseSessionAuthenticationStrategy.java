package com.guojin.oauth.springboot.security.session;

import com.guojin.oauth.springboot.model.Account;
import com.guojin.oauth.springboot.model.Session;
import com.guojin.oauth.springboot.repository.SessionRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import java.sql.Timestamp;
import java.util.UUID;

@Transactional
public class DataBaseSessionAuthenticationStrategy implements SessionAuthenticationStrategy {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest request, HttpServletResponse response) throws SessionAuthenticationException {
        String sessionToken = UUID.randomUUID().toString();
        Timestamp current = new Timestamp(System.currentTimeMillis());
        Session session = new Session();
        session.setAccount((Account) authentication.getPrincipal());
        session.setCreationTime(current);
        session.setSessionToken(sessionToken);
        sessionRepository.save(session);
    }
}
