package be.jef.dao;

import java.util.List;

import be.jef.entities.attributes.AttributeColumn;

public class AttributeColumnDAO extends AbstractDAO{
	public AttributeColumn read(Long idattributeCol) {
		return getEntityManager().find(AttributeColumn.class, idattributeCol);
	}
	
	public List<AttributeColumn> findAll() {
		return getEntityManager().createNamedQuery("AttributeColumn.findAll",
				AttributeColumn.class).getResultList();
	}

}
