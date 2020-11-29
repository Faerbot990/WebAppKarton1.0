package net.karton.controller;


import lombok.RequiredArgsConstructor;
import net.karton.config.JwtProvider;
import net.karton.dto.UserDto;
import net.karton.model.Product;
import net.karton.model.User;
import net.karton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/rest")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtProvider jwtProvider;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }



    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody UserDto userDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqest.getUsername(), request.getPassword()));
            User user =  userService.findByUsername(request.getUsername());
            String userRole = user.getRoles().iterator().next().name();
            String token = jwtProvider.createToken(request.getUsername(), userRole);
            List<Product> productList = user.getProductList();

            Map<Object, Object> response = new HashMap<>();
            response.put("username", request.getUsername);
            response.put("token", token);
            response.put("userRole", userRole);
            response.put("productList", productList);

            return new  ResponseEntity<>(response,HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("error", HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
