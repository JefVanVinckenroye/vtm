package be.jef.entities;

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

import be.jef.enums.ColValue;

@Entity
@Table(name = "persattcolumns")
@NamedEntityGraph(name = "PersAttCol.metPersonageEnAttributeColumns", attributeNodes = {
		@NamedAttributeNode("personage"),
		@NamedAttributeNode("attributeColumns") })
public class PersAttCol implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long persAttColId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idattributeCol")
	AttributeColumns attributeColumns;
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

	public AttributeColumns getAttributeColumns() {
		return attributeColumns;
	}

	public Personage getPersonage() {
		return personage;
	}

}