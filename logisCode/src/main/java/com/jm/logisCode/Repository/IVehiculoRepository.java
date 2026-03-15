package com.jm.logisCode.Repository;

import com.jm.logisCode.Entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
}
