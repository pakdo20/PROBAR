package pe.edu.upc.bodega.services;





import java.util.List;

import pe.edu.upc.bodega.models.entities.Cliente;
import pe.edu.upc.bodega.models.entities.Factura;

public interface FacturaService extends CrudService<Factura, Integer>{

	List<Factura>findByClienteInteger(Integer clienteInteger) throws Exception;
	List<Factura>findByCliente(Cliente clienteInteger) throws Exception;
}
