package com.project2.order.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Shipment extends RepresentationModel {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String shipmentAddress;
    @OneToMany (cascade = CascadeType.ALL)
    List<Product> products;
}
