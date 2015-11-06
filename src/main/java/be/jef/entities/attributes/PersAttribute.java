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
@NamedEntityGraph(name = "PersAttribute.metPersonageEnAttributeEnAttributeColumn", attributeNodes = {
		@NamedAttributeNode("personage"), @NamedAttributeNode("attribute"),
		@NamedAttributeNode("attributeColumn") })
public class PersAttribute implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long persAttId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idattribute")
	Attribute attribute;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "persId")
	private Personage personage;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idattributeCol")
	AttributeColumn attributeColumn;
	private long level;

	public AttributeColumn getAttributeColumn() {
		return attributeColumn;
	}

	public long getPersAttId() {
		return persAttId;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public Personage getPersonage() {
		return personage;
	}

	public long getLevel() {
		return level;
	}

}
