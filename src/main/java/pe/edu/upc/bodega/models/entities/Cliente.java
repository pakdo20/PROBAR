package pe.edu.upc.bodega.models.entities;

import java.util.ArrayList;
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
import javax.persistence.Transient;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "nombres_apellidos", length = 50, nullable = false)
	private String nombreApellidos;
	
	@Column(name = "telefono", length = 9, nullable = false)
	private String telefono;
	
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	
	@Column(name = "direccion", length = 50, nullable = false)
	private String direccion;
	
	
	@Column(name = "monto", nullable = true)
	private Float monto;
	
	@Column(name = "monto_max", nullable = false)
	private Float montoMax;
	
	@Transient
	@Column(name = "x",nullable = false)
	private Integer x;
	
	@Column(name = "bodeguero_integer",nullable = true)
	private Integer bodegueroInteger;
	
	
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas;
	
	@ManyToOne
	@JoinColumn(name="bodeguero_id")
	private Bodeguero bodeguero;
	
	public Cliente() {
		facturas = new ArrayList<Factura>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Float getMontoMax() {
		return montoMax;
	}

	public void setMontoMax(Float montoMax) {
		this.montoMax = montoMax;
	}

	
	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	
	

	public Integer getBodegueroInteger() {
		return bodegueroInteger;
	}

	public void setBodegueroInteger(Integer bodegueroInteger) {
		this.bodegueroInteger = bodegueroInteger;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Bodeguero getBodeguero() {
		return bodeguero;
	}

	public void setBodeguero(Bodeguero bodeguero) {
		this.bodeguero = bodeguero;
	}
}
