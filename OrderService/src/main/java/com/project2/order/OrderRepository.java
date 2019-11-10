package com.project2.order;

import com.project2.order.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
}
