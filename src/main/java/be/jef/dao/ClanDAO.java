package be.jef.dao;

import java.util.List;

import be.jef.entities.Clan;

public class ClanDAO extends AbstractDAO{
		
	public Clan read(Long idClan) {
		return getEntityManager().find(Clan.class, idClan);
	}
	
	public List<Clan> findAll() {
		return getEntityManager().createNamedQuery("Clan.findAll",
				Clan.class).getResultList();
	}
}
