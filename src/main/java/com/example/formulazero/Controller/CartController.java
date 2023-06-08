package com.example.formulazero.Controller;

import com.example.formulazero.Model.Cart;
import com.example.formulazero.Model.Experience;
import com.example.formulazero.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/cart/")
public class CartController {
    private CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path = "/{cartId}/")
    public Cart getCartById(@PathVariable Long cartId) {
        return cartService.getCartById(cartId);
    }

    @PostMapping(path = "/{cartId}/{experienceId}/")
    public Cart postCart(@PathVariable Long cartId, @PathVariable Long experienceId) {
        return cartService.postCart(cartId, experienceId);
    }
}
