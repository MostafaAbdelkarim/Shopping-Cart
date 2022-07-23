package io.mostafaeldahshan.simon_and_kucher.service;

import io.mostafaeldahshan.simon_and_kucher.model.Category;
import io.mostafaeldahshan.simon_and_kucher.model.OrderLineItem;
import io.mostafaeldahshan.simon_and_kucher.model.Product;
import io.mostafaeldahshan.simon_and_kucher.dto.ProductDTO;
import io.mostafaeldahshan.simon_and_kucher.repos.CategoryRepository;
import io.mostafaeldahshan.simon_and_kucher.repos.OrderLineItemRepository;
import io.mostafaeldahshan.simon_and_kucher.repos.ProductRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final OrderLineItemRepository orderLineItemRepository;

    public ProductService(final ProductRepository productRepository,
            final CategoryRepository categoryRepository,
            final OrderLineItemRepository orderLineItemRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.orderLineItemRepository = orderLineItemRepository;
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll(Sort.by("id"))
                .stream()
                .map(product -> mapToDTO(product, new ProductDTO()))
                .collect(Collectors.toList());
    }

    public ProductDTO get(final Long id) {
        return productRepository.findById(id)
                .map(product -> mapToDTO(product, new ProductDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final ProductDTO productDTO) {
        final Product product = new Product();
        mapToEntity(productDTO, product);
        return productRepository.save(product).getId();
    }

    public void update(final Long id, final ProductDTO productDTO) {
        final Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(productDTO, product);
        productRepository.save(product);
    }

    public void delete(final Long id) {
        productRepository.deleteById(id);
    }

    private ProductDTO mapToDTO(final Product product, final ProductDTO productDTO) {
        productDTO.setId(product.getId());
        productDTO.setCode(product.getCode());
        productDTO.setDescription(product.getDescription());
        productDTO.setImage(product.getImage());
        productDTO.setLastUpdate(product.getLastUpdate());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setCategoryId(product.getCategoryId());
        productDTO.setCategoryProduct(product.getCategoryProduct() == null ? null : product.getCategoryProduct().getId());
        productDTO.setProductOrderItem(product.getProductOrderItem() == null ? null : product.getProductOrderItem().getId());
        return productDTO;
    }

    private Product mapToEntity(final ProductDTO productDTO, final Product product) {
        product.setCode(productDTO.getCode());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());
        product.setLastUpdate(productDTO.getLastUpdate());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategoryId(productDTO.getCategoryId());
        final Category categoryProduct = productDTO.getCategoryProduct() == null ? null : categoryRepository.findById(productDTO.getCategoryProduct())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "categoryProduct not found"));
        product.setCategoryProduct(categoryProduct);
        final OrderLineItem productOrderItem = productDTO.getProductOrderItem() == null ? null : orderLineItemRepository.findById(productDTO.getProductOrderItem())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "productOrderItem not found"));
        product.setProductOrderItem(productOrderItem);
        return product;
    }

    public boolean codeExists(final String code) {
        return productRepository.existsByCodeIgnoreCase(code);
    }

}
