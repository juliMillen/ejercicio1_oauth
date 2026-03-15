package com.jm.logisCode.Repository;

import com.jm.logisCode.Entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViajeRepository extends JpaRepository<Viaje,Long> {
}
