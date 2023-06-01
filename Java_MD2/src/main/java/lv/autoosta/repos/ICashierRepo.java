package lv.autoosta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.autoosta.model.Cashier;

public interface ICashierRepo extends CrudRepository<Cashier, Long> {
	
}
