package com.project2.productservice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    private Product product;
    private Integer availableInventory;
    private Integer minimumInventory;
    private String unit;

    public void increaseAvailableInventory(Integer value) {
        availableInventory +=value;
    }

    public boolean isValidInventory(Integer value) {
        return ((availableInventory-value) > minimumInventory);
    }
}
