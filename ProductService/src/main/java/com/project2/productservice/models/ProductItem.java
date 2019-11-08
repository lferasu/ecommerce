package com.project2.productservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductItem {

    private Integer id;
    private String name;
    private String vendor;
    private String category;
    private Double price;
    private String imageUrl;
    private Integer quantity;
    private Integer minimumInventory;
    private String unit;
}
