package be.jef.services;

import java.util.List;

import be.jef.dao.AttributeColumnsDAO;
import be.jef.entities.AttributeColumns;

public class AttributeColumnsService {
	private final AttributeColumnsDAO attributeColumnsDAO = new AttributeColumnsDAO();

	public AttributeColumns read(long idattributeCol) {
		return attributeColumnsDAO.read(idattributeCol);
	}

	public List<AttributeColumns> findAll() {
		return attributeColumnsDAO.findAll();
	}

}
