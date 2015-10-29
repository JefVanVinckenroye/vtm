package be.jef.entities.attributes;

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
@Table(name = "persattribute")
@NamedEntityGraph(name = "PersAttribute.metPersonageEnAttribute", attributeNodes = {
		@NamedAttributeNode("personage"), @NamedAttributeNode("attribute") })
public class PersAttribute implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long persAttId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idattribute")
	AttributeColumn attribute;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "persId")
	private Personage personage;
	private int level;

	public long getPersAttId() {
		return persAttId;
	}

	public AttributeColumn getAttribute() {
		return attribute;
	}

	public Personage getPersonage() {
		return personage;
	}

	public int getLevel() {
		return level;
	}

}
