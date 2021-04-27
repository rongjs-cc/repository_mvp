package com.example.demo.bean;

/**
 * @author rjs
 * @package com.example.demo.bean
 * @date 2021/4/13
 * @desc
 */
public class ResponseBean {


    /**
     * bool : true
     * msg :
     * data : {"PhoneNumber":"17774039692","Password":"r123456"}
     */

    private boolean bool;
    private String msg;
    private DataBean data;

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * PhoneNumber : 17774039692
         * Password : r123456
         */

        private String PhoneNumber;
        private String Password;

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String PhoneNumber) {
            this.PhoneNumber = PhoneNumber;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }
    }
}
