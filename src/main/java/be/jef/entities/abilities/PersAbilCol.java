package be.jef.entities.abilities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import be.jef.entities.Personage;
import be.jef.enums.ColValue;

@Entity
@Table(name = "persabilcol")
@NamedEntityGraph(name = "PersAbilCol.metPersonageEnAbilityColumn", attributeNodes = {
		@NamedAttributeNode("personage"), @NamedAttributeNode("abilityColumn") })
public class PersAbilCol implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long persAbilColId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idattributeCol")
	AbilityColumn abilityColumn;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "persId")
	private Personage personage;
	@Enumerated(EnumType.STRING)
	private ColValue abilColValue;

	public long getPersAbilColId() {
		return persAbilColId;
	}

	public AbilityColumn getAbilityColumn() {
		return abilityColumn;
	}

	public Personage getPersonage() {
		return personage;
	}

	public ColValue getAbilColValue() {
		return abilColValue;
	}

}
