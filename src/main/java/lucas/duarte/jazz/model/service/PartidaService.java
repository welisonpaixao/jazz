package lucas.duarte.jazz.model.service;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lucas.duarte.jazz.model.bean.Partida;
import lucas.duarte.jazz.model.repository.PartidaRepository;

@Service
public class PartidaService{
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
	
	public ResponseEntity<List<Partida>> getAllPartidas() {
		//Retorna uma lista de partidas
		List <Partida> partidas = partidaRepo.findAll();
		if (partidas.isEmpty()) {
			new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Partida>>(partidas, HttpStatus.OK);
	}
	
	

}