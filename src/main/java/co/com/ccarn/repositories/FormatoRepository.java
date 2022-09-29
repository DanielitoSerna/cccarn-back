package co.com.ccarn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.Formato;

@Repository
public interface FormatoRepository extends JpaRepository<Formato, Integer> {

}
