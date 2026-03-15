package com.jm.logisCode.Repository;

import com.jm.logisCode.Entity.Chofer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChoferRepository extends JpaRepository<Chofer,Long> {
}
