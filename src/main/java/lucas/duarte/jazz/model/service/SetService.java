package lucas.duarte.jazz.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucas.duarte.jazz.model.bean.Set;
import lucas.duarte.jazz.model.repository.SetRepository;

@Service
public class SetService {
	
	@Autowired
	private SetRepository setRepo;

	// Criar novo set
	public void salvarSet(Set set) {
		setRepo.save(set);
	}

}
