package co.com.ccarn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.DetalleTrazabilidad;
import co.com.ccarn.model.Trazabilidad;

@Repository
public interface DetalleTrazabilidadRepository extends JpaRepository<DetalleTrazabilidad, Integer> {
	
	public List<DetalleTrazabilidad> findByTrazabilidadBean(Trazabilidad trazabilidadBean);

}
