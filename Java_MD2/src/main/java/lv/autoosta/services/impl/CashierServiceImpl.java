package lv.autoosta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.autoosta.model.Cashier;
import lv.autoosta.repos.ICashierRepo;
import lv.autoosta.services.ICashierService;

@Service
public class CashierServiceImpl implements ICashierService {

	@Autowired
	private ICashierRepo cashierRepo;

	
	@Override
	public ArrayList<Cashier> selectAllCashiers() {
		return (ArrayList<Cashier>) cashierRepo.findAll();
	}


	@Override
	public Cashier selectCashierByIdcas(long idcas) throws Exception {
		if (idcas > 0) {
			if (cashierRepo.existsById(idcas)) {
				return cashierRepo.findById(idcas).get();
			} else {
				throw new Exception("There is no cashier with the specified ID!");
			}
		} else {
			throw new Exception("Incorrect id!");
		}
	}
}

