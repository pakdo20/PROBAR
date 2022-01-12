package pe.edu.upc.bodega.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.bodega.models.entities.Cliente;
import pe.edu.upc.bodega.models.entities.Factura;

@Repository
public interface FacturaRepository  extends JpaRepository<Factura, Integer>{

	List<Factura>findByClienteIntegerIs(Integer clienteInteger) throws Exception;
	List<Factura>findByClienteIs(Cliente clienteInteger) throws Exception;
}
