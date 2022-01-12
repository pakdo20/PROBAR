package pe.edu.upc.bodega.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.bodega.models.entities.Detalle;
@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Integer>{

}
