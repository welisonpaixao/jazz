package lucas.duarte.jazz.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Set implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private long pontoA;
	private long pontoB;
	private boolean setFinalizado;
	@ManyToOne
	@JoinColumn(name="partida_id")
	private Partida partida;
	
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
		this.pontoA = pontoA;
	}
	public long getPontoB() {
		return pontoB;
	}
	public void setPontoB(long pontoB) {
		this.pontoB = pontoB;
	}
	public boolean isSetFinalizado() {
		return setFinalizado;
	}
	public void setSetFinalizado(boolean setFinalizado) {
		this.setFinalizado = setFinalizado;
	}
		

}
