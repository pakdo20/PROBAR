package pe.edu.upc.bodega.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.bodega.models.entities.Bodeguero;
@Repository
public interface BodegueroRepository extends JpaRepository<Bodeguero, Integer>{

}
