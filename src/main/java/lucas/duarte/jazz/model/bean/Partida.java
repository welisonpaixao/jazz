package lucas.duarte.jazz.model.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", resolver = EntityIdResolver.class, scope = Long.class)
public class Partida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int rodada;
	// Campeonato ID vai se o nome da coluna na tabela
	@ManyToOne
	@JoinColumn(name = "campeonato_id")
	@JsonBackReference
	private Campeonato campeonato;
	private String timeA;
	private String timeB;
	private boolean visitante;
	private String descricao;
	private String local;
	// yyyy-MM-dd
	@Temporal(TemporalType.DATE)
	private Date data;

	@OneToMany(mappedBy = "partida", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Set> sets;

	private int desafioA;
	private int desafioB;
	private String urlLogoAdv;
	private String ganhadorPartida;

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

	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getDesafioA() {
		return desafioA;
	}

	public void setDesafioA(int desafioA) {
		this.desafioA = desafioA;
	}

	public int getDesafioB() {
		return desafioB;
	}

	public void setDesafioB(int desafioB) {
		this.desafioB = desafioB;
	}

	public String getUrlLogoAdv() {
		return urlLogoAdv;
	}

	public void setUrlLogoAdv(String urlLogoAdv) {
		this.urlLogoAdv = urlLogoAdv;
	}

	public String getGanhadorPartida() {
		return ganhadorPartida;
	}

	public void setGanhadorPartida(String ganhadorPartida) {
		this.ganhadorPartida = ganhadorPartida;
	}

}
