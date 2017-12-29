package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.entities.GroupEntity;
import com.tr1nksgroup.model.entities.StudentEntity;
import com.tr1nksgroup.model.repositories.StudentRepository;
import com.tr1nksgroup.model.services.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        return null == studentRepository.getFirstByLogin(login);
    }

    @Override
    public boolean testCode(String code) {
        return null == studentRepository.getFirstByCode(code);
    }

    @Override
    public StudentEntity save(StudentEntity student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public List<StudentEntity> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<StudentEntity> getAllByFacultyIds(List<Long> facultyIds) {
        return studentRepository.getAllByGroupEntity_FacultyEntityIdIn(facultyIds);
    }

    @Override
    public List<StudentEntity> getAllByGroupIds(List<Long> groupIds) {
        return studentRepository.getAllByGroupEntity_IdIn(groupIds);
    }

    @Override
    public List<StudentEntity> getAllByGroupYears(List<Integer> years) {
        return studentRepository.getAllByGroupEntity_YearIn(years);
    }

    @Override
    public StudentEntity getById(long id) {
        return studentRepository.getById(id);
    }

    @Override
    public StudentEntity getBySurnameAndNameAndGroup(String surname, String name, GroupEntity groupEntity) {
        return studentRepository.getBySurnameAndNameAndGroupEntity(surname, name,  groupEntity);
    }

}
