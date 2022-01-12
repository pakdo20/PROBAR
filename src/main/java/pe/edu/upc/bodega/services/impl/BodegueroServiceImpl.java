package pe.edu.upc.bodega.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.bodega.models.entities.Bodeguero;
import pe.edu.upc.bodega.models.repositories.BodegueroRepository;
import pe.edu.upc.bodega.services.BodegueroService;

@Service
public class BodegueroServiceImpl implements BodegueroService,Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private BodegueroRepository  bodegueroService;
	
	@Transactional
	@Override
	public Bodeguero save(Bodeguero entity) throws Exception {
		
		return bodegueroService.save(entity);
	}
	@Transactional
	@Override
	public Bodeguero update(Bodeguero entity) throws Exception {
		
		return bodegueroService.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		bodegueroService.deleteById(id);
		
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Bodeguero> findById(Integer id) throws Exception {
		return bodegueroService.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Bodeguero> findAll() throws Exception {
		return bodegueroService.findAll();
	}

}
