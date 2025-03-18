package com.library.LibMgmt2025.security.jwt;

import com.library.LibMgmt2025.dao.secure.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       return userDao.findByEmail(username)
//                .map(user-> new User(
//                        user.getEmail(),
//                        user.getPassword(),
//                        user.getAuthorities(),
//                ))
//                .orElseThrow(()->UsernameNotFoundException("User Not Found"));

        return userDao.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        }
}
