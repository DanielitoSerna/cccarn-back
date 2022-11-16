package co.com.ccarn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.ConceptoListaChequeo;
import co.com.ccarn.model.ListaChequeo;

@Repository
public interface ConceptoListaChequeoRepository extends JpaRepository<ConceptoListaChequeo, Integer> {

	public List<ConceptoListaChequeo> findByListaChequeoBean(ListaChequeo listaChequeoBean);
}
