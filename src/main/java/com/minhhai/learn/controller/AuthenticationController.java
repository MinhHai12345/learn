package com.minhhai.learn.controller;

import com.minhhai.learn.controller.common.AbstractController;
import com.minhhai.learn.model.request.LoginRequest;
import com.minhhai.learn.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class AuthenticationController extends AbstractController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<Map<String, Object>> createAuthenticationToken(@RequestBody @Valid LoginRequest request) {
        return this.success(authenticationService.login(request));
    }


}
