package com.jakub_filip.vehicle.dao.repositories;

import com.jakub_filip.vehicle.entities.car.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, UUID>, JpaSpecificationExecutor<CarEntity> {

}
