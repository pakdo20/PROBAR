package pe.edu.upc.bodega.services;

import java.util.Optional;



import pe.edu.upc.bodega.models.entities.Clasificacion;

public interface ClasificacionService  extends CrudService<Clasificacion, Integer> {
	Optional<Clasificacion> findByNombre(String nombre) throws Exception;
}
