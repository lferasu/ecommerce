package com.project2.user.repositories;

import com.project2.user.models.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface AdressRepository extends JpaRepository<Adress, Integer> {
}
