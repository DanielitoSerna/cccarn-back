package co.com.ccarn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.EncabezadoRegistro;

@Repository
public interface EncabezadoRegistroRepository extends JpaRepository<EncabezadoRegistro, Integer> {
	
	public List<EncabezadoRegistro> findByTipoFormato(String tipoFormato);

}
