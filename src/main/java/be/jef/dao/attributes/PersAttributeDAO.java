package be.jef.dao.attributes;

import java.util.List;

import be.jef.dao.AbstractDAO;
import be.jef.entities.Personage;
import be.jef.entities.attributes.Attribute;
import be.jef.entities.attributes.PersAttribute;

public class PersAttributeDAO extends AbstractDAO {

	public PersAttribute read(Long persAttId) {
		return getEntityManager().find(PersAttribute.class, persAttId);
	}

	public List<PersAttribute> findAll() {
		return getEntityManager().createNamedQuery("PersAttribute.findAll",
				PersAttribute.class).getResultList();
	}

	public PersAttribute findPersAttributeForPersonageAndAttribute(
			Personage personage, Attribute attribute) {
		return getEntityManager()
				.createNamedQuery(
						"PersAttribute.findPersAttributeForPersonageAndAttribute",
						PersAttribute.class)
				.setParameter("personage", personage)
				.setParameter("attribute", attribute)
				.setHint(
						"javax.persistence.loadgraph",
						getEntityManager()
								.createEntityGraph(
										"PersAttribute.metPersonageEnAttributeEnAttributeColumn"))
				.getSingleResult();
	}
}
