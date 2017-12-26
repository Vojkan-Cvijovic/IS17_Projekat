package com.tour.agency.dto;

import com.tour.agency.model.Reservation;

public class ReservationDTO {

	public ReservationDTO(Reservation reservation) {
		this.name = reservation.getName();
		switch (reservation.getId()) {
		case 1:
			this.destination = "Pariz";
			break;
		case 2:
			this.destination = "Bec";
			break;
		case 3:
			this.destination = "London";
			break;
		case 4:
			this.destination = "Budva";
			break;
		case 5:
			this.destination = "Kopaonik";
			break;
		case 6:
			this.destination = "Herceg Novi";
			break;

		}
	}

	private String name;
	private String destination;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
