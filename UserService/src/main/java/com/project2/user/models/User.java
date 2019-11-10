package com.project2.user.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User extends RepresentationModel {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String fullName;
    private String avatar;
    private LocalDate dob;
    private String email;
    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    private Address address;
    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    private PaymentInfo paymentInfo;
}
