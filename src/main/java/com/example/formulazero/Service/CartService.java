package com.example.formulazero.Service;

import com.example.formulazero.Model.Cart;
import com.example.formulazero.Model.Experience;
import com.example.formulazero.Repository.CartRepository;
import com.example.formulazero.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private CartRepository cartRepository;

    private ExperienceRepository experienceRepository;

    @Autowired
    public void setExperienceRepository(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCartById(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        return cart.get();
    }

    public Cart postCart(Long cartId, Long experienceId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        Optional<Experience> experience = experienceRepository.findById(experienceId);
//        cart.get().getExperienceList().add(experience.get());
        experience.get().setCart(cart.get());
        experienceRepository.save(experience.get());
        return cart.get();
    }
}
