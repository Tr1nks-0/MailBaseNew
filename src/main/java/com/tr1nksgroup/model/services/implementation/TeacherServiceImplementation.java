package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.repositories.TeacherRepository;
import com.tr1nksgroup.model.services.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TeacherServiceImplementation implements TeacherService {
    @Resource
    private TeacherRepository teacherRepository;
    /**
     * {@inheritDoc}
     *
     * @param login логин
     * @return
     */
    @Override
    public boolean testEmail(String login) {
        return null == teacherRepository.getFirstByLogin(login);
    }
}
