package pe.edu.upc.bodega.services;

import java.util.List;

import org.springframework.stereotype.Component;

import pe.edu.upc.bodega.models.entities.Producto;
@Component
public interface ProductoService extends CrudService<Producto, Integer> {
	List<Producto> findByNombre(String nombre) throws Exception;
}
