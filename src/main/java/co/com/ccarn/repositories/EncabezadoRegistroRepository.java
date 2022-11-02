package co.com.ccarn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.EncabezadoRegistro;

@Repository
public interface EncabezadoRegistroRepository extends JpaRepository<EncabezadoRegistro, Integer> {

}
