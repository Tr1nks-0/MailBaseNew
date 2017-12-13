package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.entities.GroupEntity;
import com.tr1nksgroup.model.repositories.GroupRepository;
import com.tr1nksgroup.model.services.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class GroupServiceImplementation implements GroupService {
    @Resource
    private GroupRepository groupRepository;

    /**
     * {@inheritDoc}
     *
     * @param cipher шифр
     * @return
     */
    @Override
    public GroupEntity getByCipher(String cipher) {
        return groupRepository.getByCipher(cipher);
    }

    @Override
    public GroupEntity save(GroupEntity groupEntity) {
        return groupRepository.saveAndFlush(groupEntity);
    }
}
