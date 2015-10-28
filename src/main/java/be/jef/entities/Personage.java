package be.jef.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "personage", uniqueConstraints = {
		@UniqueConstraint(columnNames = "persName"),
		@UniqueConstraint(columnNames = "persId") })
public class Personage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long persId;
	private String persName;
	private String playerName;
	private String chronicle;
	private String nature;
	private String demeanor;
	private String concept;
	private String sire;
	@ManyToOne(optional = false)
	@JoinColumn(name = "clan")
	private Clan clan;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<PersAttCol> persAttCols = new HashSet<PersAttCol>();
	private long humanity;
	private long willpower;
	private static long health = 7;
	private static long bloodPool;

	public long getPersId() {
		return persId;
	}

	public String getPersName() {
		return persName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getChronicle() {
		return chronicle;
	}

	public String getNature() {
		return nature;
	}

	public String getDemeanor() {
		return demeanor;
	}

	public String getConcept() {
		return concept;
	}

	public String getSire() {
		return sire;
	}

	public Clan getClan() {
		return clan;
	}

	public long getHumanity() {
		return humanity;
	}

	public long getWillpower() {
		return willpower;
	}

	public static long getHealth() {
		return health;
	}

	public static long getBloodPool() {
		return bloodPool;
	}

}
