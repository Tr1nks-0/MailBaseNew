package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.entities.UserEntity;
import com.tr1nksgroup.model.repositories.UserRepository;
import com.tr1nksgroup.model.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImplementation implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
