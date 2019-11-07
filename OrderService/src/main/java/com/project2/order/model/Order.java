package com.project2.order.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Order extends RepresentationModel {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer uid;
    private  Double totalPricel;
    private String shipmentAddress;
    private LocalDate orderDate;
    private Integer cartNumber;
    @OneToMany
    List<Product> products;

}
