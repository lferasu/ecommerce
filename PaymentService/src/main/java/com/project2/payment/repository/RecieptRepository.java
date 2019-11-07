package com.project2.payment.repository;

import com.project2.payment.controller.model.Reciept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecieptRepository extends JpaRepository<Reciept,Integer> {
}
