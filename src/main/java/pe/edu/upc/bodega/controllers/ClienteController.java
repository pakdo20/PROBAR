package pe.edu.upc.bodega.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.bodega.models.entities.Bodeguero;
import pe.edu.upc.bodega.models.entities.Cliente;
import pe.edu.upc.bodega.services.BodegueroService;
import pe.edu.upc.bodega.services.ClienteService;

@Controller
@RequestMapping("/clientes")
@SessionAttributes("bodeguero")
public class ClienteController {

	@Autowired
	private ClienteService  clienteService;
	
	@Autowired
	private BodegueroService  bodegueroService;
	
	@GetMapping
	public String inicio(Model model) {
		Cliente cliente =new Cliente();
		
		try {
			List<Bodeguero> Listabodegueros=bodegueroService.findAll();
			
			Optional<Bodeguero> optional = bodegueroService.findById(Listabodegueros.size());
			
			
			
			List<Cliente> clientes= clienteService.findByBodegueroInteger(Listabodegueros.size());
			model.addAttribute("clientes", clientes);
			model.addAttribute("cliente", cliente);
			
			model.addAttribute("bodeguero", optional);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "clientes/inicio-clientes";
	}
	
	@GetMapping("/registrar-cliente")
	public String registrarCliente(Model model) {
		Cliente cliente =new Cliente();
		
		try {
			model.addAttribute("cliente", cliente);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/clientes/registrar-cliente";
	}


	@PostMapping("save")
	public String save(@ModelAttribute("cliente") Cliente cliente,
			@ModelAttribute("bodeguero") Bodeguero bodeguero,Model model, SessionStatus status) {
		try {
			
			cliente.setBodeguero(bodeguero);
			cliente.setBodegueroInteger(bodeguero.getId());
			clienteService.save(cliente);
			
			
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/clientes";
	}
	
	
	@GetMapping("viewCliente-{id}")
	public String viewCliente (@PathVariable("id") Integer id,Model model )
	{
		
		try {
			Optional<Cliente> optional= clienteService.findById(id);
			if(optional.isPresent())
			{
				
				model.addAttribute("clienteview", optional.get());
				return "/clientes/view-cliente";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/clientes";
	}
	
		
	
	
}
