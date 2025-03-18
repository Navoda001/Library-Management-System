package com.library.LibMgmt2025.service.impl.secure;

import com.library.LibMgmt2025.dao.secure.UserDao;
import com.library.LibMgmt2025.dto.secure.JWTAuthResponse;
import com.library.LibMgmt2025.dto.secure.SignIn;
import com.library.LibMgmt2025.dto.secure.UserDTO;
import com.library.LibMgmt2025.entity.secure.UserEntity;
import com.library.LibMgmt2025.security.jwt.JWTUtils;
import com.library.LibMgmt2025.service.secure.AuthService;
import com.library.LibMgmt2025.util.EntityDtoConvert;
import com.library.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserDao userDao;
    private final JWTUtils jwtUtils;
    private final EntityDtoConvert entityDtoConvert;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var userByEmail = userDao.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generateToken = jwtUtils.generateToken(userByEmail.getEmail(), userByEmail.getAuthorities());
    return JWTAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
        userDTO.setUserId(UtilData.generateUserId());
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        var savedUser = userDao.save(entityDtoConvert.toUserEntity(userDTO));
        var generateToken = jwtUtils.generateToken(savedUser.getEmail(), savedUser.getAuthorities());
        return JWTAuthResponse.builder().token(generateToken).build();
    }
}
















