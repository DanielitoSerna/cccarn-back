package co.com.ccarn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.Formato;

@Repository
public interface FormatoRepository extends JpaRepository<Formato, Integer> {
	
	public List<Formato> findByTipoFormato(String tipoFormato);

}
