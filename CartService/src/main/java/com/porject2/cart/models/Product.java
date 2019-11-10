package com.porject2.cart.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Product extends RepresentationModel {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String vendor;
    private String category;
    private Integer availableInventory;
    private Integer minimumInventory;
    private String unit;
    private Double price;

   // private Cart cart;

    public void increaseAvailableInventory(Integer value) {
        availableInventory +=value;
    }

    public boolean isValidInventory(Integer value) {
        return ((availableInventory-value) > minimumInventory);
    }

}
