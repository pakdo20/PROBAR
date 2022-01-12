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
import pe.edu.upc.bodega.services.ClasificacionService;

@Controller
@RequestMapping("/clasificaciones")
public class ClasificacionController {

	@Autowired
	private ClasificacionService clasificacionService;
	
	@GetMapping
	public String inicio(Model model) {
		Clasificacion clasificacion = new Clasificacion();
		
		try {
			List<Clasificacion> clasificaciones=  clasificacionService.findAll();
			model.addAttribute("clasificaciones", clasificaciones);
			model.addAttribute("clasificacion", clasificacion);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "clasificaciones/inicio-clasificaciones";
	}
	
	@GetMapping("/registrar-clasificacion")
	public String registrarClasificacion(Model model) {
		Clasificacion clasificacion = new Clasificacion();
		try {
			
			model.addAttribute("clasificacion", clasificacion);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/clasificaciones/registrar-clasificacion";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("clasificacion") Clasificacion clasificacion, SessionStatus status) {
		try {
			
			
			
			clasificacionService.save(clasificacion);
			
			
			
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/clasificaciones/registrar-clasificacion";
	}
}
