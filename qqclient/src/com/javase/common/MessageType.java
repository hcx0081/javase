package com.javase.common;

/**
 * {@code @Description:}
 */
public enum MessageType {
    
    MESSAGE_LOGIN_SUCCEED("1"),//表示成功
    MESSAGE_LOGIN_FAIL("0");//表示失败
    
    private String status;
    
    MessageType(String status) {
        this.status = status;
    }
}