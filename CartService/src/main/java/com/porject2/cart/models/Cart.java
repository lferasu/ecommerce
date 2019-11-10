package com.porject2.cart.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Cart extends RepresentationModel {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Product> products =new ArrayList<>();

//    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
//    List<Product> productList = new ArrayList<>();
    private String username;
    private Double totalPrice =0.0;
    private boolean valid;

    private void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

}
