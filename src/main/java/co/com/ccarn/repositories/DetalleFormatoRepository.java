package co.com.ccarn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.DetalleFormato;

@Repository
public interface DetalleFormatoRepository extends JpaRepository<DetalleFormato, Integer> {

}
