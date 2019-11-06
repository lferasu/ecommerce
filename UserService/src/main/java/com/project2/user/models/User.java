package com.project2.user.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends RepresentationModel {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String avatar;
    private LocalDate dob;
    @OneToMany
    @RestResource(path = "useradress", rel = "adress")
    private List<Adress> adresses;
}
