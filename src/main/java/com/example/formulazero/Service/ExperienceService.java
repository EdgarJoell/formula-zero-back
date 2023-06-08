package com.example.formulazero.Service;

import com.example.formulazero.Model.Experience;
import com.example.formulazero.Model.User;
import com.example.formulazero.Repository.ExperienceRepository;
import com.example.formulazero.exceptions.InformationIsEmptyException;
import com.example.formulazero.exceptions.InformationNotFoundException;
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
    public Experience getExperience(Long experienceId) {
        Optional<Experience> experience = experienceRepository.findById(experienceId);
        if(experience.isPresent()) {
            return experience.get();
        } else {
            throw new InformationNotFoundException("Experience with this ID does not exist.");
        }
    }

    /**
     * Provides a list of the participants for a certain Experience.
     * @param experienceId The ID to search for the Experience.
     * @return A list of the names of people that will be attending that Experience.
     */
    public List<User> getExperienceParticipants(Long experienceId) {
        Optional<Experience> experience = experienceRepository.findById(experienceId);
        if(experience.get().getUserList().isEmpty()) {
            throw new InformationIsEmptyException("There are no participants for this Experience. Be the first!");
        } else {
            return experience.get().getUserList();
        }
    }

    public Experience updateExperience(Experience newCar, Long experienceId) {
        Optional<Experience> experience = experienceRepository.findById(experienceId);
        if (experience.isPresent()) {
            experience.get().setCar(newCar.getCar());
            experience.get().setTime(newCar.getTime());
            return experienceRepository.save(experience.get());
        } else {
            throw new InformationNotFoundException("Experience with this ID does not exist");
        }
    }
}
