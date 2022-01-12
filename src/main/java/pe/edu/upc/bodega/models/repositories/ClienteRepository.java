package pe.edu.upc.bodega.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.bodega.models.entities.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	List<Cliente>findByNombreApellidosContaining(String nombreApellidos) throws Exception;
	List<Cliente>findByBodegueroIntegerIs(Integer bodegueroInteger) throws Exception;
}
