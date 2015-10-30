package be.jef.services.attributes;

import java.util.List;

import be.jef.dao.attributes.AttributeColumnDAO;
import be.jef.entities.attributes.AttributeColumn;

public class AttributeColumnService {
	private final AttributeColumnDAO attributeColumnDAO = new AttributeColumnDAO();

	public AttributeColumn read(long idattributeCol) {
		return attributeColumnDAO.read(idattributeCol);
	}

	public List<AttributeColumn> findAll() {
		return attributeColumnDAO.findAll();
	}

}
