package lv.autoosta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.autoosta.model.Cashier;
import lv.autoosta.model.Ticket;
import lv.autoosta.model.Trip;
import lv.autoosta.repos.ICashierRepo;
import lv.autoosta.repos.ITicketRepo;
import lv.autoosta.repos.ITripRepo;
import lv.autoosta.services.ITicketService;

@Service
public class TicketServiceImpl implements ITicketService {
	
	@Autowired
	ITicketRepo ticketRepo;
	
	@Autowired
	ITripRepo tripRepo;
	
	@Autowired
	ICashierRepo cashierRepo;

	@Override
	public ArrayList<Ticket> selectAllChildTickets(boolean isChild) {
		ArrayList<Ticket> filteredResults = ticketRepo.findAllByIsChild(isChild);
		return filteredResults;
	}

	@Override
	public ArrayList<Ticket> selectAllTicketsWherePriceIsLowerThan(float price) throws Exception {
		if (price >= 0) {
			ArrayList<Ticket> filteredResults = ticketRepo.findAllByPriceLessThan(price);
			return filteredResults;
		} else {
			throw new Exception("Incorrect price value!");
		}
	}

	@Override
	public ArrayList<Ticket> selectAllTicketsByTripId(long idtr) throws Exception {
		if (idtr > 0) {
			ArrayList<Ticket> filteredResults = ticketRepo.findAllByTripsIdtr(idtr);
			return filteredResults;
		} else {
			throw new Exception("Incorrect id!");
		}
	}

	@Override
	public float calculateIncomeOfTripByTripId(long idtr) throws Exception {
		if (idtr > 0) {
			if (tripRepo.existsById(idtr)) {
				ArrayList<Ticket> filteredResults = ticketRepo.findAllByTripsIdtr(idtr);
				float sum = 0;
			
				for (Ticket temp : filteredResults) {
					sum += temp.getPrice();
				}
				return sum;
			} else {
				throw new Exception("Trip with the specified id not found!");
			}
		} else {
			throw new Exception("Incorrect id!");
		}
	}
	
	@Override
	public float calculateIncomeOfCashierByCashierId(long idcas) throws Exception {
		if (idcas > 0) {
			if (cashierRepo.existsById(idcas)) {
				ArrayList<Ticket> filteredResults = ticketRepo.findAllByCashierIdcas(idcas);
				float sum = 0;
			
				for (Ticket temp : filteredResults) {
					sum += temp.getPrice();
				}
				return sum;
			} else {
				throw new Exception("Cashier with the specified id not found!");
			}
		} else {
			throw new Exception("Incorrect id!");
		}
	}

	@Override
	public void insertNewTicketToTrip(float price, boolean isChild, Cashier cashier, Trip trip) throws Exception {
		Ticket newTicket = new Ticket(price, isChild, cashier, trip);
		ticketRepo.save(newTicket);
	}

	@Override
	public ArrayList<Ticket> selectAllTickets() {
		return (ArrayList<Ticket>) ticketRepo.findAll();
	}

}
