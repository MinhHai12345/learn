package com.minhhai.learn.services.impl;

import com.minhhai.learn.converter.UserConverter;
import com.minhhai.learn.entities.UserEntity;
import com.minhhai.learn.exception.InvalidArgumentException;
import com.minhhai.learn.jwt.JwtTokenUtil;
import com.minhhai.learn.model.request.LoginRequest;
import com.minhhai.learn.model.response.LoginResponse;
import com.minhhai.learn.repository.UserRepository;
import com.minhhai.learn.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponse login(final LoginRequest request) {
        LoginResponse loginResponse = null;
        try {
            authenticate(request.getUsername(), request.getPassword());
            final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(request.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            final UserEntity userEntity = userRepository.findByUsername(request.getUsername()).orElse(null);
            loginResponse = new LoginResponse(token, userConverter.userEntityToDTO(userEntity));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return loginResponse;
    }

    private void authenticate(final String username, final String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new InvalidArgumentException("USER_DISABLED", e.getMessage());
        } catch (BadCredentialsException e) {
            throw new InvalidArgumentException("INVALID_CREDENTIALS", e.getMessage());
        }
    }
}
