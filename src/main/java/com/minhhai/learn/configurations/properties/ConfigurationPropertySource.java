package com.minhhai.learn.configurations.properties;

import com.minhhai.learn.entities.ConfigEntity;
import com.minhhai.learn.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("configurationPropertySource")
public class ConfigurationPropertySource implements EnvironmentAware {

    @Autowired
    private ConfigRepository configRepository;

    @Override
    public void setEnvironment(Environment environment) {
        ConfigurableEnvironment configurableEnvironment = (ConfigurableEnvironment) environment;

        List<ConfigEntity> configEntity = configRepository.findAll();
        Map<String, Object> propertySource = configEntity.get(0).getConfigInfo();
        configurableEnvironment.getPropertySources().addFirst(new MapPropertySource("app-config", propertySource));
    }

}
