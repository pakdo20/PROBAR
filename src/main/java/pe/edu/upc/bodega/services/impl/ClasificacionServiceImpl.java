package pe.edu.upc.bodega.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.bodega.models.entities.Clasificacion;
import pe.edu.upc.bodega.models.repositories.ClasificacionRepository;
import pe.edu.upc.bodega.services.ClasificacionService;
@Service
public class ClasificacionServiceImpl  implements ClasificacionService,Serializable {

	
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClasificacionRepository clasificacionRepository;
	
	@Transactional
	@Override
	public Clasificacion save(Clasificacion entity) throws Exception {
		return clasificacionRepository.save(entity);
	}
	@Transactional
	@Override
	public Clasificacion update(Clasificacion entity) throws Exception {
		return clasificacionRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		clasificacionRepository.deleteById(id);
		
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Clasificacion> findById(Integer id) throws Exception {
		return clasificacionRepository.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Clasificacion> findAll() throws Exception {
		return clasificacionRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Clasificacion> findByNombre(String nombre) throws Exception {
		return clasificacionRepository.findByNombre(nombre);
	}

}
