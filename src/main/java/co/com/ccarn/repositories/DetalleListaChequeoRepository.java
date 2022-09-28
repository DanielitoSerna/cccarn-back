package co.com.ccarn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.DetalleListaChequeo;

@Repository
public interface DetalleListaChequeoRepository extends JpaRepository<DetalleListaChequeo, Integer> {

}
