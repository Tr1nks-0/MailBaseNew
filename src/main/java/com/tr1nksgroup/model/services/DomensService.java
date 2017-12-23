package com.tr1nksgroup.model.services;

import com.tr1nksgroup.model.entities.DomensEntity;

public interface DomensService {


    String getEmailDomen();

    String getImagineDomen();

    String getOfficeDomen();

    boolean containsByAllDomens(String emailDomen, String imagineDomen, String officeDomen);

    DomensEntity save(DomensEntity domensEntity);
}
