package com.packtpub.wflydevelopment.chapter4.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import com.packtpub.wflydevelopment.chapter4.boundary.TheatreBox;

@Named
@SessionScoped
public class TheatreBooker implements Serializable {

	private static final long serialVersionUID = 5051355626337120253L;

	@Inject
	private Logger logger;

	@Inject
	private TheatreBox box;

	@Inject
	private FacesContext facesContext;

	private int money;

	@PostConstruct
	public void createCustomer() {
		this.money = 100;
	}

	public int getMoney() {
		return money;
	}

	public void bookSeat(int seatId) {
		logger.info("Booking seat " + seatId);
		int seatPrice = box.getSeatPrice(seatId);

		if (seatPrice > money) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not enough money",
					"Registration unsucessful");
			facesContext.addMessage(null, m);
			return;
		}

		box.buyTicket(seatId);

		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Booked!",
				"Booking sucessful");
		facesContext.addMessage(null, m);
		logger.info("Seat booked.");

		money -= seatPrice;
	}

}