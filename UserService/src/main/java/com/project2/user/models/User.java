package com.project2.user.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class User extends RepresentationModel {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String avatar;
    private LocalDate dob;
    private String email;
    @OneToMany
    private List<Address> addresses;
    @OneToMany
    private List<PaymentInfo> paymentInfo;
}
