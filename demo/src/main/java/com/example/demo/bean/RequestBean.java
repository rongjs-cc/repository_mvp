package com.example.demo.bean;

/**
 * @author rjs
 * @package com.example.demo.bean
 * @date 2021/4/14
 * @desc
 */
public class RequestBean {

    private String user_PhoneNumber;
    private String password;

    public RequestBean(String user_PhoneNumber, String password) {
        this.user_PhoneNumber = user_PhoneNumber;
        this.password = password;
    }

    public String getUser_PhoneNumber() {
        return user_PhoneNumber;
    }

    public void setUser_PhoneNumber(String user_PhoneNumber) {
        this.user_PhoneNumber = user_PhoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
