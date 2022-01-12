package pe.edu.upc.bodega.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.bodega.models.entities.Tasa;
import pe.edu.upc.bodega.models.repositories.TasaRepository;
import pe.edu.upc.bodega.services.TasaService;
@Service
public class TasaServiceImpl  implements  TasaService,Serializable{

	
	private static final long serialVersionUID = 1L;

	@Autowired
	private TasaRepository tasaRepository;

	@Transactional
	@Override
	public Tasa save(Tasa entity) throws Exception {
		return tasaRepository.save(entity);
	}
	@Transactional
	@Override
	public Tasa update(Tasa entity) throws Exception {
		return tasaRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		tasaRepository.deleteById(id);
		
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Tasa> findById(Integer id) throws Exception {
		return tasaRepository.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Tasa> findAll() throws Exception {
		return tasaRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public List<Tasa> findByTipo(String tipo) throws Exception {
		return tasaRepository.findByTipoContaining(tipo);
	}

}
