package com.minhhai.learn.services;

import com.minhhai.learn.model.request.LoginRequest;
import com.minhhai.learn.model.response.LoginResponse;

public interface AuthenticationService {

    LoginResponse login(final LoginRequest request);
}
