package be.jef.dao;

import javax.persistence.EntityManager;

import be.jef.filters.JPAFilter;

public abstract class AbstractDAO {
	protected EntityManager getEntityManager() {
		return JPAFilter.getEntityManager();
	}

	public void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public void commit() {
		getEntityManager().getTransaction().commit();
	}

	public void rollback() {
		getEntityManager().getTransaction().rollback();
	}
}
