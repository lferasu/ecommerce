package edu.mum.cs.auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@EqualsAndHashCode(callSuper = false)
public class Address extends RepresentationModel {
    private Integer id;
    private String country;
    private String state;
    private String city;
    private String zip;
    private String street;
}
