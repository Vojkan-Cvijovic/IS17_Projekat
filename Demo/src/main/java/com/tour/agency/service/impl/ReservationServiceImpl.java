package com.tour.agency.service.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.apache.el.parser.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.agency.dto.ReservationDTO;
import com.tour.agency.model.Reservation;
import com.tour.agency.repository.ReservationRepository;
import com.tour.agency.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public void makeNewReservation(Reservation reservation) throws IOException {
		// TODO Auto-generated method stub
		reservationRepository.save(reservation);
	}

	@Override
	public List<ReservationDTO> retrieveAllReservations() throws IOException, JSONException, ParseException {
		// TODO Auto-generated method stub
		List<ReservationDTO> reservations = new LinkedList<>();
		List<String> reservationsAll = reservationRepository.getAll();
		Iterator<String> iterator = reservationsAll.iterator();
		
		while(iterator.hasNext()){
			String line = iterator.next();
			
			JSONObject object = new JSONObject(line);
			if(!object.has("type") && !object.getString("type").equalsIgnoreCase("reservation"))
				continue;
			
			Reservation reservation = new Reservation();
			if(object.has("name"))
				reservation.setName(object.getString("name"));
			else
				throw new ParseException();
			if(object.has("id"))
				reservation.setId(object.getInt("id"));
			else
				throw new ParseException();
			
			reservations.add(new ReservationDTO(reservation));
		}
		
		return reservations;
	}

}
