package be.jef.entities.attributes;

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
@Table(name = "persattcolumn")
@NamedEntityGraph(name = "PersAttCol.metPersonageEnAttributeColumn", attributeNodes = {
		@NamedAttributeNode("personage"),
		@NamedAttributeNode("attributeColumn") })
public class PersAttCol implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long persAttColId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idattributeCol")
	AttributeColumn attributeColumn;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "persId")
	private Personage personage;
	@Enumerated(EnumType.STRING)
	private ColValue attColValue;

	public long getPersAttColId() {
		return persAttColId;
	}

	public ColValue getAttColValue() {
		return attColValue;
	}

	public AttributeColumn getAttributeColumn() {
		return attributeColumn;
	}

	public Personage getPersonage() {
		return personage;
	}

}