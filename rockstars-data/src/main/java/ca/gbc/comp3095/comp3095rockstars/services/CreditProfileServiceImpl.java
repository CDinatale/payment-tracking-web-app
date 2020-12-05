package ca.gbc.comp3095.comp3095rockstars.services;

import ca.gbc.comp3095.comp3095rockstars.model.CreditProfile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CreditProfileServiceImpl implements CreditProfileService{
    @Override
    public Set<CreditProfile> findAll() {
        return null;
    }

    @Override
    public CreditProfile findById(Long aLong) {
        return null;
    }

    @Override
    public void delete(CreditProfile object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
