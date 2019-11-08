package com.project2.user.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Adress  extends RepresentationModel {
    @Id
    @GeneratedValue
    private Integer id;
    private String country;
    private String state;
    private String city;
    private String zip;
    private String street;
}
