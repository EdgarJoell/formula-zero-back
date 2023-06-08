package com.example.formulazero;

import com.example.formulazero.Model.Experience;
import com.example.formulazero.Repository.ExperienceRepository;
import com.example.formulazero.Service.ExperienceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ExperienceServiceTest {
    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Test
    @DisplayName("Get a list of all Experiences")
    public final void getAListOfAllExperiences() {
        experienceService.getAllExperiences();
    }

    @Test
    @DisplayName("Get One Experience By Id")
    public final void getOneExperienceById() {
        experienceService.getExperience(2L);
    }

    @Test
    @DisplayName("Get Experience participant list")
    public final void getExperienceParticipantList() {
        experienceService.getExperienceParticipants(2L);
    }

    @Test
    @DisplayName("Update an Experience")
    public final void updateAnExperience() {
        Experience experience = new Experience(10L, "Monaco", "France", "09-20-2023", 12999.99);
        experience.setCar("Mercedes");

        experienceService.updateExperience(experience, 2L);
        Optional<Experience> experience1 = experienceRepository.findById(2L);
        if (experience1.get().getCar().equals("Mercedes")) {
            System.out.println("IT UPDATED");
        } else {
            System.out.println("It didn't update");
        }
    }
}
