package com.restapi.restapi.repositories;

import com.restapi.restapi.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository <CarEntity, Integer>{


}
