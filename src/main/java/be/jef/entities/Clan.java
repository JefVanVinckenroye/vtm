package be.jef.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import be.jef.entities.attributes.PersAttribute;

@Entity
@Table(name = "clan")
public class Clan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long idClan;
	@OneToMany(mappedBy = "clan")
	private Set<Personage> personages = new HashSet<Personage>();
	private String clanName;

	public long getIdClan() {
		return idClan;
	}

	public String getClanName() {
		return clanName;
	}

}
