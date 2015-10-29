package be.jef.dao;

import java.util.List;

import be.jef.entities.AttributeColumns;
import be.jef.entities.PersAttCol;
import be.jef.entities.Personage;
import be.jef.enums.ColValue;

public class PersAttColDAO extends AbstractDAO {

	public PersAttCol read(Long persAttColId) {
		return getEntityManager().find(PersAttCol.class, persAttColId);
	}

	public List<PersAttCol> findAll() {
		return getEntityManager().createNamedQuery("PersAttCol.findAll",
				PersAttCol.class).getResultList();
	}

	public PersAttCol findAttColForPers(Personage personage, AttributeColumns attributeColumn) {
		return getEntityManager()
				.createNamedQuery(
						"PersAttCol.findAttributeColumnForPersonage",
						PersAttCol.class)
				.setParameter("personage", personage)
				.setParameter("attributeColumn", attributeColumn)
				.setHint(
						"javax.persistence.loadgraph",
						getEntityManager().createEntityGraph(
								"PersAttCol.metPersonageEnAttributeColumns"))
				.getSingleResult();
	}
}