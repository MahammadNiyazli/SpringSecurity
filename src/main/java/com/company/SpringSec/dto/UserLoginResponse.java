package com.company.SpringSec.dto;

public class UserLoginResponse {

    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public UserLoginResponse setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public UserLoginResponse setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    private String refreshToken;

}
