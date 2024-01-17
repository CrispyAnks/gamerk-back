package com.sei.gamerknew.services.impl;

import com.sei.gamerknew.entities.Bio;
import com.sei.gamerknew.entities.User;
import com.sei.gamerknew.mapper.BioMapper;
import com.sei.gamerknew.services.BioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BioserviceImpl implements BioService {
    @Autowired
    private BioMapper bioMapper;

    @Override
    public void updateBio(User user) {
        bioMapper.update(user.getBioid(), user.getGender(), user.getIntro());
    }

    @Override
    public void uploadAva(String avaUrl) {
        bioMapper.updateAva(avaUrl);
    }

    @Override
    public Bio getBio(String bioid) {
        return bioMapper.getBio(bioid);
    }
}
