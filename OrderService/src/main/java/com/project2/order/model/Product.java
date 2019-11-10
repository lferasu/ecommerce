package com.project2.order.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    private Double price;
    private String imageUrl;
    private Integer availableInventory;
    private Integer minimumInventory;
    private String unit;
    @ManyToOne
    Shipment shipment;
}
