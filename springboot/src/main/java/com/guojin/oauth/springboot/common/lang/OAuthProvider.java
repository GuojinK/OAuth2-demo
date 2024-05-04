package com.guojin.oauth.springboot.common.lang;
public enum OAuthProvider {
    GOOGLE("Google", "https://accounts.google.com/o/oauth2/auth", "https://www.googleapis.com/oauth2/v3/userinfo"),
    FACEBOOK("Facebook", "https://www.facebook.com/dialog/oauth", "https://graph.facebook.com/me"),
    GITHUB("GitHub", "https://github.com/login/oauth/authorize", "https://api.github.com/user"),
    TWITTER("Twitter", "https://api.twitter.com/oauth/authenticate", "https://api.twitter.com/1.1/account/verify_credentials.json");

    private final String providerName;
    private final String authorizationUrl;
    private final String userInfoUrl;

    OAuthProvider(String providerName, String authorizationUrl, String userInfoUrl) {
        this.providerName = providerName;
        this.authorizationUrl = authorizationUrl;
        this.userInfoUrl = userInfoUrl;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }
}
