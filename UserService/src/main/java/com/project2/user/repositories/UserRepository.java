package com.project2.user.repositories;

import com.project2.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface UserRepository extends JpaRepository<User,Integer> {
}
