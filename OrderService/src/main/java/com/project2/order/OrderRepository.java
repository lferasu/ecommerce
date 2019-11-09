package com.project2.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface OrderRepository extends PagingAndSortingRepository {
}
