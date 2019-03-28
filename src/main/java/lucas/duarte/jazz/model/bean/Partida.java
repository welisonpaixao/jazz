package lucas.duarte.jazz.model.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", resolver = EntityIdResolver.class, scope = Long.class)
public class Partida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String timeA;
	private String timeB;
	private boolean visitante;

	@OneToMany(mappedBy = "partida", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
	private List<Set> sets;

	public Partida() {

	}

	public List<Set> getSets() {
		return sets;
	}

	public void setSets(List<Set> sets) {
		this.sets = sets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTimeA() {
		return timeA;
	}

	// Mocado o valor pois o Time A sempre e a Sao Judas
	public void setTimeA(String timeA) {
		this.timeA = timeA;
	}

	public String getTimeB() {
		return timeB;
	}

	public void setTimeB(String timeB) {
		this.timeB = timeB;
	}

	public boolean isVisitante() {
		return visitante;
	}

	public void setVisitante(boolean visitante) {
		this.visitante = visitante;
	}

}
