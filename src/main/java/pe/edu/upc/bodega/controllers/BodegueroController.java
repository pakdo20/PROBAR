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

import pe.edu.upc.bodega.models.entities.Bodeguero;
import pe.edu.upc.bodega.services.BodegueroService;

@Controller
@RequestMapping("/bodegueros")
public class BodegueroController {

	@Autowired
	private BodegueroService bodegueroService;
	
	@GetMapping
	public String inicio(Model model) {
		Bodeguero bodeguero = new Bodeguero();
		
		try {
			List<Bodeguero> bodegueros=  bodegueroService.findAll();
			model.addAttribute("bodegueros", bodegueros);
			model.addAttribute("bodeguero", bodeguero);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "/bodegueros/inicio-bodegueros";
	}
	
	@GetMapping("/registrar-bodeguero")
	public String registrarBodeguero(Model model) {
		Bodeguero bodeguero = new Bodeguero();
		try {
			
			model.addAttribute("bodeguero", bodeguero);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/bodegueros/registrar-bodeguero";
	}
	
	
	@PostMapping("save")
	public String save(@ModelAttribute("bodeguero") Bodeguero bodeguero, SessionStatus status) {
		try {
			
			
			
			bodegueroService.save(bodeguero);
			
			
			
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/bodegueros/registrar-bodeguero";
	}
	
}
