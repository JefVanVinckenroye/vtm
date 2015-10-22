package be.jef.services;

import java.util.List;

import be.jef.dao.PersonageDAO;
import be.jef.entities.Personage;

public class PersonageService {
	private final PersonageDAO personageDAO = new PersonageDAO();

	public Character read(long idCharacter) {
		return personageDAO.read(idCharacter);
	}
	
	public List<Personage> findAll() { // voor later in de cursus
		 return personageDAO.findAll();
		 } 

}
