package be.jef.services.attributes;

import java.util.List;

import be.jef.dao.attributes.AttributeDAO;
import be.jef.entities.attributes.Attribute;
import be.jef.entities.attributes.AttributeColumn;

public class AttributeService {
	private final AttributeDAO attributeDAO = new AttributeDAO();

	public Attribute read(long idAttribute) {
		return attributeDAO.read(idAttribute);
	}

	public List<Attribute> findAll() {
		return attributeDAO.findAll();
	}

	public List<Attribute> findAttributeForAttributeColumn(
			AttributeColumn attributeColumn) {
		return attributeDAO.findAttributeForAttributeColumn(attributeColumn);
	}

}
