package pe.edu.upc.bodega.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.bodega.models.entities.Tasa;
@Repository
public interface TasaRepository extends JpaRepository<Tasa, Integer> {
	List<Tasa> findByTipoContaining(String tipo) throws Exception;
}
