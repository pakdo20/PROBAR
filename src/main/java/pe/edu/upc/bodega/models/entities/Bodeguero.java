package pe.edu.upc.bodega.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "bodegueros")
public class Bodeguero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_apellidos", length = 50, nullable = false)
	private String nombreApellidos;
	
	@Column(name = "telefono", length = 9, nullable = false)
	private String telefono;
	
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	
	@Column(name = "contra", length = 30, nullable = false)
	private String contra;
	
	@Transient
	@Column(name = "x",nullable = false)
	private Integer x;
	
	@OneToMany(mappedBy = "bodeguero")
	private List<Cliente> clientes;

	public  Bodeguero() {
		clientes = new ArrayList<Cliente>();
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

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	
	
	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
