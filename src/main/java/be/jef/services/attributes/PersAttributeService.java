package be.jef.services.attributes;

import java.util.List;

import be.jef.dao.attributes.PersAttributeDAO;
import be.jef.entities.Personage;
import be.jef.entities.attributes.Attribute;
import be.jef.entities.attributes.PersAttribute;

public class PersAttributeService {
	private final PersAttributeDAO persAttributeDAO = new PersAttributeDAO();

	public PersAttribute read(long persAttId) {
		return persAttributeDAO.read(persAttId);
	}

	public List<PersAttribute> findAll() {
		return persAttributeDAO.findAll();
	}

	public long findPersAttributeForPersonageAndAttribute(Personage personage, Attribute attribute) {
		return persAttributeDAO
				.findPersAttributeForPersonageAndAttribute(personage, attribute).getLevel();
	}
	public List<PersAttribute> findPersAttributeForPersonage(Personage personage) {
		return persAttributeDAO
				.findPersAttributeForPersonage(personage);
	}

}
