package ru.akhitev.rp.fleet.ship.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akhitev.rp.fleet.ship.db.entity.Defence;

public interface DefenceRepository extends JpaRepository<Defence, Integer> {
}
