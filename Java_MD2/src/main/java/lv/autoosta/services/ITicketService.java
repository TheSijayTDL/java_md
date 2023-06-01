package lv.autoosta.services;

import java.util.ArrayList;

import lv.autoosta.model.Cashier;
import lv.autoosta.model.Ticket;
import lv.autoosta.model.Trip;

public interface ITicketService {
	
	ArrayList<Ticket> selectAllChildTickets(boolean isChild);
	
	ArrayList<Ticket> selectAllTicketsWherePriceIsLowerThan(float price) throws Exception;
	
	ArrayList<Ticket> selectAllTicketsByTripId(long idtr) throws Exception;
	
	float calculateIncomeOfTripByTripId(long idtr) throws Exception;
	
	float calculateIncomeOfCashierByCashierId(long idcas) throws Exception;
	
	void insertNewTicketToTrip(float price, boolean isChild, Cashier cashier, Trip trip) throws Exception;
	
	ArrayList<Ticket> selectAllTickets();
}
