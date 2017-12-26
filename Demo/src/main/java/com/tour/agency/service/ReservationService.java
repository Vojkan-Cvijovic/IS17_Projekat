package com.tour.agency.service;

import java.io.IOException;
import java.util.List;

import org.apache.el.parser.ParseException;
import org.json.JSONException;

import com.tour.agency.dto.ReservationDTO;
import com.tour.agency.model.Reservation;

public interface ReservationService {

	public void makeNewReservation(Reservation reservation) throws IOException;

	public List<ReservationDTO> retrieveAllReservations() throws IOException, JSONException, ParseException;

}
