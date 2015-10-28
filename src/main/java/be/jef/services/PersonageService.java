package be.jef.services;

import java.util.List;

import be.jef.dao.PersonageDAO;
import be.jef.entities.Personage;

public class PersonageService {
	private final PersonageDAO personageDAO = new PersonageDAO();

	public Personage read(long persId) {
		return personageDAO.read(persId);
	}

	public List<Personage> findAll() {
		return personageDAO.findAll();
	}

}
