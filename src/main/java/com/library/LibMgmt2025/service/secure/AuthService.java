package com.library.LibMgmt2025.service.secure;

import com.library.LibMgmt2025.dto.secure.JWTAuthResponse;
import com.library.LibMgmt2025.dto.secure.SignIn;
import com.library.LibMgmt2025.dto.secure.UserDTO;

public interface AuthService {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(UserDTO userDTO);
}
