package com.lookatme.api.controller;

import com.lookatme.api.entity.Authority;
import com.lookatme.api.entity.User;
import com.lookatme.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/user")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    @PostMapping("/joinUser")
    @Transactional
    public String joinMember(User user){

        validateUser(user);

        System.out.println("==================================Start====================================");
        String rawPwd = user.getUserPassword();
        System.out.println("rawPwd = " + rawPwd);
        String encPwd = bCryptPasswordEncoder.encode(rawPwd);
        System.out.println("encPwd = " + encPwd);

        user.setUserPassword(encPwd);
        user.setAuthority(Authority.ROLE_USER);
        user.setUserProfileImageState(0);
        user.setUserState(1);
        userRepository.save(user);
        System.out.println("==================================End====================================");
        return "redirect:http://localhost:8890/extra-pages/login";
    }

    //중복회원 검증
    private void validateUser(User user) {
        List<User> userByEmail = userRepository.findByEmail(user.getUserEmail());
        if(!userByEmail.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원 이메일입니다.");
        }
    }
}
