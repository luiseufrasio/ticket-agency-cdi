package com.packtpub.wflydevelopment.chapter4.controller;

import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.packtpub.wflydevelopment.chapter4.entity.Seat;

@Named
@ViewScoped
public class BookingRecord implements Serializable {

	private static final long serialVersionUID = 4315876265928709233L;

	private int bookedCount = 0;

	public int getBookedCount() {
		return bookedCount;
	}

	public void bookEvent(@Observes Seat bookedSeat) {
		bookedCount++;
	}
}