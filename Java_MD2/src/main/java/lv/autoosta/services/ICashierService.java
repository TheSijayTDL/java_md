package lv.autoosta.services;

import java.util.ArrayList;

import lv.autoosta.model.Cashier;

public interface ICashierService {
	
	ArrayList<Cashier> selectAllCashiers();
	
	Cashier selectCashierByIdcas(long idcas) throws Exception;

}
