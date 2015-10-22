package be.jef.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "character")
public class Character implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long idCharacter;
	private String characterName;
	private String playerName;
	private String chronicle;
	private String nature;
	private String demeanor;
	private String concept;
	private String sire;
	private long clan;
	private long primaryAttCol;
	private long secondaryAttCol;
	private long tertiaryAttCol;
	private long primaryAbilCol;
	private long secondaryAbilCol;
	private long tertiaryAbilCol;
	private long humanity;
	private long willpower;
	private static long health = 7;
	private static long bloodPool;

	public long getIdCharacter() {
		return idCharacter;
	}

	public String getCharacterName() {
		return characterName;
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

	public long getClan() {
		return clan;
	}

	public long getPrimaryAttCol() {
		return primaryAttCol;
	}

	public long getSecondaryAttCol() {
		return secondaryAttCol;
	}

	public long getTertiaryAttCol() {
		return tertiaryAttCol;
	}

	public long getPrimaryAbilCol() {
		return primaryAbilCol;
	}

	public long getSecondaryAbilCol() {
		return secondaryAbilCol;
	}

	public long getTertiaryAbilCol() {
		return tertiaryAbilCol;
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
