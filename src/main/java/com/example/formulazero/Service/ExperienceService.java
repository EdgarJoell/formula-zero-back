package com.example.formulazero.Service;

import com.example.formulazero.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {
    private ExperienceRepository experienceRepository;

    @Autowired
    public void setExperienceRepository(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }
}
