package lv.autoosta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.autoosta.model.City;

public interface ICityRepo extends CrudRepository<City, Long> {

}
