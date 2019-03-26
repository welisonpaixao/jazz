package lucas.duarte.jazz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucas.duarte.jazz.bean.Set;

@Repository
public interface SetRepository extends JpaRepository<Set, Long> {

}
