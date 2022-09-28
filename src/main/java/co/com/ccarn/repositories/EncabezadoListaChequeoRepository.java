package co.com.ccarn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.ListaChequeo;

@Repository
public interface EncabezadoListaChequeoRepository extends JpaRepository<ListaChequeo, Integer> {

}
