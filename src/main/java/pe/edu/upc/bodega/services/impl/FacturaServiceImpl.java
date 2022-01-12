package pe.edu.upc.bodega.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.bodega.models.entities.Cliente;
import pe.edu.upc.bodega.models.entities.Factura;
import pe.edu.upc.bodega.models.repositories.FacturaRepository;
import pe.edu.upc.bodega.services.FacturaService;
@Service
public class FacturaServiceImpl implements FacturaService,Serializable {

	
	private static final long serialVersionUID = 1L;

	@Autowired
	private FacturaRepository facturaRepository;
	@Transactional
	@Override
	public Factura save(Factura entity) throws Exception {
		return facturaRepository.save(entity);
	}
	@Transactional
	@Override
	public Factura update(Factura entity) throws Exception {
		return facturaRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		facturaRepository.deleteById(id);
		
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Factura> findById(Integer id) throws Exception {
		return facturaRepository.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Factura> findAll() throws Exception {
		return facturaRepository.findAll();
	}
	@Override
	public List<Factura> findByClienteInteger(Integer clienteInteger) throws Exception {
		return facturaRepository.findByClienteIntegerIs(clienteInteger);
	}
	@Override
	public List<Factura> findByCliente(Cliente clienteInteger) throws Exception {
		return facturaRepository.findByClienteIs(clienteInteger);
	}

}
