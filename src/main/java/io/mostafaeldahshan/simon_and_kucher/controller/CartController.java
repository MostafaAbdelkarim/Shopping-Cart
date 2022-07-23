package io.mostafaeldahshan.simon_and_kucher.controller;

import io.mostafaeldahshan.simon_and_kucher.dto.CartDTO;
import io.mostafaeldahshan.simon_and_kucher.dto.CartItem;
import io.mostafaeldahshan.simon_and_kucher.dto.ProductDTO;
import io.mostafaeldahshan.simon_and_kucher.service.CartService;
import io.mostafaeldahshan.simon_and_kucher.service.ProductService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/api/v1/cart", produces = MediaType.APPLICATION_JSON_VALUE)
public class CartController {

    private final CartService cartService;

    public CartController(final CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping()
    @ApiResponse(responseCode = "200")
    public void createNewCart(@RequestBody @Valid final CartDTO cartDTO){
        cartService.createCart(cartDTO);
    }

    @PostMapping()
    @ApiResponse(responseCode = "200")
    public void addProductToCart(@RequestBody @Valid final ProductDTO productDTO){
        cartService.addProductToCart(productDTO);
    }
}
