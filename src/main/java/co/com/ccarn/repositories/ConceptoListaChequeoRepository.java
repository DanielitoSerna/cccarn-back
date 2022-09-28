package co.com.ccarn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.ConceptoListaChequeo;

@Repository
public interface ConceptoListaChequeoRepository extends JpaRepository<ConceptoListaChequeo, Integer> {

}
