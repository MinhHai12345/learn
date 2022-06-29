package com.minhhai.learn.model.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minhhai.learn.common.constant.Constants;

import java.io.Serializable;
import java.sql.Timestamp;

public class AbstractResponse implements Serializable {
    private static final long serialVersionUID = 4191336015863888255L;

    private Integer id;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_FORMAT_DDMMYYYYHHMMSS_HYPHEN, timezone = Constants.GLOBAL_TIMEZONE)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_FORMAT_DDMMYYYYHHMMSS_HYPHEN, timezone = Constants.GLOBAL_TIMEZONE)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
