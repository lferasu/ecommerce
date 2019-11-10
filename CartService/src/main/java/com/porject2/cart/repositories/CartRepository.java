package com.porject2.cart.repositories;

import com.porject2.cart.models.Cart;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

    public Cart findByUsernameAndValid(String username, boolean valid);
}
