package com.tour.agency.repository.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tour.agency.model.Reservation;
import com.tour.agency.repository.ReservationRepository;

@Component
public class ReservationRepositoryImpl implements ReservationRepository {

	@Override
	public void save(Reservation reservation) throws IOException {
		// TODO Auto-generated method stub

		BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
	    writer.append(reservation.toString());
	    writer.flush();
	    
	    writer.close();
	}

	@Override
	public List<String> getAll() throws IOException {

		List<String> reservations = new LinkedList<>();
		String line = null;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
		} catch (FileNotFoundException e) {
			return reservations;
		}

		while ((line = bufferedReader.readLine()) != null) {
			reservations.add(line.trim());
		}
		
		bufferedReader.close();

		return reservations;
	}

}
