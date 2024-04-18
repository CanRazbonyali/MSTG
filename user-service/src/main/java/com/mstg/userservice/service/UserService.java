package com.mstg.userservice.service;

import com.mstg.userservice.dto.LoginDto;

public interface UserService {
    boolean register();
    boolean login(LoginDto dto);// jwt?
}
