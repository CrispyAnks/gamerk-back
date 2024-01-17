package com.sei.gamerknew.services;

import com.sei.gamerknew.entities.Bio;
import com.sei.gamerknew.entities.User;

public interface BioService {

    void updateBio(User user);

    void uploadAva(String avaUrl);

    Bio getBio(String bioid);
}
