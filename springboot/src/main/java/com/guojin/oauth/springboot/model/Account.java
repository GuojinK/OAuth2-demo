package com.guojin.oauth.springboot.model;

import com.guojin.oauth.springboot.common.lang.OAuthProvider;
import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "oauth_provider")
    private OAuthProvider oauthProvider;

    @Column(name = "oauth_user_id")
    private String oauthUserId;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Session session;

    public Account() {
    }

    public Account(Long id, String email, String password, OAuthProvider oauthProvider, String oauthUserId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.oauthProvider = oauthProvider;
        this.oauthUserId = oauthUserId;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OAuthProvider getOauthProvider() {
        return oauthProvider;
    }

    public void setOauthProvider(OAuthProvider oauthProvider) {
        this.oauthProvider = oauthProvider;
    }

    public String getOauthUserId() {
        return oauthUserId;
    }

    public void setOauthUserId(String oauthUserId) {
        this.oauthUserId = oauthUserId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
