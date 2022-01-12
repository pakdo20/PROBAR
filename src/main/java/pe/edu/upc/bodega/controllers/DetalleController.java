package pe.edu.upc.bodega.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.bodega.models.entities.Cliente;
import pe.edu.upc.bodega.models.entities.Detalle;
import pe.edu.upc.bodega.models.entities.Factura;
import pe.edu.upc.bodega.models.entities.Producto;
import pe.edu.upc.bodega.services.ClienteService;
import pe.edu.upc.bodega.services.DetalleService;
import pe.edu.upc.bodega.services.FacturaService;
import pe.edu.upc.bodega.services.ProductoService;

@Controller
@RequestMapping("/detalles")
public class DetalleController {

	@Autowired  
	private DetalleService detalleService;
	
	@Autowired  
	private FacturaService facturaService;
	
	@Autowired  
	private ProductoService productoService;
	
	@Autowired  
	private ClienteService clienteService;
	
	@GetMapping
	public String inicio(Model model) {
		Detalle detalle =new Detalle();
		
		try {
			List<Detalle> detalles=  detalleService.findAll();
			model.addAttribute("detalles", detalles);
			model.addAttribute("detalle", detalle);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "/detalles/inicio-detalles";
	}
	
	@GetMapping("/registrar-detalle")
	public String registrarDetalle(Model model) {
		Detalle detalle =new Detalle();
		try {
			List<Factura> facturas =facturaService.findAll();
			List<Cliente> clientes =clienteService.findAll();
			List<Producto> productos = productoService.findAll();
			

			model.addAttribute("facturas", facturas);
			
			model.addAttribute("clientes", clientes);
			model.addAttribute("productos", productos);
			
			model.addAttribute("detalle", detalle);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/detalles/registrar-detalle";
	}


	@PostMapping("save")
	public String save(@ModelAttribute("detalle") Detalle detalle, SessionStatus status) {
		try {
			detalleService.save(detalle);
			
			
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/detalles/registrar-detalle";
	}
}
