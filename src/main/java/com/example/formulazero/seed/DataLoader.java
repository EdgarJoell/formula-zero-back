package com.example.formulazero.seed;

import com.example.formulazero.Model.Cart;
import com.example.formulazero.Model.Experience;
import com.example.formulazero.Model.User;
import com.example.formulazero.Repository.CartRepository;
import com.example.formulazero.Repository.ExperienceRepository;
import com.example.formulazero.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (experienceRepository.count() == 0 || userRepository.count() == 0) {
            Experience silverstone = new Experience(1L, "Silverstone", "United Kingdom", "11-01-23", 2499.99, "../../../../assets/experience-page-images/Silverstone-RaceThumbnail.png");
            Experience monaco = new Experience(2L, "Monaco", "France", "09-20-23", 3299.99, "../../../../assets/experience-page-images/Monaco-RaceThumbnail.png");
            Experience monza = new Experience(3L, "Monza", "Italy",  "01-24-24", 10000.00, "../../../../assets/experience-page-images/Monza-RaceThumbnail.png");
            Experience vegas = new Experience(4L, "Las Vegas", "United States", "01-24-24", 10000.00, "../../../../assets/experience-page-images/Vegas-RaceThumbnail.png");
            Experience miami = new Experience(5L, "Miami", "United States", "01-24-24", 10000.00, "../../../../assets/experience-page-images/Miami-RaceThumbnail.png");
            Experience marinaBay = new Experience(6L, "Marina Bay", "Singapore", "01-24-24", 10000.00, "../../../../assets/experience-page-images/Marina-RaceThumbnail.png");

//            User edgar = new User(1L, "edgar@edgar.com", "password", "Edgar Z");

            Cart cart = new Cart(1L);


            monza.setCart(cart);
            vegas.setCart(cart);

            ArrayList<Experience> list = new ArrayList<>();
            list.add(monza);
            list.add(vegas);

            cart.setExperienceList(list);

//            edgar.setExperience(monaco);

//            userRepository.save(edgar);

            cartRepository.save(cart);

            experienceRepository.save(silverstone);
            experienceRepository.save(monaco);
            experienceRepository.save(monza);
            experienceRepository.save(vegas);
            experienceRepository.save(miami);
            experienceRepository.save(marinaBay);
        }
    }
}
