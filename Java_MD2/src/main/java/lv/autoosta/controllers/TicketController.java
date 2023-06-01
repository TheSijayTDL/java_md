package lv.autoosta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.autoosta.model.Ticket;
import lv.autoosta.services.ICashierService;
import lv.autoosta.services.ITicketService;
import lv.autoosta.services.ITripService;

@Controller
public class TicketController {
	
	@Autowired
	private ITicketService ticketService;
	
	@Autowired
	private ITripService tripService;
	
	@Autowired
	private ICashierService cashierService;
	
	@GetMapping("/ticket/showAll") // localhost:8080/ticket/showAll
	public String getShowAllTicketsFunc(Model model) {
		model.addAttribute("message", ticketService.selectAllTickets());
		return "ticket-all-page"; 
	}
	
	@GetMapping("/ticket/showAll/onlyChild") // localhost:8080/ticket/showAll/onlyChild
	public String getShowAllTicketsForChildFunc(Model model) {
		model.addAttribute("message", ticketService.selectAllChildTickets(true));
		return "ticket-all-page"; 
	}
	
	@GetMapping("/ticket/showAll/onlyAdult") // localhost:8080/ticket/showAll/onlyAdult
	public String getShowAllTicketsForAdultFunc(Model model) {
		model.addAttribute("message", ticketService.selectAllChildTickets(false));
		return "ticket-all-page"; 
	}
	
	@GetMapping("/ticket/showAll/lessThan/{price}") // localhost:8080/ticket/showAll/lessThan/10
	public String getShowAllTicketsLessThanFunc(@PathVariable("price") float price, Model model) {
		try {
			model.addAttribute("message", ticketService.selectAllTicketsWherePriceIsLowerThan(price));
			return "ticket-all-page"; 
		} catch (Exception e) {
			model.addAttribute("packetError", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/ticket/showAll/trip/{idtr}") // localhost:8080/ticket/showAll/trip/3
	public String getShowAllTicketsByTripIdFunc(@PathVariable("idtr") long idtr, Model model) {
		try {
			model.addAttribute("message", ticketService.selectAllTicketsByTripId(idtr));
			return "ticket-all-page"; 
		} catch (Exception e) {
			model.addAttribute("packetError", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/ticket/calculate/trip/{idtr}") // localhost:8080/ticket/calculate/trip/1
	public String getShowIncomeByTripIdFunc(@PathVariable("idtr") long idtr, Model model) {
		try {
			model.addAttribute("message", ticketService.calculateIncomeOfTripByTripId(idtr));
			return "ticket-income-page"; 
		} catch (Exception e) {
			model.addAttribute("packetError", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/ticket/calculate/cashier/{idcas}") // localhost:8080/ticket/calculate/cashier/1
	public String getShowIncomeByCashierIdFunc(@PathVariable("idcas") long idcas, Model model) {
		try {
			model.addAttribute("message", ticketService.calculateIncomeOfCashierByCashierId(idcas));
			return "ticket-income-page"; 
		} catch (Exception e) {
			model.addAttribute("packetError", e.getMessage());
			return "error-page";
		}
	}
			
	@GetMapping("/ticket/add") // localhost:8080/ticket/add
	public String getAddTicketFunc(Model model) {
			model.addAttribute("ticket", new Ticket());
			model.addAttribute("cashier", cashierService.selectAllCashiers());
			model.addAttribute("trip", tripService.selectAllTrips());
			return "ticket-add-page";
	}
	
	@PostMapping("/ticket/add") // localhost:8080/ticket/add
	public String postAddTicketFunc(@Valid Ticket ticket, @RequestParam(value = "cashierList", required = true) long idcas, @RequestParam(value = "tripList", required = true) long idtr, BindingResult result) {
		
		if (!result.hasErrors()) {
			try {
				ticketService.insertNewTicketToTrip(ticket.getPrice(), ticket.getIsChild(), cashierService.selectCashierByIdcas(idcas), tripService.selectTripByIdtr(idtr));
				return "redirect:/ticket/showAll";
			} catch (Exception e) {
				return "redirect:/error";
			}
		} else {
			return "ticket-add-page";
		}
	}

}
