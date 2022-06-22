package com.minhhai.learn.services;

import com.minhhai.learn.entities.ConfigEntity;

import java.util.List;

public interface TestService {
    String test();

    List<ConfigEntity> testAll();

    String refresh();
}
