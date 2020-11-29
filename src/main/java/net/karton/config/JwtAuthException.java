package net.karton.config;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.naming.AuthenticationException;
@Getter
public class JwtAuthException extends AuthenticationException {

    private HttpStatus httpStatus;

    public JwtAuthException(String msg) {
        super(msg);
    }

    public JwtAuthException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }
}
