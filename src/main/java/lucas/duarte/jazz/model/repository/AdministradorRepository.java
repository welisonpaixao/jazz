package lucas.duarte.jazz.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lucas.duarte.jazz.model.bean.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador,Long>{
	

	public static final String validaAdmin = "SELECT * FROM Administrador WHERE email = ? AND senha = ?";
	@Query(value = validaAdmin, nativeQuery = true)
	Administrador findByEmailandSenha(String email, String senha);
}



