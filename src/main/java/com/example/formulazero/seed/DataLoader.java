package com.example.formulazero.seed;

import com.example.formulazero.Model.Experience;
import com.example.formulazero.Repository.ExperienceRepository;
import com.example.formulazero.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        Experience silverstone = new Experience(1L, "Silverstone", 2499.99);
        Experience monaco = new Experience(2L, "Monaco", 3299.99);
        Experience monza = new Experience(3L, "Monza", 10000.00);

        experienceRepository.save(silverstone);
        experienceRepository.save(monaco);
        experienceRepository.save(monza);
    }
}
