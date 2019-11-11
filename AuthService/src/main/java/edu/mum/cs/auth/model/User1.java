package edu.mum.cs.auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User1 extends RepresentationModel {

    private String username;
    private String fullName;
    private String lastName;
    private String avatar;
    private LocalDate dob;
    private String email;
    private String password;
    private Address address;
    private PaymentInfo paymentInfo;
}
