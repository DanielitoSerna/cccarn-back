package co.com.ccarn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.ListaChequeo;

@Repository
public interface EncabezadoListaChequeoRepository extends JpaRepository<ListaChequeo, Integer> {
	
	public List<ListaChequeo> findByTipoFormato(String tipoFormato);

}
