package com.example.formulazero.Service;

import com.example.formulazero.Model.Cart;
import com.example.formulazero.Model.Experience;
import com.example.formulazero.Repository.CartRepository;
import com.example.formulazero.Repository.ExperienceRepository;
import com.example.formulazero.exceptions.InformationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * Uses the Cart ID to access the database and retrieve a Cart with its contents.
     * @param cartId
     * @return
     */
    public Cart getCartById(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            return cart.get();
        } else {
            throw new InformationNotFoundException("Cart with this ID was not found.");
        }
    }

    /**
     * Uses the Cart ID to retrieve the cart and the Experience ID in order to add the correct Experience to the correct cart.
     * @param cartId The ID needed to access the correct cart and its contents.
     * @param experienceId The ID needed to access the correct Experience and add it to the cart.
     * @return The Cart with the newly add contents and its original contents.
     */
    public Cart postCart(Long cartId, Long experienceId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            Optional<Experience> experience = experienceRepository.findById(experienceId);
            if (experience.isPresent()) {
                experience.get().setCart(cart.get());
                experienceRepository.save(experience.get());
                return cart.get();
            } else {
                throw new InformationNotFoundException("Experience with this ID was not found.");
            }
        } else {
            throw new InformationNotFoundException("Cart with this ID was not found.");
        }
    }
}
