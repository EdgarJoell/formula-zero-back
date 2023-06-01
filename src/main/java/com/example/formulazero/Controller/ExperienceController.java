package com.example.formulazero.Controller;

import com.example.formulazero.Model.Experience;
import com.example.formulazero.Service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/")
public class ExperienceController {
    private ExperienceService experienceService;

    @Autowired
    public void setExperienceService(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    /**
     * Uses the experienceService variable to call the business side of the method getAllExperiences().
     * @return A list of all the Experiences available.
     */
    @GetMapping(path = "/experiences/")
    public List<Experience> getAllExperiences() {
        return experienceService.getAllExperiences();
    }

    @GetMapping(path = "/experiences/{experienceId}/")
    public Optional<Experience> getExperience(@PathVariable Long experienceId) {
        return experienceService.getExperience(experienceId);
    }
}
