package com.example.formulazero.Controller;

import com.example.formulazero.Model.Cart;
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

    /**
     * Uses the Cart Service to access the business logic which retrieves the Cart and its contents.
     * @param cartId The ID needed to access the correct cart.
     * @return A cart and its contents.
     */
    @GetMapping(path = "/{cartId}/")
    public Cart getCartById(@PathVariable Long cartId) {
        return cartService.getCartById(cartId);
    }

    /**
     * Uses the Cart service to access the business logic which adds a new Experience into the cart.
     * @param cartId The ID needed to access the correct cart.
     * @param experienceId The ID needed to add the correct Experience object into the cart.
     * @return The new updated cart with its newly added contents.
     */
    @PostMapping(path = "/{cartId}/{experienceId}/")
    public Cart postCart(@PathVariable Long cartId, @PathVariable Long experienceId) {
        return cartService.postCart(cartId, experienceId);
    }

    /**
     * Finds a Cart by its ID and the experience the user is removing by its ID and removes the Experience from the Cart
     * @param cartId The ID needed to find the correct Cart and its contents
     * @param experienceId The ID needed to find the correct Experience
     * @return A newly updated Cart with the Experience removed
     */
    @PostMapping(path = "/remove/{cartId}/{experienceId}/")
    public Cart removeFromCart(@PathVariable Long cartId, @PathVariable Long experienceId) {
        return cartService.removeItemFromCart(cartId, experienceId);
    }
}
