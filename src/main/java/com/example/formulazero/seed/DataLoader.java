package com.example.formulazero.seed;

import com.example.formulazero.Model.Experience;
import com.example.formulazero.Model.User;
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
        if (experienceRepository.count() == 0 || userRepository.count() == 0) {
            Experience silverstone = new Experience(1L, "Silverstone", "11-01-23", 2499.99);
            Experience monaco = new Experience(2L, "Monaco", "09-20-23", 3299.99);
            Experience monza = new Experience(3L, "Monza", "01-24-24", 10000.00);

            experienceRepository.save(silverstone);
            experienceRepository.save(monaco);
            experienceRepository.save(monza);

            User edgar = new User()
        }
    }
}
