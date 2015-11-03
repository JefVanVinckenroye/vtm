package be.jef.dao.attributes;

import java.util.List;

import be.jef.dao.AbstractDAO;
import be.jef.entities.Personage;
import be.jef.entities.attributes.AttributeColumn;
import be.jef.entities.attributes.PersAttCol;
import be.jef.enums.ColValue;

public class PersAttColDAO extends AbstractDAO {

	public PersAttCol read(Long persAttColId) {
		return getEntityManager().find(PersAttCol.class, persAttColId);
	}

	public List<PersAttCol> findAll() {
		return getEntityManager().createNamedQuery("PersAttCol.findAll",
				PersAttCol.class).getResultList();
	}

	public List<PersAttCol> findAttColForPers(Personage personage) {
		return getEntityManager()
				.createNamedQuery(
						"PersAttCol.findAttributeColumnForPersonage",
						PersAttCol.class)
				.setParameter("personage", personage)				
				.setHint(
						"javax.persistence.loadgraph",
						getEntityManager().createEntityGraph(
								"PersAttCol.metPersonageEnAttributeColumns"))
				.getResultList();
	}
}