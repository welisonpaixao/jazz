package lucas.duarte.jazz.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucas.duarte.jazz.model.bean.Partida;
import lucas.duarte.jazz.model.repository.PartidaRepository;

@Service
public class PartidaService {
	@Autowired
	private PartidaRepository partidaRepo;

	public void cadastrarPartida(Partida partida) {
		// Mocar Sao judas como time A
		partida.setTimeA("Sao Judas");
		partidaRepo.save(partida);
	}

	public Partida getpartidaById(Long id) {
		System.out.println("Pegar partida pelo ID");
		return partidaRepo.findById(id).orElse(null);
	}

	public List<Partida> getAllPartidas() {
		List<Partida> partidas = partidaRepo.findAll();
		return partidas;
	}

	public List<Partida> getPartidaEmAndamento() {
		return partidaRepo.findPartidasEmAndamento();
	}

}