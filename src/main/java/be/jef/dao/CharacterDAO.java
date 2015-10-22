package be.jef.dao;

import javax.persistence.EntityManager;

import be.jef.filters.JPAFilter;

public class CharacterDAO {
	public CharacterDAO read(long idCharacter) {
		EntityManager entityManager = JPAFilter.getEntityManager();
		try {
			return entityManager.find(CharacterDAO.class, idCharacter);
		} finally {
			entityManager.close();
		}
	}
}
