package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.repositories.StudentRepository;
import com.tr1nksgroup.model.services.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class StudentServiceImplementation implements StudentService {
    @Resource
    private StudentRepository studentRepository;

    /**
     * {@inheritDoc}
     *
     * @param login логин
     * @return
     */
    @Override
    public boolean testEmail(String login) {
//        return null == studentRepository.testEmail(login);
        return null == studentRepository.getFirstByLogin(login);
    }
}
