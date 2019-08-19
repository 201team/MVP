package com.dhcc.csr.bean;

/**
 * @Author: wlsh
 * @Date: 2019/8/12 20:50
 * @Description: Token
 */
public class TokenEntity {

    private Long id;
    private String token;
    private String effectiveTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}
