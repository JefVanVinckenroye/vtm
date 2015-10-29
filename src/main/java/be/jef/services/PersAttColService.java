package be.jef.services;

import java.util.List;

import be.jef.dao.PersAttColDAO;
import be.jef.entities.PersAttCol;

public class PersAttColService {
	private final PersAttColDAO persAttColDAO = new PersAttColDAO();

	public PersAttCol read(long persAttColId) {
		return persAttColDAO.read(persAttColId);
	}

	public List<PersAttCol> findAll() {
		return persAttColDAO.findAll();
	}

}
