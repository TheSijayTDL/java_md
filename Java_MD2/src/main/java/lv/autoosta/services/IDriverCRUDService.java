package lv.autoosta.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import lv.autoosta.model.BusCategory;
import lv.autoosta.model.Driver;

public interface IDriverCRUDService {
	
	void insertNewDriver(String name, String surname, Set<BusCategory> category) throws Exception;
	
	ArrayList<Driver> selectAllDrivers();
	
	Driver selectDriverByID(long id) throws Exception;
	
	void updateDriverByID(long id, String name, String surname, Set<BusCategory> category) throws Exception;
	
	void deleteDriverByID(long id) throws Exception;
}
