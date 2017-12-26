package com.tour.agency.repository;

import java.io.IOException;
import java.util.List;

import com.tour.agency.model.Reservation;

public interface ReservationRepository {
	static final String FILE_PATH = "db";
	
	public void save(Reservation reservation) throws IOException;

	public List<String> getAll() throws IOException;
}
