package co.com.ccarn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.DetalleListaChequeo;
import co.com.ccarn.model.ListaChequeo;

@Repository
public interface DetalleListaChequeoRepository extends JpaRepository<DetalleListaChequeo, Integer> {
	
	public List<DetalleListaChequeo> findByListaChequeoBean(ListaChequeo listaChequeoBean);

}
