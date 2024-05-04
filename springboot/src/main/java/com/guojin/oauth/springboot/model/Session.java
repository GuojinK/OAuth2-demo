package com.guojin.oauth.springboot.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long id;

    @Column(name = "session_token", nullable = false, unique = true)
    private String sessionToken;

    @Column(name = "creation_time", nullable = false)
    private Timestamp creationTime;

    @Column(name = "expiration_time", nullable = false)
    private Timestamp expirationTime;

    @Column(name = "jwt")
    private String jwt;

    @Column(name = "last_active_time")
    private Timestamp lastActiveTime;

    @OneToOne
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
    private Account account;

    // Constructors, getters, and setters

    public Session() {
    }

    public Session(Long id, String sessionToken, Timestamp creationTime, Timestamp expirationTime, String jwt, Timestamp lastActiveTime, Account account) {
        this.id = id;
        this.sessionToken = sessionToken;
        this.creationTime = creationTime;
        this.expirationTime = expirationTime;
        this.jwt = jwt;
        this.lastActiveTime = lastActiveTime;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Timestamp expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Timestamp getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Timestamp lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}