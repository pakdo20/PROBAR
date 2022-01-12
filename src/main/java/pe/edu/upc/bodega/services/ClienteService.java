package pe.edu.upc.bodega.services;

import java.util.List;



import pe.edu.upc.bodega.models.entities.Cliente;

public interface ClienteService extends CrudService<Cliente, Integer> {
	List<Cliente>findByNombreApellidos(String nombreApellidos) throws Exception;
	List<Cliente>findByBodegueroInteger(Integer bodegueroInteger) throws Exception;
}
