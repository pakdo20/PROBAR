package pe.edu.upc.bodega.models.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "tasas")
public class Tasa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tipo", length = 50, nullable = false)
	private String tipo;
	
	@Column(name = "valor", nullable = false)
	private Float valor;
	
	@Column(name = "capitalizacion", nullable = true)
	private Integer capitalizacion;
	
	@Column(name = "s", nullable = true)
	private Float s;
	
	@ManyToOne
	@JoinColumn(name="factura_id")
	private Factura factura;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Integer getCapitalizacion() {
		return capitalizacion;
	}

	public void setCapitalizacion(Integer capitalizacion) {
		this.capitalizacion = capitalizacion;
	}

	public Float getS() {
		return s;
	}

	public void setS(Float s) {
		this.s = s;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
}
