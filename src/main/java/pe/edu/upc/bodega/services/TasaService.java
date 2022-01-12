package pe.edu.upc.bodega.services;

import java.util.List;


import pe.edu.upc.bodega.models.entities.Tasa;

public interface TasaService extends CrudService<Tasa, Integer> {
	List<Tasa> findByTipo(String tipo) throws Exception;
}
