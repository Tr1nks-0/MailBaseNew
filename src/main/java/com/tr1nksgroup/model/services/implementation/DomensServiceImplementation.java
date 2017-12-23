package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.entities.DomensEntity;
import com.tr1nksgroup.model.repositories.DomensRepository;
import com.tr1nksgroup.model.services.DomensService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomensServiceImplementation implements DomensService {
    @Resource
    private DomensRepository domensRepository;
    private static String emailDomen;
    private static String imagineDomen;
    private static String officeDomen;

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public String getEmailDomen() {
        if (null == emailDomen) {
            emailDomen = domensRepository.getFirst().getEmailDomen();
        }
        return emailDomen;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public String getImagineDomen() {
        if (null == imagineDomen) {
            imagineDomen = domensRepository.getFirst().getImagineDomen();
        }
        return imagineDomen;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public String getOfficeDomen() {
        if (null == officeDomen) {
            officeDomen = domensRepository.getFirst().getOfficeDomen();
        }
        return officeDomen;
    }

    @Override
    public boolean containsByAllDomens(String emailDomen, String imagineDomen, String officeDomen) {
        return null != domensRepository.getFirstByEmailDomenAndImagineDomenAndOfficeDomen(emailDomen, imagineDomen, officeDomen);
    }

    @Override
    public DomensEntity save(DomensEntity domensEntity) {
        return domensRepository.saveAndFlush(domensEntity);
    }
}
