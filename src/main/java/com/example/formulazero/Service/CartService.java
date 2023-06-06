package com.example.formulazero.Service;

import com.example.formulazero.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository cartRepository;

    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


}
