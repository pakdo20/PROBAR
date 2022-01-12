package pe.edu.upc.bodega.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.bodega.models.entities.Producto;
@Repository
public interface ProductoRepository  extends JpaRepository<Producto, Integer>{
	List<Producto> findByNombreContaining(String nombre) throws Exception;
}
