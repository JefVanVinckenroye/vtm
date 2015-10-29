package be.jef.dao;

import java.util.List;

import be.jef.entities.PersAttCol;

public class PersAttColDAO extends AbstractDAO {

	public PersAttCol read(Long persAttColId) {
		return getEntityManager().find(PersAttCol.class, persAttColId);
	}

	public List<PersAttCol> findAll() {
		return getEntityManager().createNamedQuery("PersAttCol.findAll", PersAttCol.class)
				.getResultList();
	}
}