package com.minhhai.learn.entities;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "configs")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class ConfigEntity {
    @Id
    private long id;

    @Column(name = "created_date", updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date", updatable = true)
    private Date updatedDate;

    @Type(type = "json")
    @Column(name = "config_info", columnDefinition = "json")
    private Map<String, Object> configInfo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Map<String, Object> getConfigInfo() {
        return configInfo;
    }

    public void setConfigInfo(Map<String, Object> configInfo) {
        this.configInfo = configInfo;
    }
}
