package co.com.ccarn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.Caracterizacion;

@Repository
public interface CaracterizacionRepository extends JpaRepository<Caracterizacion, Integer> {

}
