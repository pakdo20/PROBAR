package pe.edu.upc.bodega.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.bodega.models.entities.Detalle;
import pe.edu.upc.bodega.models.repositories.DetalleRepository;
import pe.edu.upc.bodega.services.DetalleService;
@Service
public class DetalleServiceImpl implements DetalleService,Serializable {

	
	private static final long serialVersionUID = 1L;

	@Autowired
	private DetalleRepository detalleRepository;
	
	@Transactional
	@Override
	public Detalle save(Detalle entity) throws Exception {
		return detalleRepository.save(entity);
	}
	@Transactional
	@Override
	public Detalle update(Detalle entity) throws Exception {
		return detalleRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		detalleRepository.deleteById(id);
		
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Detalle> findById(Integer id) throws Exception {
		return detalleRepository.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Detalle> findAll() throws Exception {
		return detalleRepository.findAll();
	}

}
