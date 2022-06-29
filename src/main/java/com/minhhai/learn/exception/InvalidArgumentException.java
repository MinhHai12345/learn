package com.minhhai.learn.exception;

import org.springframework.util.StringUtils;

public class InvalidArgumentException extends RuntimeException {
    private static final long serialVersionUID = 3912915980738627441L;

    private String code;

    public InvalidArgumentException(final String message) {
        this(null, message);
    }

    public InvalidArgumentException(final String code, final String message) {
        super(message);
        this.code = (StringUtils.hasText(code) ? code : "error");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
