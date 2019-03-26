package lucas.duarte.jazz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucas.duarte.jazz.bean.Partida;
import lucas.duarte.jazz.repository.PartidaRepository;

@Service
public class PartidaService {
	@Autowired
	private PartidaRepository partidaRepo;
	
	public void cadastrarPartida(Partida partida) {
		//Mocar Sao judas como time A
		partida.setTimeA("Sao Judas");
		partidaRepo.save(partida);
	}
	
	public Partida getpartidaById(Long id) {
		System.out.println("Pegar partida pelo ID");
		return partidaRepo.findById(id).orElse(null);
	}
	
	public List<Partida> getAllPartidas() {
		//Retorna uma lista de partidas
		return partidaRepo.findAll();
	}

}
