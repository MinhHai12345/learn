package com.minhhai.learn.controller.common;

import com.minhhai.learn.common.constant.Constants;
import com.minhhai.learn.common.context.CommonResourceBundle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractController {
    protected ResponseEntity<Map<String, Object>> success(final Object data) {
        return this.success(data, null, null, true);
    }

    protected ResponseEntity<Map<String, Object>> success(final Object data, final String code,
            final String message, final boolean needTranslate) {
        final Map<String, Object> successRes = new LinkedHashMap<>();
        successRes.put(Constants.DATA, data);
        if (StringUtils.hasText(code)) {
            successRes.put(Constants.CODE, code);
        } else {
            successRes.put(Constants.CODE, HttpStatus.OK.name());
        }
        if (StringUtils.hasText(message)) {
            final String translated = needTranslate ? CommonResourceBundle.getMessage(message)
                    : message;
            successRes.put(Constants.MESSAGE, translated);
        } else {
            successRes.put(Constants.MESSAGE, HttpStatus.OK.name());
        }
        return new ResponseEntity<>(successRes, HttpStatus.OK);
    }
}
