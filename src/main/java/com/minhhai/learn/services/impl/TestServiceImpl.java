package com.minhhai.learn.services.impl;

import com.minhhai.learn.configurations.properties.AppProperties;
import com.minhhai.learn.entities.ConfigEntity;
import com.minhhai.learn.repository.ConfigRepository;
import com.minhhai.learn.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private AppProperties appProperties;

    @Autowired
    private ConfigRepository configRepository;


    @Override
    public String test() {
        return appProperties.getAbc().concat(" - ").concat(appProperties.getDef())
                .concat(" - ").concat(appProperties.getGhi());
    }

    @Override
    public List<ConfigEntity> testAll() {
        return configRepository.findAll();
    }

    @Override
    public String refresh() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        DefaultSingletonBeanRegistry registry = (DefaultSingletonBeanRegistry) context.getBeanFactory();
//        registry.destroySingleton("env");
//        registry.registerSingleton("configurationPropertySource", configurationPropertySource);
//        configurationPropertySource.setEnvironment(env);
//        applicationContext.getAutowireCapableBeanFactory().destroyBean(ConfigurableEnvironment.class);
//        applicationContext.getAutowireCapableBeanFactory().initializeBean(ConfigurableEnvironment.class,"configurableEnvironment");
        return "ok";
    }
}
