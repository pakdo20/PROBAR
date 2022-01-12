package pe.edu.upc.bodega.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "facturas")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "precio_total", nullable = false)
	private Float precioTotal;
	
	@Column(name = "fecha_compra", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaCompra;
	
	@Column(name = "fecha_pago", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaPago;
	 
	@Column(name = "dias", nullable = true)
	private Integer dias;
	
	@Column(name = "medio_pago", length = 50, nullable = false)
	private String medioPago;
	
	@Column(name = "estado", length = 50, nullable = true)
	private String estado;
	
	@Transient
	@Column(name = "tipo_tasa",nullable = false)
	private String tipoTasa;
	

	@Transient
	@Column(name = "valor_tasa",nullable = false)
	private Float valorTasa;
	

	@Transient
	@Column(name = "s_tasa",nullable = true)
	private Float sTasa;

	
	@Column(name = "cliente_integer",nullable = false)
	private Integer clienteInteger;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "factura")
	private List<Tasa> tasas;

	
	@OneToMany(mappedBy = "factura")
	private List<Detalle> detalles;
	
	
	public Factura() {
		detalles = new ArrayList<Detalle>();
		tasas = new ArrayList<Tasa>();
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Float getPrecioTotal() {
		return precioTotal;
	}


	public void setPrecioTotal(Float precioTotal) {
		this.precioTotal = precioTotal;
	}


	public Date getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	public Date getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}


	public Integer getDias() {
		return dias;
	}


	public void setDias(Integer dias) {
		this.dias = dias;
	}


	public String getMedioPago() {
		return medioPago;
	}


	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Tasa> getTasas() {
		return tasas;
	}


	public void setTasas(List<Tasa> tasas) {
		this.tasas = tasas;
	}


	public List<Detalle> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}


		


	public String getTipoTasa() {
		return tipoTasa;
	}


	public void setTipoTasa(String tipoTasa) {
		this.tipoTasa = tipoTasa;
	}


	public Float getValorTasa() {
		return valorTasa;
	}


	public void setValorTasa(Float valorTasa) {
		this.valorTasa = valorTasa;
	}


	public Float getsTasa() {
		
		if(this.tipoTasa.equals("TEA")) {
			return 34F;
		}
			
		return 8888F;
	}


	public void setsTasa(Float sTasa) {
		this.sTasa = sTasa;
	}


	public Integer getClienteInteger() {
		return clienteInteger;
	}


	public void setClienteInteger(Integer clienteInteger) {
		this.clienteInteger = clienteInteger;
	}


	
	
	
	
	

	
}
