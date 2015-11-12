package be.jef.entities.abilities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import be.jef.entities.Personage;

@Entity
@Table(name = "persability")
@NamedEntityGraph(name = "PersAbility.metPersonageEnAbilityEnAbilityColumn", attributeNodes = {
		@NamedAttributeNode("personage"), @NamedAttributeNode("ability"),
		@NamedAttributeNode("abilityColumn") })
public class PersAbility implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long persAbilId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idability")
	Ability ability;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "persId")
	private Personage personage;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idAbilityCol")
	AbilityColumn abilityColumn;
	private long level;

	public long getPersAbilId() {
		return persAbilId;
	}

	public Ability getAbility() {
		return ability;
	}

	public Personage getPersonage() {
		return personage;
	}

	public AbilityColumn getAbilityColumn() {
		return abilityColumn;
	}

	public long getLevel() {
		return level;
	}

}