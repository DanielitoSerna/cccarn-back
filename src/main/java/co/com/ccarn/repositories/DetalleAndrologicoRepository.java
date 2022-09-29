package co.com.ccarn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.DetalleAndrologico;

@Repository
public interface DetalleAndrologicoRepository extends JpaRepository<DetalleAndrologico, Integer> {

}
