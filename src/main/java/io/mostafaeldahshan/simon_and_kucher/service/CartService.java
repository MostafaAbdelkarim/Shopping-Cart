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
        //checking if product exists in cart
        // if yes product++ if not add product to cart
    }

    public void updateCart(CartDTO cartDTO) {
        //comparing current cart with given updated cart
        //if new products found --> add them to cart
        //if products removed --> remove them from cart
        //saving final cart state to db
    }

    public void removeCartItem(CartDTO cartDTO) {
        //checking whether this product in cart
        //if product exits with quantity > 1 removing 1
        //if product does not exist return
    }

    public void clearCart(CartDTO cartDTO) {
        //accessing user cart
        //removing all products
        //saving cart as empty
    }

    public void clearCartTotal(CartDTO cartDTO) {
        //accessing cart and setting total attribute to zero
    }

    public Cart mapToEntity(Cart cart, CartDTO cartDTO){
        cart.setCartItems(cartDTO.getCartItems());
        cart.setCartTotal(cartDTO.getCartTotal());
        return cart;
    }
}
