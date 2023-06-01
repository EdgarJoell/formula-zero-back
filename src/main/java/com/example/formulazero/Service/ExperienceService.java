package com.example.formulazero.Service;

import com.example.formulazero.Model.Experience;
import com.example.formulazero.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    private ExperienceRepository experienceRepository;

    @Autowired
    public void setExperienceRepository(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    /**
     * Gets all Experiences available.
     * @return A list of all the Experiences.
     */
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }
}
