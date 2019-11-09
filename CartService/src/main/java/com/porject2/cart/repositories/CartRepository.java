package com.porject2.cart.repositories;

import com.porject2.cart.models.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CartRepository extends PagingAndSortingRepository<Cart,Integer> {
}
