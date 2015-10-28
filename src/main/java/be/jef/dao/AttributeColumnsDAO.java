package be.jef.dao;

import java.util.List;

import be.jef.entities.AttributeColumns;

public class AttributeColumnsDAO extends AbstractDAO{
	public AttributeColumns read(Long idattributeCol) {
		return getEntityManager().find(AttributeColumns.class, idattributeCol);
	}
	
	public List<AttributeColumns> findAll() {
		return getEntityManager().createNamedQuery("AttributeColumns.findAll",
				AttributeColumns.class).getResultList();
	}

}
