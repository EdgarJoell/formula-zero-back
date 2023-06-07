package com.example.formulazero;

import com.example.formulazero.Model.Experience;
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
        Experience anExperience = new Experience(2L, "Monaco", "France", "09-20-2023", 5699.99);
        Experience updatedExperience = new Experience(20L, "Monaco", "France", "09-20-2023", 5699.99);

        updatedExperience.setCar("Red Bull Racing");
        experienceService.updateExperience(updatedExperience, anExperience.getId());
        Optional<Experience> monacoExperience = experienceService.getExperience(2L);
        System.out.println(updatedExperience.getCar().equals(monacoExperience.get().getCar()));
    }
}
