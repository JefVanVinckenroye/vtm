package be.jef.dao;

import java.util.List;

public class CharacterDAO extends AbstractDAO {
	public Character read(Long idCharacter) {
		return getEntityManager().find(Character.class, idCharacter);
	}
	
	public List<Character> findAll() {
		return getEntityManager().createNamedQuery("Character.findAll",
				Character.class).getResultList();
	}
}
