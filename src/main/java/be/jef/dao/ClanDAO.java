package be.jef.dao;

import javax.persistence.EntityManager;

import be.jef.filters.JPAFilter;

public class ClanDAO extends AbstractDAO{
	public ClanDAO read(long idClan) {
		EntityManager entityManager = JPAFilter.getEntityManager();
		try {
			return entityManager.find(ClanDAO.class, idClan);
		} finally {
			entityManager.close();
		}
	}
}
