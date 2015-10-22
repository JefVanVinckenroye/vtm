package be.jef.dao;

import java.util.List;

import be.jef.entities.Personage;

public class PersonageDAO extends AbstractDAO {
	public Character read(Long persId) {
		return getEntityManager().find(Character.class, persId);
	}
	
	public List<Personage> findAll() {
		return getEntityManager().createNamedQuery("Personage.findAll",
				Personage.class).getResultList();
	}
}
