package co.com.ccarn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ccarn.model.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {

}
