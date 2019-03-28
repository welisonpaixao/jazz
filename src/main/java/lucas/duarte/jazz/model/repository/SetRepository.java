package lucas.duarte.jazz.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucas.duarte.jazz.model.bean.Set;

@Repository
public interface SetRepository extends JpaRepository<Set, Long> {

}
