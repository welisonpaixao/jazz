package lucas.duarte.jazz.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lucas.duarte.jazz.model.bean.Administrador;
import lucas.duarte.jazz.model.repository.AdministradorRepository;

@Service
public class AdministradorService {
	@Autowired
	private AdministradorRepository administradorRepository;

	public ResponseEntity<Administrador> cadastrarAdministrador(Administrador adm) {
		try {
			administradorRepository.save(adm);
			return new ResponseEntity<Administrador>(adm, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<Administrador> DeletarAdministrador(Administrador adm) {
		try {
			administradorRepository.delete(adm);
			return new ResponseEntity<Administrador>(adm, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Administrador> getAdministradorById(Long id) {

		Administrador administrador = administradorRepository.findById(id).orElse(null);

		if (administrador != null)
			return new ResponseEntity<Administrador>(administrador, HttpStatus.OK);
		else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<List<Administrador>> getAlladministradores() {
		// Retorna uma lista de partidas
		List<Administrador> administradores = administradorRepository.findAll();
		if (administradores.isEmpty()) {
			new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Administrador>>(administradores, HttpStatus.OK);
	}

	public ResponseEntity<Administrador> updateAdm(Administrador adm, long id) {
		Administrador admUpdate = administradorRepository.findById(id).orElse(null);
		if (admUpdate != null) {
			if (admUpdate.getNome() != null) {
				admUpdate.setNome(adm.getNome());
			} else if (admUpdate.getEmail() != null) {
				admUpdate.setEmail(admUpdate.getEmail());
			} else if (adm.getSenha() != null) {
				admUpdate.setSenha(admUpdate.getSenha());
			}
			administradorRepository.save(admUpdate);

			return new ResponseEntity<Administrador>(admUpdate, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	public boolean loginAdmin(Administrador adm) {
		Administrador admExistente = administradorRepository.findByEmailandSenha(adm.getEmail(), adm.getSenha());
		if (admExistente != null) {

			return true;

		} else {
			return false;

		}
	}

}
