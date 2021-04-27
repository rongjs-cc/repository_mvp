package com.example.basemodule.net;

/**
 * @author rjs
 * @package com.example.basemodule.net
 * @date 2021/4/12
 * @desc
 */
public class TokenBean {

    private String token;
    private int type;

    public TokenBean(String token, int type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
