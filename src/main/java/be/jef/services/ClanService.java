package be.jef.services;

import java.util.List;

import be.jef.dao.ClanDAO;
import be.jef.entities.Clan;

public class ClanService {
	private final ClanDAO clanDAO = new ClanDAO();

	public Clan read(long idClan) {
		return clanDAO.read(idClan);
	}

	public List<Clan> findAll() {
		return clanDAO.findAll();
	}

}
