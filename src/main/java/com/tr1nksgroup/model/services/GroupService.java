package com.tr1nksgroup.model.services;

import com.tr1nksgroup.model.entities.GroupEntity;

public interface GroupService {
    GroupEntity getByCipher(String s);

    GroupEntity save(GroupEntity groupEntity);
}
