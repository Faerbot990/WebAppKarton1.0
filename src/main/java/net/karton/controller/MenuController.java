package net.karton.controller;

import net.karton.dto.ProductSearchDto;
import net.karton.model.Product;
import net.karton.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest")
public class MenuController {
    private final ProductService productService;

    @Autowired
    public MenuController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/menu/search")
    public ResponseEntity<?> findProductsByFilterParams(@RequestBody ProductSearchDto filterDto) {
        List<Product> filter = productService.filter(filterDto.getProductName(), filterDto.getProductCategory(), filterDto.getPrices());

        return new ResponseEntity<>(filter, HttpStatus.OK);
    }

    @PostMapping("/menu/category")
    public ResponseEntity<?> findByProductCategory(@RequestBody ProductSearchDto filterDto) {
        List<Product> category = productService.findByProductOrderByCategoryDesc(String.valueOf(filterDto.getProductCategory()));

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
