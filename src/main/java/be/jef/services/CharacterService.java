package be.jef.services;

import java.util.List;

import be.jef.dao.CharacterDAO;

public class CharacterService {
	private final CharacterDAO characterDAO = new CharacterDAO();

	public Character read(long idCharacter) {
		return characterDAO.read(idCharacter);
	}
	
	public List<Character> findAll() { // voor later in de cursus
		 return characterDAO.findAll();
		 } 

}
