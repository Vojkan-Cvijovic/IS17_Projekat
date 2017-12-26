package com.tour.agency.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tour.agency.dto.ReservationDTO;
import com.tour.agency.model.Reservation;
import com.tour.agency.service.ReservationService;
import java.io.IOException;
import java.util.List;
import org.apache.el.parser.ParseException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String reservation() {
		return "index.html";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> makeReservation(@RequestBody Reservation reservation) throws IOException {
		reservationService.makeNewReservation(reservation);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String retrieveAll() throws IOException, JSONException, ParseException{
		
		List<ReservationDTO> reservations = reservationService.retrieveAllReservations();
		
		StringBuffer buffer = new StringBuffer("<h2>Reservations</h2><br><ul>");
		
		for (ReservationDTO reservation : reservations) {
			buffer.append("<li> " + reservation.getName() + " --- " + reservation.getDestination() + "</li><br>");
		}
		buffer.append("</ul>");
		
		return buffer.toString();
		
	}


}
