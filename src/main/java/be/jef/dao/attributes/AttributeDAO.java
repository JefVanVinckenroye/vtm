package be.jef.dao.attributes;

import java.util.List;

import be.jef.dao.AbstractDAO;
import be.jef.entities.Personage;
import be.jef.entities.attributes.Attribute;
import be.jef.entities.attributes.AttributeColumn;

public class AttributeDAO extends AbstractDAO {

	public Attribute read(Long idattribute) {
		return getEntityManager().find(Attribute.class, idattribute);
	}

	public List<Attribute> findAll() {
		return getEntityManager().createNamedQuery("Attribute.findAll",
				Attribute.class).getResultList();
	}

	public List<Attribute> findAttributeForAttributeColumn(
			AttributeColumn attributeColumn) {
		return getEntityManager()
				.createNamedQuery("Attribute.findAttributesForColumn",
						Attribute.class)
				.setParameter("attributeColumn", attributeColumn)
				.setHint(
						"javax.persistence.loadgraph",
						getEntityManager().createEntityGraph(
								"Attribute.metAttributeColumn"))
				.getResultList();
	}
}
