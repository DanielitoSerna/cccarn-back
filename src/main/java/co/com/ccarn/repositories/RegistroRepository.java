package co.com.ccarn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.EncabezadoRegistro;
import co.com.ccarn.model.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
	
	public List<Registro> findByEncabezadoRegistroBean(EncabezadoRegistro encabezadoRegistroBean);

}
