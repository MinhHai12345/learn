package com.minhhai.learn.configurations.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix = "test")
//@DependsOn("configurationPropertySource")
public class AppProperties {

//    @Value("${test.abc}")
    private String abc;

//    @Value("${test.def}")
    private String def;

//    @Value("${test.ghi}")
    private String ghi;

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getGhi() {
        return ghi;
    }

    public void setGhi(String ghi) {
        this.ghi = ghi;
    }
}
