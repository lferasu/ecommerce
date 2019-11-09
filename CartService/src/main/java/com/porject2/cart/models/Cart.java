package com.porject2.cart.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Cart extends RepresentationModel {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    private List<Product> products;
    private Integer uid;
    private Double totalPrice =0.0;

    private void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }
}
