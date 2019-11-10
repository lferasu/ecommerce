package com.project2.user.repositories;

import com.project2.user.models.PaymentInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface PaymentMethodRepository extends PagingAndSortingRepository<PaymentInfo,Integer> {
}
