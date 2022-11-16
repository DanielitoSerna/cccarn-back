package co.com.ccarn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.DetalleFormato;
import co.com.ccarn.model.Formato;

@Repository
public interface DetalleFormatoRepository extends JpaRepository<DetalleFormato, Integer> {

	public List<DetalleFormato> findByFormatoBean(Formato formatoBean);
}
