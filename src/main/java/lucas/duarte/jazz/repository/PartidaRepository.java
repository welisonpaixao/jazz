package lucas.duarte.jazz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucas.duarte.jazz.bean.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
	//E possivel criar metodos de query especificos aqui
}
