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

import pe.edu.upc.bodega.models.entities.Clasificacion;
import pe.edu.upc.bodega.models.entities.Producto;
import pe.edu.upc.bodega.services.ClasificacionService;
import pe.edu.upc.bodega.services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	
	@Autowired  
	private ProductoService productoService;

	@Autowired  
	private ClasificacionService clasificacionService;



	@GetMapping
	public String inicio(Model model) {
		Producto producto =new Producto();
		
		try {
			List<Producto> productos= productoService.findAll();
			model.addAttribute("productos", productos);
			model.addAttribute("producto", producto);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "/productos/inicio-productos";
	}

	@GetMapping("/registrar-producto")
	public String registrarProducto(Model model) {
		Producto producto =new Producto();
		
		try {
			List<Clasificacion> clasificaciones = clasificacionService.findAll();
			model.addAttribute("clasificaciones", clasificaciones);
			model.addAttribute("producto", producto);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/productos/registrar-producto";
	}


	@PostMapping("save")
	public String save(@ModelAttribute("producto") Producto producto, SessionStatus status) {
		try {
			
			
			productoService.save(producto);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/productos/registrar-producto";
	}
}
