package pe.edu.upc.bodega.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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


import pe.edu.upc.bodega.models.entities.Cliente;
import pe.edu.upc.bodega.models.entities.Factura;
import pe.edu.upc.bodega.models.entities.Tasa;
import pe.edu.upc.bodega.services.ClienteService;
import pe.edu.upc.bodega.services.FacturaService;
import pe.edu.upc.bodega.services.TasaService;



@Controller
@RequestMapping("/facturas")
@SessionAttributes("clienteDeLasFacturas")
public class FacturaController {

	@Autowired
	private FacturaService facturaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TasaService tasaService;
	
	
	@GetMapping("cliente-{id}")
	public String viewFacturasdeCliente (@PathVariable("id") Integer id,Model model )
	{
		
		try {
			Optional<Cliente> optional =clienteService.findById(id);
			//System.out.print(optional.get().getId());
			
			List<Factura> facturas=facturaService.findByCliente(optional.get());
			
			model.addAttribute("facturasDelCliente",facturas);
			
			model.addAttribute("clienteDeLasFacturas", optional);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return "/facturas/inicio-facturas";
	}
	@GetMapping
	public String inicio() {
		return "/facturas/cliente-{id}";
	}
	
	
	
	@GetMapping("/registrar-factura")
	public String registrarFactura(Model model) {
		Factura factura =new Factura();
		try {
			
			model.addAttribute("factura", factura);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/facturas/registrar-factura";
	}


	@PostMapping("save")
	public String save(@ModelAttribute("factura") Factura factura,@ModelAttribute("clienteDeLasFacturas") Cliente cliente, SessionStatus status,Model model) {
		try {
			
			
			
			 RestarFechas(factura);
			
			
			//System.out.print(cliente.getId());
			
			factura.setClienteInteger(88);
			factura.setCliente(cliente);
			facturaService.save(factura);
			
			Tasa tasa =new Tasa();
			tasa.setFactura(factura);
			tasa.setTipo(factura.getTipoTasa());
			tasa.setValor(factura.getValorTasa());
			tasa.setS(factura.getsTasa());
			tasaService.save(tasa);
			
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/facturas/registrar-factura";
	}
	public void ponerlafechabien(Factura factura)
	{
		Date Fcompra=factura.getFechaCompra();
		System.out.print(Fcompra);
		System.out.print("/----/");
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print(formatoFecha.format(Fcompra));
		System.out.print("/----/");
		//fecha desglosada
		//Calendar Ccompra = new GregorianCalendar();
		Calendar Ccompra = Calendar.getInstance();
		Ccompra.setTime(Fcompra);
		System.out.print(Ccompra.getTime());
		System.out.print("/----/");
		int anioInicio =Ccompra.get(Calendar.YEAR);
		int mesInicio=Ccompra.get(Calendar.MONTH)+1;
		int diaInicio=Ccompra.get(Calendar.DAY_OF_MONTH)+1;
		
		Ccompra.set(Calendar.YEAR, anioInicio);
		Ccompra.set(Calendar.MONTH, mesInicio);
		Ccompra.set(Calendar.DAY_OF_MONTH, diaInicio);
		
		factura.setFechaCompra(Ccompra.getTime());
		
		
		Date Fpago=factura.getFechaPago();
		System.out.print(Fpago);
		
		Calendar Cpago = Calendar.getInstance();
		Cpago.setTime(Fpago);
		System.out.print(Ccompra.getTime());
		System.out.print("/----/");
		int anioActual =Cpago.get(Calendar.YEAR);
		int mesActual=Cpago.get(Calendar.MONTH)+1 ;
		int diaActual=Cpago.get(Calendar.DAY_OF_MONTH)+1;
		
		Cpago.set(Calendar.YEAR, anioActual);
		Cpago.set(Calendar.MONTH, mesActual);
		Cpago.set(Calendar.DAY_OF_MONTH, diaActual);
		
		
		factura.setFechaPago(Cpago.getTime());
	}
	
	@GetMapping("viewFactura-{id}")
	public String viewFactura(@PathVariable("id") Integer id,Model model)
	{
		try {
			Optional<Factura> optional =facturaService.findById(id);
			
			if(optional.isPresent())
			{
				model.addAttribute("facturaview",optional.get());
				return "/facturas/view-factura";
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return "redirect:/clientes";
	}
	
	public void RestarFechas(Factura factura)
	{
		Date Fcompra=factura.getFechaCompra();
		System.out.print(Fcompra);
		System.out.print("/----/");
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print(formatoFecha.format(Fcompra));
		System.out.print("/----/");
		//fecha desglosada
		//Calendar Ccompra = new GregorianCalendar();
		Calendar Ccompra = Calendar.getInstance();
		Ccompra.setTime(Fcompra);
		System.out.print(Ccompra.getTime());
		System.out.print("/----/");
		int anioInicio =Ccompra.get(Calendar.YEAR);
		int mesInicio=Ccompra.get(Calendar.MONTH)+1;
		int diaInicio=Ccompra.get(Calendar.DAY_OF_MONTH)+1;
		
		
		Date Fpago=factura.getFechaPago();
		System.out.print(Fpago);
		
		Calendar Cpago = Calendar.getInstance();
		Cpago.setTime(Fpago);
		System.out.print(Ccompra.getTime());
		System.out.print("/----/");
		int anioActual =Cpago.get(Calendar.YEAR);
		int mesActual=Cpago.get(Calendar.MONTH)+1 ;
		int diaActual=Cpago.get(Calendar.DAY_OF_MONTH)+1;
		
		System.out.print("FECHA DE COMPRA_" + anioInicio + "_" + mesInicio + "_" + diaInicio);

		System.out.print("&&&&&&");

		System.out.print("FECHA DE PAGO_" + anioActual + "_" + mesActual + "_" + diaActual);
		
		
		
		Ccompra.set(Calendar.YEAR, anioInicio);
		Ccompra.set(Calendar.MONTH, mesInicio);
		Ccompra.set(Calendar.DAY_OF_MONTH, diaInicio);
		
		
		Cpago.set(Calendar.YEAR, anioActual);
		Cpago.set(Calendar.MONTH, mesActual);
		Cpago.set(Calendar.DAY_OF_MONTH, diaActual);
		
		
		
		factura.setFechaCompra(Ccompra.getTime());
		factura.setFechaPago(Cpago.getTime());
		
		
		
		
		int b = 0;
        int dias = 0;
        int mes = 0;
        int anios = 0;
        int meses = 0;
        int cuantos_meses_faltan=0;
        mes = mesInicio;
		if (mes == 2) {
			if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))) {
				b = 29;
			} else {
				b = 28;
			}
		} else if (mes <= 7) {
			if (mes == 0) {
				b = 31;
			} else if (mes % 2 == 0) {
				b = 30;
			} else {
				b = 31;
			}
		} else if (mes > 7) {
			if (mes % 2 == 0) {
				b = 31;
			} else {
				b = 30;
			}
		}
		
		if((anioInicio==anioActual)&&(mesInicio==mesActual))
		{
			dias=diaActual-diaInicio;
		}
		
		if((anioInicio==anioActual)&&(mesInicio<mesActual))
		{	
			
			cuantos_meses_faltan=mesActual-mesInicio;//cuantos meses hay adelante
			int mes_ini=mesInicio;
			int c=0;
			for (int i = 0; i < cuantos_meses_faltan; i++) {
				
				int a=HallardiasdelMes(mes_ini+i, anioActual);
				c=c+a;
				
				
			}
			int f=HallardiasdelMes(mesActual, anioActual);
			int inicialdias=HallardiasdelMes(mesInicio, anioActual);
			
			dias=(inicialdias-diaInicio)+(c-f)+diaActual;
			
		}
		

		System.out.println("HHHHHHHH");
		System.out.println("Años: " + anios);
		System.out.println("Meses: " + meses);
		System.out.println("Días: " + dias);
		
		
		factura.setDias(dias);
		

	}
	
	
	public int HallardiasdelMes(int mes,int anioActual)
	{
		int b=0;
		if (mes == 2) {
			if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))) {
				b = 29;
			} else {
				b = 28;
			}
			return b;
		} else if (mes <= 7) {
			if (mes == 0) {
				b = 31;
			} else if (mes % 2 == 0) {
				b = 30;
			} else {
				b = 31;
			}
			return b;
		} else if (mes > 7) {
			if (mes % 2 == 0) {
				b = 31;
			} else {
				b = 30;
			}
			return b;
		}
		
		return b;
	}
	

	
	
	
}
