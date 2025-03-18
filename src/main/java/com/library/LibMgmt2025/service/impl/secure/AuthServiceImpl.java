package com.library.LibMgmt2025.service.impl.secure;

import com.library.LibMgmt2025.dto.secure.JWTAuthResponse;
import com.library.LibMgmt2025.dto.secure.SignIn;
import com.library.LibMgmt2025.dto.secure.UserDTO;
import com.library.LibMgmt2025.service.secure.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        return null;
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
        return null;
    }
}
