package co.com.ccarn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.Trazabilidad;

@Repository
public interface TrazabilidadRepository extends JpaRepository<Trazabilidad, Integer> {

}
