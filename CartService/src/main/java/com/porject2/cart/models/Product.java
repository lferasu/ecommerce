package com.porject2.cart.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private String catagory;
    private Integer availableInventory;
    private Integer minimumInventory;
    private String unit;
    private Double price;

    public void increaseAvailableInventory(Integer value) {
        availableInventory +=value;
    }

    public boolean isValidInventory(Integer value) {
        return ((availableInventory-value) > minimumInventory);
    }

}
