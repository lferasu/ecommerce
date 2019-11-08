package com.project2.user.repositories;

import com.project2.user.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface AdressRepository extends JpaRepository<Address, Integer> {
}
