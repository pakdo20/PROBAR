package pe.edu.upc.bodega.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.bodega.models.entities.Clasificacion;
@Repository
public interface ClasificacionRepository extends JpaRepository<Clasificacion, Integer> {
	Optional<Clasificacion> findByNombre(String nombre) throws Exception;
}
