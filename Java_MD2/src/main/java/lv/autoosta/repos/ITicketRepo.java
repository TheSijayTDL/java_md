package lv.autoosta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.autoosta.model.Ticket;

public interface ITicketRepo extends CrudRepository<Ticket, Long> {
	ArrayList<Ticket> findAllByIsChild(boolean isChild);

	ArrayList<Ticket> findAllByPriceLessThan(float price);

	ArrayList<Ticket> findAllByTripsIdtr(long idtr);

	ArrayList<Ticket> findAllByCashierIdcas(long idcas);

}
