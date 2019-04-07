package lucas.duarte.jazz.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lucas.duarte.jazz.model.bean.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador,String>{

	Administrador findById(Long id);

}
