package be.jef.services.attributes;

import java.util.List;

import be.jef.dao.attributes.PersAttColDAO;
import be.jef.entities.Personage;
import be.jef.entities.attributes.AttributeColumn;
import be.jef.entities.attributes.PersAttCol;

public class PersAttColService {
	private final PersAttColDAO persAttColDAO = new PersAttColDAO();

	public PersAttCol read(long persAttColId) {
		return persAttColDAO.read(persAttColId);
	}

	public List<PersAttCol> findAll() {
		return persAttColDAO.findAll();
	}

	public List<PersAttCol> findAttColForPers(Personage personage) {
		return persAttColDAO.findAttColForPers(personage);
	}

}
