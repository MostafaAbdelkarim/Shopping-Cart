package io.mostafaeldahshan.simon_and_kucher.service;

import io.mostafaeldahshan.simon_and_kucher.dto.CartDTO;
import io.mostafaeldahshan.simon_and_kucher.dto.CartItem;
import io.mostafaeldahshan.simon_and_kucher.dto.ProductDTO;
import io.mostafaeldahshan.simon_and_kucher.model.Cart;
import io.mostafaeldahshan.simon_and_kucher.model.Category;
import io.mostafaeldahshan.simon_and_kucher.model.OrderLineItem;
import io.mostafaeldahshan.simon_and_kucher.model.Product;
import io.mostafaeldahshan.simon_and_kucher.repos.CartRepository;
import io.mostafaeldahshan.simon_and_kucher.repos.CategoryRepository;
import io.mostafaeldahshan.simon_and_kucher.repos.OrderLineItemRepository;
import io.mostafaeldahshan.simon_and_kucher.repos.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(final CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart createCart(CartDTO cartDTO) {
        final Cart cart = new Cart();
        Cart savedCart = mapToEntity(cart, cartDTO);
        cartRepository.save(savedCart);
        return savedCart;
    }

    public void addProductToCart(ProductDTO productDTO)
    {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(productDTO.getId());

    }

    public void updateCart(CartDTO cartDTO) {

    }

    public void removeCartItem(CartDTO cartDTO) {

    }

    public void clearCart(CartDTO cartDTO) {
        final Cart cart = new Cart();
        mapToEntity(cart, cartDTO);
//        cartRepository.findAllById();
    }

    public void clearCartTotal(CartDTO cartDTO) {

    }

    public Cart mapToEntity(Cart cart, CartDTO cartDTO){
        cart.setCartItems(cartDTO.getCartItems());
        cart.setCartTotal(cartDTO.getCartTotal());
        return cart;
    }
}
