package net.karton.controller;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import net.karton.model.Order;
import net.karton.model.Product;
import net.karton.model.User;
import net.karton.service.OrderService;
import net.karton.service.ProductService;
import net.karton.service.UserService;
import org.glassfish.jersey.internal.util.collection.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class AdminController {

    @Value("${upload.path}")
    private String uploadPath;

    private final UserService userService;

    private final ProductService productService;

    private final OrderService orderService;

    @Autowired
    public AdminController(UserService userService, ProductService productService, OrderService orderService) {
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @PostMapping("/admin/add_prod")
    public ResponseEntity<?> addProduct(
            @Valid Product product,
            BindingResult bindingResult,
            @RequestPart(name = "file", required = false) MultipartFile file
    ) throws IOException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
        } else {
            saveFile(product, file);

            Product savedProduct = productService.save(product);

            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        }
    }

    @PostMapping("/admin/edit")
    public ResponseEntity<?> updateProduct(
            @Valid Product product,
            BindingResult bindingResult,
            @RequestPart(name = "file", required = false) MultipartFile file
    ) throws IOException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
        } else {
            saveFile(product, file);

            productService.saveProductInfoById(product.getProductName(),
                    product.getProductCategory(),
                    product.getDescription(),
                    product.getFilename(),
                    product.getPrice(),
                    product.getQuantity(),
                    product.getId());

            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @GetMapping("/admin/orders")
    public ResponseEntity<?> getAllOrders() {
        List<Order> orders = orderService.findAll();

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/admin/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long userId) {
        User user = userService.getOne(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/admin/user/all")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/admin/user/edit")
    public ResponseEntity<?> updateUser(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        userService.userSave(username, form, user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void saveFile(Product product, @RequestParam("file") MultipartFile file) throws IOException {
        if (file == null) {
            product.setFilename("empty.jpg");
        } else {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));
            product.setFilename(resultFilename);
        }
    }
}
