package net.karton.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cart implements Serializable {


    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<CartItem> cartItems;


    @OneToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;

    private double grandTotal;


    public long getCartId() {
        return cartId;
    }


    public void setCartId(long cartId) {
        this.cartId = cartId;
    }


    public List<CartItem> getCartItems() {
        return cartItems;
    }


    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }


    public double getGrandTotal() {
        return grandTotal;
    }


    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }


    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + ", cartItems=" + cartItems + ", grandTotal="
                + grandTotal + "]";
    }
}

