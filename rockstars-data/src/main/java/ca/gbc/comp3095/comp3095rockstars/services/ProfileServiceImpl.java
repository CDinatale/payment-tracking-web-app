package ca.gbc.comp3095.comp3095rockstars.services;

import ca.gbc.comp3095.comp3095rockstars.model.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Override
    public Set<Profile> findAll() {
        return null;
    }

    @Override
    public Profile findById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Profile object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
