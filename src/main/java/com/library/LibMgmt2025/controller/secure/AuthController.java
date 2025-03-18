package com.library.LibMgmt2025.controller.secure;

import com.library.LibMgmt2025.dto.secure.JWTAuthResponse;
import com.library.LibMgmt2025.dto.secure.SignIn;
import com.library.LibMgmt2025.dto.secure.UserDTO;
import com.library.LibMgmt2025.service.secure.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("signin")
    public ResponseEntity<JWTAuthResponse> signIn(@RequestBody SignIn signIn) {
        return new ResponseEntity<>(authService.signIn(signIn),HttpStatus.CREATED);
    }
    @PostMapping("signup")
    public ResponseEntity<JWTAuthResponse> signUp(@RequestBody UserDTO signUp) {
        return new ResponseEntity<>(authService.signUp(signUp),HttpStatus.CREATED);
    }
}
