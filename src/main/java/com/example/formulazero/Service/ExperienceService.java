package com.example.formulazero.Service;

import com.example.formulazero.Model.Experience;
import com.example.formulazero.Model.User;
import com.example.formulazero.Repository.ExperienceRepository;
import com.example.formulazero.exceptions.InformationIsEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * Searches for one Experience by their ID.
     * @param experienceId The ID being used to search for an Experience.
     * @return The Experience if the ID was matched.
     */
    public Optional<Experience> getExperience(Long experienceId) {
        return experienceRepository.findById(experienceId);
    }

    public List<User> getExperienceParticipants(Long experienceId) {
        Optional<Experience> experience = experienceRepository.findById(experienceId);
        if(experience.get().getUserList().isEmpty()) {
            throw new InformationIsEmptyException("There are no participants for this Experience. Be the first!");
        } else {
            return experience.get().getUserList();
        }
    }
}
