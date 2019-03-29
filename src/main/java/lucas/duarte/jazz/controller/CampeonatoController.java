package lucas.duarte.jazz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import lucas.duarte.jazz.model.bean.Campeonato;
import lucas.duarte.jazz.model.service.CampeonatoService;

@RestController
@RequestMapping("/api")
public class CampeonatoController {
	@Autowired
	private CampeonatoService campeonatoServ;
	
	@RequestMapping(value = "/campeonato/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCampeonatos() {
		return campeonatoServ.getAllCampeonatos();

	}
	
	//Retorna apenas o ID e o nome dos campeonatos
	@RequestMapping(value = "/campeonato/names/", method = RequestMethod.GET)
	public ResponseEntity<?> getNamesAndIds() {
		return campeonatoServ.getAllCampeonatosNameId();
	}
	
	
	//Create Partida
	@RequestMapping(value = "/campeonato/", method = RequestMethod.POST)
	public ResponseEntity<?> createCampeonato(@RequestBody Campeonato camp, UriComponentsBuilder ucBuilder) {
		// Apenas retorna a trataviva do service
		return campeonatoServ.salvarCampeonato(camp);

	}

}
