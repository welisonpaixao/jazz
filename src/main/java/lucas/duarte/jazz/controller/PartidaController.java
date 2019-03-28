package lucas.duarte.jazz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import lucas.duarte.jazz.model.bean.Partida;
import lucas.duarte.jazz.model.service.PartidaService;

@RestController
@RequestMapping("/api")
public class PartidaController {
	@Autowired
	private PartidaService partidaServ;
	
	//Get all partidas
	@RequestMapping(value = "/partidas/", method = RequestMethod.GET)
	public ResponseEntity<List<Partida>> listAllpartidas() {
		System.out.println("Entrei no get");
		List <Partida> partidas = partidaServ.getAllPartidas();
		
		if (partidas.isEmpty()) {
			System.out.println("partidas vazias");
			//Retorna 404 pois nao achou nenhua partida
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Partida>>(partidas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/partidas/", method = RequestMethod.POST)
	public ResponseEntity<?> createPartida(@RequestBody Partida partida, UriComponentsBuilder ucBuilder) {
		System.out.println("Vou cadastrar uma partida");
		//Validar se partida Ja Existe
		partidaServ.cadastrarPartida(partida);
		return new ResponseEntity<Partida>(partida, HttpStatus.CREATED);
	
	}
	
	@RequestMapping(value = "/partidas/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPartida(@PathVariable("id") long id) {
		//Retorna objeto ja instanciado
		Partida partida = partidaServ.getpartidaById(id);
		//Nao achou a partida
		if (partida == null) {
			//Nao achou nenhuma partida relacionada
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Partida>(partida, HttpStatus.OK);
	}

}
