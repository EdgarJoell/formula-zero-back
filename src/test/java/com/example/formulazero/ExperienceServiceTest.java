package com.example.formulazero;

import com.example.formulazero.Service.ExperienceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExperienceServiceTest {
    private ExperienceService experienceService;

    @Test
    @DisplayName("Get a list of all Experiences")
    public final void getAListOfAllExperiences() {
        experienceService.getAllExperiences();
    }

    @Test
    @DisplayName("Get One Experience By Id")
    public final void getOneExperienceById() {
        experienceService.getExperience(2);
    }
}
