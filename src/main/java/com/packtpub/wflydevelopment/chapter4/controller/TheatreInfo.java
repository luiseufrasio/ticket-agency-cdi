package com.packtpub.wflydevelopment.chapter4.controller;

import java.util.Collection;

import com.google.common.collect.Lists;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.packtpub.wflydevelopment.chapter4.boundary.TheatreBox;
import com.packtpub.wflydevelopment.chapter4.entity.Seat;

@Model
public class TheatreInfo {

	@Inject
	private TheatreBox box;

	private Collection<Seat> seats;

	@PostConstruct
	public void restrieveAllSeatsOrderedByName() {
		seats = box.getSeats();
	}

	@Produces
	@Named
	public Collection<Seat> getSeats() {
		return Lists.newArrayList(seats);
	}

	public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Seat member) {
		restrieveAllSeatsOrderedByName();
	}
	
}