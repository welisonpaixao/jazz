package lucas.duarte.jazz.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "meu_set")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
//property  = "id",
//resolver = EntityIdResolver.class,
//scope     = Long.class)
public class Set implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ponto_a")
	private long pontoA;
	@Column(name = "ponto_b")
	private long pontoB;
	@Column(name = "set_finalizado")
	private boolean setFinalizado;
	@ManyToOne
	@JoinColumn(name = "partida_id")
    @JsonBackReference
	private Partida partida;
	//https://pt.stackoverflow.com/questions/242288/infinite-recursion-stackoverflowerror-erro-ao-listar-produtos-com-categorias
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getPontoA() {
		return pontoA;
	}

	public void setPontoA(long pontoA) {
		this.pontoA += pontoA;
	}

	public long getPontoB() {
		return pontoB;
	}

	public void setPontoB(long pontoB) {
		this.pontoB += pontoB;
	}

	public boolean isSetFinalizado() {
		return setFinalizado;
	}

	public void setSetFinalizado(boolean setFinalizado) {
		this.setFinalizado = setFinalizado;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

}
