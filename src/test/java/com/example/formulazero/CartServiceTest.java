package com.example.formulazero;

import com.example.formulazero.Service.CartService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartServiceTest {
    @Autowired
    private CartService cartService;

    @Test
    @DisplayName("Get A Cart By Its Id")
    public void getACartByItsId() {
        cartService.getCartById(1L);
    }


}
