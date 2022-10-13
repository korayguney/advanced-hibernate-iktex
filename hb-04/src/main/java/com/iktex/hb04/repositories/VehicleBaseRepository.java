package com.iktex.hb04.repositories;

import com.iktex.hb04.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface VehicleBaseRepository<T extends Vehicle> extends JpaRepository<T, Integer> {
}
