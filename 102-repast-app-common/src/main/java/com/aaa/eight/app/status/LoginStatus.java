package com.aaa.eight.app.status;

/**
 * @Project 102-repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/18 19:08
 **/
public enum LoginStatus {

    LOGIN_SUCCESS("200", "登录成功"),
    LOGIN_FAILED("400", "登录失败"),
    USER_EXIST("201", "用户存在"),
    USER_NOT_EXIST("402", "用户不存在"),
    PASSWORD_WRONG("405", "密码错误"),
    LOGOUT_WRONG("403", "用户退出异常"),
    USER_HAS_PERMISSION("202", "用户拥有登录权限"),
    USER_HAS_NOT_PERMISSION("406", "用户没有登录权限");

    LoginStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
